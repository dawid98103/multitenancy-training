package pl.kobylarz.playground.core.master.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.kobylarz.playground.core.master.model.MasterTenant;
import pl.kobylarz.playground.core.master.repository.MasterTenantRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.kobylarz.playground.core.master.model",
        "pl.kobylarz.playground.core.master.repository"}, entityManagerFactoryRef = "masterEntityManagerFactory", transactionManagerRef = "masterTransactionManager")
class MasterDatabaseConfig {

    private final MasterDatabaseConfigProperties masterDatabaseConfigProperties;

    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setUsername(masterDatabaseConfigProperties.getUsername());
        ds.setPassword(masterDatabaseConfigProperties.getPassword());
        ds.setJdbcUrl(masterDatabaseConfigProperties.getUrl());
        ds.setDriverClassName(masterDatabaseConfigProperties.getDriverClassName());
        ds.setPoolName(masterDatabaseConfigProperties.getPoolName());

        // HikariCP settings
        // Maximum number of actual connection in the pool
        ds.setMaximumPoolSize(masterDatabaseConfigProperties.getMaxPoolSize());

        // Minimum number of idle connections in the pool
        ds.setMinimumIdle(masterDatabaseConfigProperties.getMinIdle());

        // Maximum waiting time for a connection from the pool
        ds.setConnectionTimeout(masterDatabaseConfigProperties.getConnectionTimeout());

        // Maximum time that a connection is allowed to sit idle in the pool
        ds.setIdleTimeout(masterDatabaseConfigProperties.getIdleTimeout());
        return ds;
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        // Set the master data source
        em.setDataSource(masterDataSource());

        // The master tenant entity and repository need to be scanned
        em.setPackagesToScan(
                new String[]{MasterTenant.class.getPackage().getName(),
                        MasterTenantRepository.class.getPackage().getName()});
        // Setting a name for the persistence unit as Spring sets it as
        // 'default' if not defined
        em.setPersistenceUnitName("masterdb-persistence-unit");

        // Setting Hibernate as the JPA provider
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Set the hibernate properties
        em.setJpaProperties(hibernateProperties());
        log.info("Setup of masterEntityManagerFactory succeeded.");
        return em;
    }

    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * The properties for configuring the JPA provider Hibernate.
     *
     * @return
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT,
                "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        return properties;
    }
}
