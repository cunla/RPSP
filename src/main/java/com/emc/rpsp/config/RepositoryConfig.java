package com.emc.rpsp.config;

import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by morand3 on 1/15/2015.
 */
@Configuration public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(SystemSettings.class);
        config.exposeIdsFor(ClusterSettings.class);
        // config.exposeIdsFor(VirtualMachineData.class);
    }
}
