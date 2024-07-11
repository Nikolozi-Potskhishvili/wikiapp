package org.springframework.boot.autoconfigure.thymeleaf;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ThymeleafProperties}.
 */
@Generated
public class ThymeleafProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'thymeleafProperties'.
   */
  public static BeanDefinition getThymeleafPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafProperties.class);
    beanDefinition.setInstanceSupplier(ThymeleafProperties::new);
    return beanDefinition;
  }
}
