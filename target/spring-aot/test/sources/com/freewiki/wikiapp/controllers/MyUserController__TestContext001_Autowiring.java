package com.freewiki.wikiapp.controllers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MyUserController}.
 */
@Generated
public class MyUserController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MyUserController apply(RegisteredBean registeredBean, MyUserController instance) {
    AutowiredFieldValueResolver.forRequiredField("myUserService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
