package com.emc.rpsp.virtualconfig.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.fal.commons.ClusterVirtualInfraConfiguration;
import com.emc.rpsp.fal.commons.DatacenterConfiguration;
import com.emc.rpsp.fal.commons.DatastoreConfiguration;
import com.emc.rpsp.fal.commons.EsxClusterConfiguration;
import com.emc.rpsp.fal.commons.EsxConfiguration;
import com.emc.rpsp.fal.commons.EsxUID;
import com.emc.rpsp.fal.commons.VirtualCenterConfiguration;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.virtualconfig.domain.DataCenterConfig;
import com.emc.rpsp.virtualconfig.domain.DataStoreConfig;
import com.emc.rpsp.virtualconfig.domain.EsxClusterConfig;
import com.emc.rpsp.virtualconfig.domain.EsxConfig;
import com.emc.rpsp.virtualconfig.domain.VcenterConfig;
import com.emc.rpsp.virtualconfig.service.VirtualConfigurationService;

@Service
public class VirtualConfigurationServiceImpl extends BaseServiceImpl implements
		VirtualConfigurationService {

	@Override
	public VcenterConfig getVirtualConfiguration(Long clusterId) {
		
		VcenterConfig vcenterConfig = new VcenterConfig();
		SystemSettings system = findSystemByCluster(clusterId);
		Client client = getClient(system);
		ClusterVirtualInfraConfiguration clusterVirtualConfig = 
					client.getClusterVirtualInfraConfiguration(clusterId);
		
		HashSet<VirtualCenterConfiguration> clusterVcs = clusterVirtualConfig.getVirtualCentersConfiguration();
		VirtualCenterConfiguration clusterVc = clusterVcs.stream().collect(Collectors.toList()).get(0);
		vcenterConfig.setId(clusterVc.getVirtualCenterUID().getUuid());
		vcenterConfig.setName(clusterVc.getName());
		
		Map<String, EsxConfig> idToEsxMap = new HashMap<String, EsxConfig>();
		
		for(DatacenterConfiguration dataCenter : clusterVc.getDatacentersConfiguration()){
			DataCenterConfig dataCenterConfig = new DataCenterConfig();
			vcenterConfig.addDataCenterConfig(dataCenterConfig);
			dataCenterConfig.setId(dataCenter.getDatacenterUID().getUuid());
			dataCenterConfig.setName(dataCenter.getName());
			for(EsxClusterConfiguration esxCluster : dataCenter.getEsxClustersConfiguration()){
				EsxClusterConfig esxClusterConfig = new EsxClusterConfig();
				dataCenterConfig.addEsxClusterConfig(esxClusterConfig);
				esxClusterConfig.setId(esxCluster.getEsxClusterUID().getUuid());
				esxClusterConfig.setName(esxCluster.getName());
				
				for(EsxConfiguration esxConfiguration : esxCluster.getEsxsConfiguration()){
					EsxConfig esxConfig = new EsxConfig();
					esxClusterConfig.addEsxConfig(esxConfig);
					esxConfig.setId(esxConfiguration.getEsxUID().getUuid());
					esxConfig.setName(esxConfiguration.getName());
					idToEsxMap.put(esxConfig.getId(), esxConfig);
				}
			}
			
			for(DatastoreConfiguration datastoreConfiguration : dataCenter.getDatastoresConfiguration()){
				DataStoreConfig dataStoreConfig = new DataStoreConfig();
				dataStoreConfig.setId(datastoreConfiguration.getDatastoreUID().getUuid());
				dataStoreConfig.setName(datastoreConfiguration.getName());
				Long capacityGB = datastoreConfiguration.getCapacity()/1000/1000/1000; 
				dataStoreConfig.setCapacity(capacityGB);
				Long freeSpaceGB = datastoreConfiguration.getFreeSpace()/1000/1000/1000;
				dataStoreConfig.setFreeSpace(freeSpaceGB);
				dataCenterConfig.addDatastore(dataStoreConfig);
				for(EsxUID esxUID : datastoreConfiguration.getRelevantEsxsUuids()){
					EsxConfig esxConfig = idToEsxMap.get(esxUID.getUuid());
					esxConfig.addDataStoreConfig(dataStoreConfig);
				}
			}
		}

		
		return vcenterConfig;
	}

}
