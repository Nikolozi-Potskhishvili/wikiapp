package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.SectionService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SectionController}.
 */
@Generated
public class SectionController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'sectionController'.
   */
  private static BeanInstanceSupplier<SectionController> getSectionControllerInstanceSupplier() {
    return BeanInstanceSupplier.<SectionController>forConstructor(SectionService.class, ArticleService.class)
            .withGenerator((registeredBean, args) -> new SectionController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'sectionController'.
   */
  public static BeanDefinition getSectionControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SectionController.class);
    beanDefinition.setInstanceSupplier(getSectionControllerInstanceSupplier());
    return beanDefinition;
  }
}
