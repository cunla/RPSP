package com.emc.rpsp;

import com.emc.rpsp.config.Constants;
import com.emc.rpsp.exceptions.RpspLoadingException;
import com.emc.rpsp.tools.PortBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication @EnableAsync @EnableScheduling @EnableTransactionManagement
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class })
//
public class Application {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    @Inject private Environment env;

    /**
     * Initializes app.
     * <p/>
     * Spring profiles can be configured with a program arguments
     * --spring.profiles.active=your-active-profile
     * <p/>
     */
    @PostConstruct public void initApplication() throws IOException {
        int port = Integer.valueOf(env.getProperty("server.port"));
        if (!PortBinding.available(port)) {
            log.error("Port {} unavailable, exiting", port);
            throw new RpspLoadingException("Port unavailable, exiting");
        }
        if (env.getActiveProfiles().length == 0) {
            log.warn("No Spring profile configured, running with default configuration");
        } else {
            log.info("Running with Spring profile(s) : {}",
                Arrays.toString(env.getActiveProfiles()));
        }
    }

    /**
     * Main method, used to run the application.
     */
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        addDefaultProfile(app, source);
        try {
            app.run(args);
        } catch (Exception e) {
            System.err.println("!!! Failed to start RPSP: " + e.getMessage());
            System.err.println("!!! Please send log files (rpsp.log) to daniel.moran@emc.com");
        }
    }

    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app,
        SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
