package com.emc.rpsp.rpsystems;

import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by morand3 on 2/9/2015.
 */
@RestController @RequestMapping("/app") public class ClustersResource {
    private final Logger log = LoggerFactory.getLogger(ClustersResource.class);
    @Inject private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @PersistenceContext private EntityManager em;

    @RequestMapping(value = "/rest/updateClusterForSystem/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<ClusterSettings> updateClusterForSystem(@PathVariable("id") Long id,
    @RequestBody ClusterSettings clusterSettings) {
        log.debug("Trying to update cluster settings for system {}", id);
        SystemSettings systemSettings = systemConnectionInfoRepository.findOne(id);
        for (ClusterSettings cluster : systemSettings.getClusters()) {
            if (cluster.getId() == clusterSettings.getId()) {
                log.debug("Updating cluster {} country to {} and business name to {}", id,
                clusterSettings.getCountry(), clusterSettings.getFriendlyName());
                cluster.setCountry(clusterSettings.getCountry());
                cluster.setFriendlyName(clusterSettings.getFriendlyName());
                em.merge(cluster);
                em.flush();
            }
        }
        return new ResponseEntity<>(clusterSettings, null, HttpStatus.OK);
    }
}
