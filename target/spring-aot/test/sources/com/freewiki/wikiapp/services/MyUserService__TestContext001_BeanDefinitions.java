package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.repository.MyUserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MyUserService}.
 */
@Generated
public class MyUserService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'myUserService'.
   */
  private static BeanInstanceSupplier<MyUserService> getMyUserServiceInstanceSupplier() {
    return BeanInstanceSupplier.<MyUserService>forConstructor(MyUserRepository.class)
            .withGenerator((registeredBean, args) -> new MyUserService(args.get(0)));
  }

  /**
   * Get the bean definition for 'myUserService'.
   */
  public static BeanDefinition getMyUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyUserService.class);
    beanDefinition.setInstanceSupplier(getMyUserServiceInstanceSupplier());
    return beanDefinition;
  }
}
