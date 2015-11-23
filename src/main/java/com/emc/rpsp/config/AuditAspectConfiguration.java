package com.emc.rpsp.config;

import com.emc.rpsp.config.auditing.AuditAspect;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration @EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.emc.rpsp.config.auditing",
entityManagerFactoryRef = "auditEmFactory", transactionManagerRef = "auditTransactionManager")
@EnableAspectJAutoProxy public class AuditAspectConfiguration implements EnvironmentAware {
    private final Logger log = LoggerFactory.getLogger(AuditAspectConfiguration.class);

    @Bean public AuditAspect loggingAspect() {
        return new AuditAspect();
    }

    private RelaxedPropertyResolver propertyResolver;
    private Environment env;
    private final String DB_URL = "AUDIT_DB_URL";
    private final String DB_USER = "AUDIT_DB_USER";
    private final String DB_PASSWORD = "AUDIT_DB_PASSWORD";

    @Override public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.auditing.");
    }

    @Autowired(required = false) private PersistenceUnitManager persistenceUnitManager;

    @Bean(name = "auditDatasource") public DataSource dataSource() {
        log.debug("Configuring Datasource");
        if (propertyResolver.getProperty("url") == null
        && propertyResolver.getProperty("databaseName") == null) {
            log.error("Your database connection pool configuration is incorrect! The application"
            + "cannot start. Please check your Spring profile, current profiles are: {}",
            Arrays.toString(env.getActiveProfiles()));

            throw new ApplicationContextException(
            "Database connection pool is not configured correctly");
        }
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(propertyResolver.getProperty("dataSourceClassName"));

        if (StringUtils.isNoneEmpty(env.getProperty(DB_URL))) {
            config.addDataSourceProperty("url", env.getProperty(DB_URL));
            if (org.apache.commons.lang3.StringUtils.isNoneEmpty(env.getProperty(DB_USER))) {
                config.addDataSourceProperty("user", env.getProperty(DB_USER));
            }
            if (StringUtils.isNoneEmpty(env.getProperty(DB_PASSWORD))) {
                config.addDataSourceProperty("password", env.getProperty(DB_PASSWORD));
            }
        } else {
            if (propertyResolver.getProperty("url") == null || ""
            .equals(propertyResolver.getProperty("url"))) {
                config.addDataSourceProperty("databaseName",
                propertyResolver.getProperty("databaseName"));
                config
                .addDataSourceProperty("serverName", propertyResolver.getProperty("serverName"));
            } else {
                config.addDataSourceProperty("url", propertyResolver.getProperty("url"));
            }
            config.addDataSourceProperty("user", propertyResolver.getProperty("username"));
            config.addDataSourceProperty("password", propertyResolver.getProperty("password"));
        }

        return new HikariDataSource(config);
    }


    @Bean(name = "emfb2") public EntityManagerFactoryBuilder entityManagerFactoryBuilder1() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        JpaProperties jpaProps = jpaProperties();
        adapter.setShowSql(jpaProps.isShowSql());
        adapter.setDatabase(jpaProps.getDatabase());
        adapter.setDatabasePlatform(jpaProps.getDatabasePlatform());
        adapter.setGenerateDdl(jpaProps.isGenerateDdl());

        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(adapter,
        jpaProps.getProperties(), this.persistenceUnitManager);
        return builder;
    }

    @Bean(name = "auditEmFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(
    @Qualifier("auditDatasource") DataSource dataSource,
    @Qualifier("emfb2") EntityManagerFactoryBuilder factoryBuilder) {
        //        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(env,
        //        "spring.jpa.properties.");
        //        Map<String, Object> vendorProperties = relaxedPropertyResolver.getSubProperties(null);
        return factoryBuilder.dataSource(dataSource).packages("com.emc.rpsp.config.auditing")
        //        .properties(vendorProperties)
        .persistenceUnit("audit").build();
    }

    @Bean(name = "auditTransactionManager")
    public PlatformTransactionManager auditTransactionManager(
    @Qualifier("auditEmFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    @ConfigurationProperties("spring.jpa")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }
}
