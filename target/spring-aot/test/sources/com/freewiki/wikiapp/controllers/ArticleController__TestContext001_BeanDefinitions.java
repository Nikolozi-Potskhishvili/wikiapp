package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.MyUserService;
import com.freewiki.wikiapp.services.ParagraphService;
import com.freewiki.wikiapp.services.SectionService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ArticleController}.
 */
@Generated
public class ArticleController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'articleController'.
   */
  private static BeanInstanceSupplier<ArticleController> getArticleControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ArticleController>forConstructor(ArticleService.class, ParagraphService.class, SectionService.class, MyUserService.class)
            .withGenerator((registeredBean, args) -> new ArticleController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'articleController'.
   */
  public static BeanDefinition getArticleControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ArticleController.class);
    beanDefinition.setInstanceSupplier(getArticleControllerInstanceSupplier());
    return beanDefinition;
  }
}
