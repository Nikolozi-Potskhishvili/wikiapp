package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.ParagraphService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ParagraphController}.
 */
@Generated
public class ParagraphController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'paragraphController'.
   */
  private static BeanInstanceSupplier<ParagraphController> getParagraphControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ParagraphController>forConstructor(ParagraphService.class, ArticleService.class)
            .withGenerator((registeredBean, args) -> new ParagraphController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'paragraphController'.
   */
  public static BeanDefinition getParagraphControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParagraphController.class);
    beanDefinition.setInstanceSupplier(getParagraphControllerInstanceSupplier());
    return beanDefinition;
  }
}
