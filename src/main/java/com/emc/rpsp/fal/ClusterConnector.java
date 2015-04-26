package com.emc.rpsp.fal;

import com.emc.fapi.jaxws.*;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by morand3 on 1/13/2015.
 */
public interface ClusterConnector {
	static final String BASE_URL = "";

	@GET(BASE_URL + "system/version")
	public RecoverPointVersion getSystemVersion();

	@GET(BASE_URL + "settings")
	public FullRecoverPointSettings getFullRecoverPointSettings();

	@GET(BASE_URL + "time/current_time")
	public RecoverPointTimeStamp getSystemTime();

	@GET(BASE_URL + "system/virtual_infrastructures/state")
	public ClusterVirtualInfrastructuresStateSet getVirtualInfrastructuresStateFromAllCluster();

	@GET(BASE_URL + "clusters/{clusterId}/virtual_infrastructures/state")
	public ClusterVirtualInfrastructuresState getVirtualInfrastructuresStateFromCluster(
	        @Path("clusterId") long clusterId);

	@GET(BASE_URL + "clusters")
	public RecoverPointClustersInformation getRpClustersInformation();

	@GET(BASE_URL + "groups/{groupId}/copies/settings")
	public ConsistencyGroupCopySettingsSet getAllGroupCopies(
	        @Path("groupId") long groupId);

	@GET(BASE_URL + "groups")
	public ConsistencyGroupUIDSet getAllGroupsUIDs();

}
