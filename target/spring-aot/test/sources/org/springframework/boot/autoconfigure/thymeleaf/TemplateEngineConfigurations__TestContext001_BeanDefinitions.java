package org.springframework.boot.autoconfigure.thymeleaf;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.thymeleaf.spring6.SpringTemplateEngine;

/**
 * Bean definitions for {@link TemplateEngineConfigurations}.
 */
@Generated
public class TemplateEngineConfigurations__TestContext001_BeanDefinitions {
  /**
   * Bean definitions for {@link TemplateEngineConfigurations.DefaultTemplateEngineConfiguration}.
   */
  @Generated
  public static class DefaultTemplateEngineConfiguration {
    /**
     * Get the bean definition for 'defaultTemplateEngineConfiguration'.
     */
    public static BeanDefinition getDefaultTemplateEngineConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class);
      beanDefinition.setInstanceSupplier(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'templateEngine'.
     */
    private static BeanInstanceSupplier<SpringTemplateEngine> getTemplateEngineInstanceSupplier() {
      return BeanInstanceSupplier.<SpringTemplateEngine>forFactoryMethod(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class, "templateEngine", ThymeleafProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class).templateEngine(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'templateEngine'.
     */
    public static BeanDefinition getTemplateEngineBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringTemplateEngine.class);
      beanDefinition.setInstanceSupplier(getTemplateEngineInstanceSupplier());
      return beanDefinition;
    }
  }
}
