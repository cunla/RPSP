package com.emc.rpsp.config;

import java.util.Arrays;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration @EnableJpaRepositories({ "com.emc.rpsp.repository", "com.emc.rpsp.mgmt",
"com.emc.rpsp.accounts.repository", "com.emc.rpsp.vms.repository",
"com.emc.rpsp.users.repository" })
// @EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement public class DatabaseConfiguration implements EnvironmentAware {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private RelaxedPropertyResolver propertyResolver;

    private Environment env;
    
    private final String DB_URL = "DB_URL";
    private final String DB_USER = "DB_USER";
    private final String DB_PASSWORD = "DB_PASSWORD";

    @Override public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean(destroyMethod = "shutdown") @Profile("!" + Constants.SPRING_PROFILE_CLOUD)
    public DataSource dataSource() {
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
        
        if(org.apache.commons.lang3.StringUtils.isNoneEmpty(env.getProperty(DB_URL))){
        	config.addDataSourceProperty("url", env.getProperty(DB_URL));
        	
        	if(org.apache.commons.lang3.StringUtils.isNoneEmpty(env.getProperty(DB_USER))){
            	config.addDataSourceProperty("user", env.getProperty(DB_USER));
            }
        	
        	if(org.apache.commons.lang3.StringUtils.isNoneEmpty(env.getProperty(DB_PASSWORD))){
            	config.addDataSourceProperty("password", env.getProperty(DB_PASSWORD));
            }
        }
        else{
	        if (propertyResolver.getProperty("url") == null || ""
	        .equals(propertyResolver.getProperty("url"))) {
	            config
	            .addDataSourceProperty("databaseName", propertyResolver.getProperty("databaseName"));
	            config.addDataSourceProperty("serverName", propertyResolver.getProperty("serverName"));
	        } else {
	            config.addDataSourceProperty("url", propertyResolver.getProperty("url"));
	        }
	        config.addDataSourceProperty("user", propertyResolver.getProperty("username"));
	        config.addDataSourceProperty("password", propertyResolver.getProperty("password"));
        }
    
        

        return new HikariDataSource(config);
    }

    @Bean public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setContexts("development, production");
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_FAST)) {
            liquibase.setShouldRun(false);
        } else {
            log.debug("Configuring Liquibase");
        }
        return liquibase;
    }

    @Bean public Hibernate4Module hibernate4Module() {
        return new Hibernate4Module();
    }
}
