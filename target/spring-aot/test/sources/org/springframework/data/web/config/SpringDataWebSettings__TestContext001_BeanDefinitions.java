package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDataWebSettings}.
 */
@Generated
public class SpringDataWebSettings__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.data.web.config.SpringDataWebSettings'.
   */
  private static BeanInstanceSupplier<SpringDataWebSettings> getSpringDataWebSettingsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDataWebSettings>forConstructor(EnableSpringDataWebSupport.PageSerializationMode.class)
            .withGenerator((registeredBean, args) -> new SpringDataWebSettings(args.get(0)));
  }

  /**
   * Get the bean definition for 'springDataWebSettings'.
   */
  public static BeanDefinition getSpringDataWebSettingsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebSettings.class);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, EnableSpringDataWebSupport.PageSerializationMode.DIRECT);
    beanDefinition.setInstanceSupplier(getSpringDataWebSettingsInstanceSupplier());
    return beanDefinition;
  }
}
