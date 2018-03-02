package org.craftercms.studio.impl.v1.asset.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;

import org.apache.commons.io.FilenameUtils;
import org.craftercms.studio.api.v1.asset.Asset;
import org.craftercms.studio.api.v1.asset.processing.AssetProcessor;
import org.craftercms.studio.api.v1.asset.processing.AssetProcessorFactory;
import org.craftercms.studio.api.v1.asset.processing.ProcessorConfiguration;
import org.craftercms.studio.api.v1.asset.processing.ProcessorPipelineConfiguration;
import org.craftercms.studio.api.v1.exception.AssetProcessingException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AssetProcessorPipelineImplTest {

    private static final String INPUT_REPO_PATH = "/static-assets/images/upload/test-image.jpg";
    private static final String INPUT_PATH_PATTERN = "/static-assets/images/upload/([^/]+)\\.jpg";
    private static final String SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE = "sameInputAsOutput";
    private static final String RANDOM_OUTPUT_PROCESSOR_TYPE = "randomOutput";

    private AssetProcessorPipelineImpl pipeline;

    @BeforeMethod
    public void setUp() throws Exception {
        pipeline = new AssetProcessorPipelineImpl(createProcessorFactory());
    }

    @Test
    public void testProcessSameInputAsOutput() throws Exception {
        pipeline.init(createPipelineConfig(true, SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE, SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE));

        Path inputFile = createInputFile();
        Asset input = new Asset(INPUT_REPO_PATH, inputFile);

        List<Asset> outputs = pipeline.processAsset(input);

        assertNotNull(outputs);
        assertEquals(outputs.size(), 1);
        assertEquals(outputs.get(0).getRepoPath(), input.getRepoPath());
        assertEquals(outputs.get(0).getFile(), input.getFile());
    }

    @Test
    public void testProcessNewOutputKeepOriginal() throws Exception {
        pipeline.init(createPipelineConfig(true, SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE, RANDOM_OUTPUT_PROCESSOR_TYPE));

        Path inputFile = createInputFile();
        Asset input = new Asset(INPUT_REPO_PATH, inputFile);

        List<Asset> outputs = pipeline.processAsset(input);

        assertNotNull(outputs);
        assertEquals(2, outputs.size());
        assertEquals(outputs.get(0).getRepoPath(), input.getRepoPath());
        assertEquals(outputs.get(0).getFile(), input.getFile());
        assertNotEquals(outputs.get(1).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(1).getFile(), input.getFile());
    }

    @Test
    public void testProcessNewOutputDropOriginal() throws Exception {
        pipeline.init(createPipelineConfig(false, SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE, RANDOM_OUTPUT_PROCESSOR_TYPE));

        Path inputFile = createInputFile();
        Asset input = new Asset(INPUT_REPO_PATH, inputFile);

        List<Asset> outputs = pipeline.processAsset(input);

        assertNotNull(outputs);
        assertEquals(outputs.size(), 1);
        assertNotEquals(outputs.get(0).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(0).getFile(), input.getFile());
    }

    @Test
    public void testProcessMultipleNewOutputsKeepOriginal() throws Exception {
        pipeline.init(createPipelineConfig(true, RANDOM_OUTPUT_PROCESSOR_TYPE, RANDOM_OUTPUT_PROCESSOR_TYPE));

        Path inputFile = createInputFile();
        Asset input = new Asset(INPUT_REPO_PATH, inputFile);

        List<Asset> outputs = pipeline.processAsset(input);

        assertNotNull(outputs);
        assertEquals(outputs.size(), 3);
        assertEquals(outputs.get(0).getRepoPath(), input.getRepoPath());
        assertEquals(outputs.get(0).getFile(), input.getFile());
        assertNotEquals(outputs.get(1).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(1).getFile(), input.getFile());
        assertNotEquals(outputs.get(2).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(2).getFile(), input.getFile());
    }

    @Test
    public void testProcessMultipleNewOutputsDropOriginal() throws Exception {
        pipeline.init(createPipelineConfig(false, RANDOM_OUTPUT_PROCESSOR_TYPE, RANDOM_OUTPUT_PROCESSOR_TYPE));

        Path inputFile = createInputFile();
        Asset input = new Asset(INPUT_REPO_PATH, inputFile);

        List<Asset> outputs = pipeline.processAsset(input);

        assertNotNull(outputs);
        assertEquals(outputs.size(), 2);
        assertNotEquals(outputs.get(0).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(0).getFile(), input.getFile());
        assertNotEquals(outputs.get(1).getRepoPath(), input.getRepoPath());
        assertNotEquals(outputs.get(1).getFile(), input.getFile());
    }

    private ProcessorPipelineConfiguration createPipelineConfig(boolean keepOriginal, String... processorTypes) {
        List<ProcessorConfiguration> processorsConfig = new ArrayList<>(processorTypes.length);

        for (String processorType : processorTypes) {
            ProcessorConfiguration processorConfig = new ProcessorConfiguration();
            processorConfig.setType(processorType);

            processorsConfig.add(processorConfig);
        }

        ProcessorPipelineConfiguration config = new ProcessorPipelineConfiguration();
        config.setKeepOriginal(keepOriginal);
        config.setInputPathPattern(INPUT_PATH_PATTERN);
        config.setProcessorsConfig(processorsConfig);

        return config;
    }

    private AssetProcessorFactory createProcessorFactory() {
        return config -> {
            if (config.getType().equals(SAME_INPUT_AS_OUTPUT_PROCESSOR_TYPE)) {
                return createProcessorThatReturnsSameInputAsOutput();
            } else {
                return createProcessorThatReturnsRandomOutput();
            }
        };
    }

    private AssetProcessor createProcessorThatReturnsSameInputAsOutput() {
        return new AssetProcessor() {

            @Override
            public void init(ProcessorConfiguration config) {
            }

            @Override
            public Asset processAsset(Matcher inputPathMatcher, Asset input) throws AssetProcessingException {
                return input;
            }

        };
    }

    private AssetProcessor createProcessorThatReturnsRandomOutput() {
        return new AssetProcessor() {

            @Override
            public void init(ProcessorConfiguration config) {
            }

            @Override
            public Asset processAsset(Matcher inputPathMatcher, Asset input) throws AssetProcessingException {
                String filename = UUID.randomUUID().toString();
                String repoPath = "/static-assets/images/transformed/" + filename + ".jpg";

                try {
                    return new Asset(repoPath, Files.createTempFile(filename, "." + ".jpg"));
                } catch (IOException e) {
                    throw new AssetProcessingException(e);
                }
            }

        };
    }

    private Path createInputFile() throws IOException {
        return Files.createTempFile(FilenameUtils.getBaseName(INPUT_REPO_PATH), "." + FilenameUtils.getExtension(INPUT_REPO_PATH));
    }

}
