package org.craftercms.studio.impl.v1.asset.processing;

import org.craftercms.studio.api.v1.asset.processing.AssetProcessor;
import org.craftercms.studio.api.v1.asset.processing.AssetProcessorFactory;
import org.craftercms.studio.api.v1.asset.processing.ProcessorConfiguration;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AssetProcessorFactoryImpl implements AssetProcessorFactory, ApplicationContextAware {

    private String beanNameFormat;
    private ApplicationContext applicationContext;

    @Required
    public void setBeanNameFormat(String beanNameFormat) {
        this.beanNameFormat = beanNameFormat;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public AssetProcessor getProcessor(ProcessorConfiguration config) {
        String beanName = String.format(beanNameFormat, config.getType());

        AssetProcessor processor = applicationContext.getBean(beanName, AssetProcessor.class);
        processor.init(config);

        return processor;
    }

}
