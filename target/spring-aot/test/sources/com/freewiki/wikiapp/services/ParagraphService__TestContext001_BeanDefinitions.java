package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.repository.ParagraphRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ParagraphService}.
 */
@Generated
public class ParagraphService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'paragraphService'.
   */
  private static BeanInstanceSupplier<ParagraphService> getParagraphServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ParagraphService>forConstructor(ParagraphRepository.class)
            .withGenerator((registeredBean, args) -> new ParagraphService(args.get(0)));
  }

  /**
   * Get the bean definition for 'paragraphService'.
   */
  public static BeanDefinition getParagraphServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParagraphService.class);
    beanDefinition.setInstanceSupplier(getParagraphServiceInstanceSupplier());
    return beanDefinition;
  }
}
