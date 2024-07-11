package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.repository.ArticleRepository;
import com.freewiki.wikiapp.repository.SectionRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ArticleService}.
 */
@Generated
public class ArticleService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'articleService'.
   */
  private static BeanInstanceSupplier<ArticleService> getArticleServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ArticleService>forConstructor(ArticleRepository.class, SectionRepository.class)
            .withGenerator((registeredBean, args) -> new ArticleService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'articleService'.
   */
  public static BeanDefinition getArticleServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ArticleService.class);
    beanDefinition.setInstanceSupplier(getArticleServiceInstanceSupplier());
    return beanDefinition;
  }
}
