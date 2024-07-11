package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.services.MyUserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MyUserController}.
 */
@Generated
public class MyUserController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'myUserController'.
   */
  private static BeanInstanceSupplier<MyUserController> getMyUserControllerInstanceSupplier() {
    return BeanInstanceSupplier.<MyUserController>forConstructor(MyUserService.class)
            .withGenerator((registeredBean, args) -> new MyUserController(args.get(0)));
  }

  /**
   * Get the bean definition for 'myUserController'.
   */
  public static BeanDefinition getMyUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyUserController.class);
    InstanceSupplier<MyUserController> instanceSupplier = getMyUserControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(MyUserController__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
