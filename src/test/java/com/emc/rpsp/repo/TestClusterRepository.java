package com.emc.rpsp.repo;

import com.emc.rpsp.Application;
import com.emc.rpsp.RpspException;
import com.emc.rpsp.config.Constants;
import com.emc.rpsp.domain.SystemSettings;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by morand3 on 1/14/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles(value = Constants.SPRING_PROFILE_DEVELOPMENT)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class TestClusterRepository {
    @Inject
    private SystemConnectionInfoRepository clustersRepository;

    private MockMvc restUserMockMvc;

    @Test
     public void testAddNew() {
        int existingCount = clustersRepository.findAll().size();
       clustersRepository.saveAndFlush(getGoodClustersConnectionSettings());
        int currentExisting = clustersRepository.findAll().size();
        assertTrue(currentExisting == existingCount + 1);
    }

    @Test(expected = RpspException.class)
    public void testRemove() {
        int existingCount = clustersRepository.findAll().size();
        SystemSettings settings = getBadClustersConnectionSettings();
        int currentExisting = clustersRepository.findAll().size();
        assertTrue(currentExisting == existingCount + 1);
    }

    private SystemSettings getGoodClustersConnectionSettings(){
        SystemSettings settings = new SystemSettings("10.76.16.150", "admin", "admin");
        Client client = new Client(settings);
        client.getSystemTime();
        return settings;
    }

    private SystemSettings getBadClustersConnectionSettings(){
        SystemSettings settings = new SystemSettings("10.76.16.x", "admin", "admin");
        Client client = new Client(settings);
        client.getSystemTime();
        return settings;
    }
}
