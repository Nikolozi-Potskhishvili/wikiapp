package org.springframework.boot.autoconfigure.thymeleaf;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

/**
 * Bean definitions for {@link ThymeleafAutoConfiguration}.
 */
@Generated
public class ThymeleafAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'thymeleafAutoConfiguration'.
   */
  public static BeanDefinition getThymeleafAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ThymeleafAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration}.
   */
  @Generated
  public static class DefaultTemplateResolverConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$DefaultTemplateResolverConfiguration'.
     */
    private static BeanInstanceSupplier<ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration> getDefaultTemplateResolverConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration>forConstructor(ThymeleafProperties.class, ApplicationContext.class)
              .withGenerator((registeredBean, args) -> new ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'defaultTemplateResolverConfiguration'.
     */
    public static BeanDefinition getDefaultTemplateResolverConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class);
      beanDefinition.setInstanceSupplier(getDefaultTemplateResolverConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'defaultTemplateResolver'.
     */
    private static BeanInstanceSupplier<SpringResourceTemplateResolver> getDefaultTemplateResolverInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SpringResourceTemplateResolver>forFactoryMethod(ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class, "defaultTemplateResolver")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class).defaultTemplateResolver());
    }

    /**
     * Get the bean definition for 'defaultTemplateResolver'.
     */
    public static BeanDefinition getDefaultTemplateResolverBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringResourceTemplateResolver.class);
      beanDefinition.setInstanceSupplier(getDefaultTemplateResolverInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration}.
   */
  @Generated
  public static class ThymeleafWebMvcConfiguration {
    /**
     * Get the bean definition for 'thymeleafWebMvcConfiguration'.
     */
    public static BeanDefinition getThymeleafWebMvcConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.class);
      beanDefinition.setInstanceSupplier(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration::new);
      return beanDefinition;
    }

    /**
     * Bean definitions for {@link ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration}.
     */
    @Generated
    public static class ThymeleafViewResolverConfiguration {
      /**
       * Get the bean definition for 'thymeleafViewResolverConfiguration'.
       */
      public static BeanDefinition getThymeleafViewResolverConfigurationBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class);
        beanDefinition.setInstanceSupplier(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration::new);
        return beanDefinition;
      }

      /**
       * Get the bean instance supplier for 'thymeleafViewResolver'.
       */
      private static BeanInstanceSupplier<ThymeleafViewResolver> getThymeleafViewResolverInstanceSupplier(
          ) {
        return BeanInstanceSupplier.<ThymeleafViewResolver>forFactoryMethod(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class, "thymeleafViewResolver", ThymeleafProperties.class, SpringTemplateEngine.class)
                .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class).thymeleafViewResolver(args.get(0), args.get(1)));
      }

      /**
       * Get the bean definition for 'thymeleafViewResolver'.
       */
      public static BeanDefinition getThymeleafViewResolverBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(ThymeleafViewResolver.class);
        beanDefinition.setInstanceSupplier(getThymeleafViewResolverInstanceSupplier());
        return beanDefinition;
      }
    }
  }
}
