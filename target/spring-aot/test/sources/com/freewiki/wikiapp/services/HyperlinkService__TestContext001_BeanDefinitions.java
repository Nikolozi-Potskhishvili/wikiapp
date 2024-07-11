package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.repository.HyperlinkRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HyperlinkService}.
 */
@Generated
public class HyperlinkService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'hyperlinkService'.
   */
  private static BeanInstanceSupplier<HyperlinkService> getHyperlinkServiceInstanceSupplier() {
    return BeanInstanceSupplier.<HyperlinkService>forConstructor(HyperlinkRepository.class)
            .withGenerator((registeredBean, args) -> new HyperlinkService(args.get(0)));
  }

  /**
   * Get the bean definition for 'hyperlinkService'.
   */
  public static BeanDefinition getHyperlinkServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HyperlinkService.class);
    beanDefinition.setInstanceSupplier(getHyperlinkServiceInstanceSupplier());
    return beanDefinition;
  }
}
