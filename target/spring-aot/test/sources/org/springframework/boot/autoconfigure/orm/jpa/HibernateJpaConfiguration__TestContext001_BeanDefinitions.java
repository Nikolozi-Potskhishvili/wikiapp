package org.springframework.boot.autoconfigure.orm.jpa;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypes;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Bean definitions for {@link HibernateJpaConfiguration}.
 */
@Generated
public class HibernateJpaConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration'.
   */
  private static BeanInstanceSupplier<HibernateJpaConfiguration> getHibernateJpaConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HibernateJpaConfiguration>forConstructor(DataSource.class, JpaProperties.class, ConfigurableListableBeanFactory.class, ObjectProvider.class, HibernateProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> new HibernateJpaConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7), args.get(8), args.get(9)));
  }

  /**
   * Get the bean definition for 'hibernateJpaConfiguration'.
   */
  public static BeanDefinition getHibernateJpaConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HibernateJpaConfiguration.class);
    beanDefinition.setInstanceSupplier(getHibernateJpaConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'transactionManager'.
   */
  private static BeanInstanceSupplier<PlatformTransactionManager> getTransactionManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PlatformTransactionManager>forFactoryMethod(HibernateJpaConfiguration.class, "transactionManager", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HibernateJpaConfiguration.class).transactionManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'transactionManager'.
   */
  public static BeanDefinition getTransactionManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlatformTransactionManager.class);
    beanDefinition.setInstanceSupplier(getTransactionManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jpaVendorAdapter'.
   */
  private static BeanInstanceSupplier<JpaVendorAdapter> getJpaVendorAdapterInstanceSupplier() {
    return BeanInstanceSupplier.<JpaVendorAdapter>forFactoryMethod(HibernateJpaConfiguration.class, "jpaVendorAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HibernateJpaConfiguration.class).jpaVendorAdapter());
  }

  /**
   * Get the bean definition for 'jpaVendorAdapter'.
   */
  public static BeanDefinition getJpaVendorAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaVendorAdapter.class);
    beanDefinition.setInstanceSupplier(getJpaVendorAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'entityManagerFactoryBuilder'.
   */
  private static BeanInstanceSupplier<EntityManagerFactoryBuilder> getEntityManagerFactoryBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EntityManagerFactoryBuilder>forFactoryMethod(HibernateJpaConfiguration.class, "entityManagerFactoryBuilder", JpaVendorAdapter.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HibernateJpaConfiguration.class).entityManagerFactoryBuilder(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'entityManagerFactoryBuilder'.
   */
  public static BeanDefinition getEntityManagerFactoryBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EntityManagerFactoryBuilder.class);
    beanDefinition.setInstanceSupplier(getEntityManagerFactoryBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'entityManagerFactory'.
   */
  private static BeanInstanceSupplier<LocalContainerEntityManagerFactoryBean> getEntityManagerFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LocalContainerEntityManagerFactoryBean>forFactoryMethod(HibernateJpaConfiguration.class, "entityManagerFactory", EntityManagerFactoryBuilder.class, PersistenceManagedTypes.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HibernateJpaConfiguration.class).entityManagerFactory(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'entityManagerFactory'.
   */
  public static BeanDefinition getEntityManagerFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocalContainerEntityManagerFactoryBean.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getEntityManagerFactoryInstanceSupplier());
    return beanDefinition;
  }
}
