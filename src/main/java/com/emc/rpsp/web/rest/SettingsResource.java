package com.emc.rpsp.web.rest;

import com.emc.rpsp.RpspException;
import com.emc.rpsp.domain.ClusterSettings;
import com.emc.rpsp.domain.SystemSettings;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import org.apache.commons.httpclient.protocol.InetAddressUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by morand3 on 1/29/2015.
 */
@RestController
@RequestMapping("/app")
public class SettingsResource {
    private final Logger log = LoggerFactory.getLogger(SettingsResource.class);

    @Inject
    private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @RequestMapping(value = "/rest/testSystem/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SystemSettings>> testSystem(@PathVariable("id") Long id) {
        log.debug("Testing systemSettings with id {}", id);
        SystemSettings systemSettings = systemConnectionInfoRepository.findOne(id);
        Client client = new Client(systemSettings);
        client.getSystemTime();
        systemConnectionInfoRepository.saveAndFlush(systemSettings);
        return Optional.ofNullable(systemConnectionInfoRepository.findAll()).map(
                clusterSettings -> new ResponseEntity<>(clusterSettings, HttpStatus.OK)).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/rest/addSystem",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SystemSettings>> addNewSystem(@RequestBody SystemSettings systemSettings) {
        log.debug("Adding new systemSettings to the system {}", systemSettings);
        validateNewSystem(systemSettings);
        validateSystemData(systemSettings);
        propagateClusterData(systemSettings);
        validateNewClusters(systemSettings);

        systemConnectionInfoRepository.saveAndFlush(systemSettings);

        log.debug("Returning list of all clusters");
        return Optional.ofNullable(systemConnectionInfoRepository.findAll()).map(
                clusterSettings -> new ResponseEntity<>(clusterSettings, HttpStatus.OK)).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private void validateNewClusters(SystemSettings systemSettings) {
        for (ClusterSettings cluster : systemSettings.getClusters()) {
            List<ClusterSettings> results = systemConnectionInfoRepository.findCluster(cluster.getClusterId());
            if (!results.isEmpty()) {
                String error = String.format("Only a single vRPA cluster can be added per RecoverPoint for VM system. \n" +
                        "The other cluster(s) are added automatically by the system");
                log.warn("Entry for cluster {} exists already in system {}", cluster.getClusterId(),
                        cluster.getSystemSettings().getSystemIp());
                throw new RpspException(error);
            }
        }
    }

    private void propagateClusterData(SystemSettings systemSettings) {
        Client client = new Client(systemSettings, systemConnectionInfoRepository);
        client.getSystemTime();
        Map<Long, String> clusters = client.getClusterNames();
        for (Map.Entry<Long, String> entry : clusters.entrySet()) {
            ClusterSettings cluster = new ClusterSettings(entry.getKey(), entry.getValue(), systemSettings);
            systemSettings.addCluster(cluster);
        }
    }

    private void validateNewSystem(SystemSettings cluster) {
        List<SystemSettings> clustersWithIp =
                systemConnectionInfoRepository.findClustersWithIpAddress(cluster.getSystemIp());
        if (clustersWithIp.size() > 0) {
            log.error("Entry with IP {} exists already", cluster.getSystemIp());
            throw new RpspException("Entry with IP " + cluster.getSystemIp() + " exists already");
        }
    }

    private void validateSystemData(SystemSettings settings) {
        if(!InetAddressUtils.isIPv4Address(settings.getSystemIp())) {
            if (InetAddressUtils.isIPv6Address(settings.getSystemIp())){
                settings.setSystemIp("["+settings.getSystemIp()+"]");
            }else{
                log.error("Not a valid IP address for cluster {}", settings);
                throw new RpspException("Not a valid IP address");
            }
        }
    }
}
