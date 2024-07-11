package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.repository.ParagraphRepository;
import com.freewiki.wikiapp.repository.SectionRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SectionService}.
 */
@Generated
public class SectionService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'sectionService'.
   */
  private static BeanInstanceSupplier<SectionService> getSectionServiceInstanceSupplier() {
    return BeanInstanceSupplier.<SectionService>forConstructor(SectionRepository.class, ParagraphRepository.class)
            .withGenerator((registeredBean, args) -> new SectionService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'sectionService'.
   */
  public static BeanDefinition getSectionServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SectionService.class);
    beanDefinition.setInstanceSupplier(getSectionServiceInstanceSupplier());
    return beanDefinition;
  }
}
