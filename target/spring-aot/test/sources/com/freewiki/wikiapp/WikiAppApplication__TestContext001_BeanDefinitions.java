package com.freewiki.wikiapp;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WikiAppApplication}.
 */
@Generated
public class WikiAppApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'wikiAppApplication'.
   */
  public static BeanDefinition getWikiAppApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WikiAppApplication.class);
    beanDefinition.setTargetType(WikiAppApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(WikiAppApplication.class);
    beanDefinition.setInstanceSupplier(WikiAppApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
