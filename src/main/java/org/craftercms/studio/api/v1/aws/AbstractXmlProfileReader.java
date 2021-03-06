package org.craftercms.studio.api.v1.aws;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.craftercms.studio.api.v1.aws.AwsProfile;
import org.craftercms.studio.api.v1.aws.AwsProfileReader;
import org.craftercms.studio.api.v1.exception.AwsConfigurationException;
import com.amazonaws.auth.BasicAWSCredentials;

/**
 * Class with common methods for XML {@link AwsProfileReader} implementations.
 * @param <T> The type of {@link AwsProfile} that will be parsed.
 *
 * @author joseross
 */
public abstract class AbstractXmlProfileReader<T extends AwsProfile> implements AwsProfileReader<T> {

    public static List<HierarchicalConfiguration> getRequiredConfigurationsAt(HierarchicalConfiguration config,
                                                                              String key) throws AwsConfigurationException {
        List<HierarchicalConfiguration> configs = config.configurationsAt(key);
        if (CollectionUtils.isEmpty(configs)) {
            throw new AwsConfigurationException("Missing required property '" + key + "'");
        } else {
            return configs;
        }
    }

    protected String getRequiredStringProperty(Configuration config, String key) throws AwsConfigurationException {
        String property = config.getString(key);
        if (StringUtils.isEmpty(property)) {
            throw new AwsConfigurationException("Missing required property '" + key + "'");
        } else {
            return property;
        }
    }

    protected void readBasicProperties(Configuration config, T profile) throws AwsConfigurationException {
        String accessKey = getRequiredStringProperty(config, "credentials.accessKey");
        String secretKey = getRequiredStringProperty(config, "credentials.secretKey");

        profile.setCredentials(new BasicAWSCredentials(accessKey, secretKey));
        profile.setRegion(getRequiredStringProperty(config, "region"));
    }

}
