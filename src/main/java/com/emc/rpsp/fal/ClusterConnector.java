package com.emc.rpsp.fal;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfraConfiguration;
import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresState;
import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySettingsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupLinkPolicy;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSetSettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSetSubset;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSnapshots;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStatisticsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupTopologyParams;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupUIDSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupVolumesStateSet;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkForGroupSetSubSetParams;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkParams;
import com.emc.fapi.jaxws.v4_3.DisableImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessForGroupSetsSubsetParams;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.EnableLatestImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EnableLatestImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.FullRecoverPointSettings;
import com.emc.fapi.jaxws.v4_3.RecoverPointClustersInformation;
import com.emc.fapi.jaxws.v4_3.RecoverPointTimeStamp;
import com.emc.fapi.jaxws.v4_3.RecoverPointVersion;
import com.emc.fapi.jaxws.v4_3.VmEntitiesInformationSet;
import com.emc.fapi.jaxws.v4_3.VmPowerUpSequenceParamSet;
import com.emc.fapi.jaxws.v4_3.VmReplicationSetParamSet;
import com.emc.fapi.jaxws.v4_3.VmUIDSet;

/**
 * Created by morand3 on 1/13/2015.
 */
public interface ClusterConnector {
	static final String BASE_URL = "/";

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

	@PUT(BASE_URL
			+ "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image_access/latest/enable")
	public EnableLatestImageAccessResponse enableLatestImageAccess(
			@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId,
			@Body EnableLatestImageAccessParams params);

	@PUT(BASE_URL
			+ "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/enable_image_access")
	public EnableImageAccessResponse enableSnapshotImageAccess(
			@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId, @Body EnableImageAccessParams params);

	@PUT(BASE_URL
			+ "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/disable_image_access?startTransfer=true")
	public DisableImageAccessResponse disableLatestImageAccess(
			@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId);

	@GET(BASE_URL + "groups/state")
	public ConsistencyGroupStateSet getConsistencyGroupStateSet();

	@GET(BASE_URL + "groups/volumes/state")
	public ConsistencyGroupVolumesStateSet getConsistencyGroupVolumesStateSet();

	@GET(BASE_URL + "groups/{groupId}/snapshots")
	public ConsistencyGroupSnapshots getGroupSnapshots(
			@Path("groupId") long groupId, @Query("startTime") Long startTime,
			@Query("endTime") Long endTime);

	@POST(BASE_URL + "groups/{groupId}/virtual_machines")
	public Response addVmToCG(@Path("groupId") long groupId,
			@Body VmReplicationSetParamSet vmReplicationSetParamSet);

	@DELETE_WITH_BODY(BASE_URL + "groups/{groupId}/virtual_machines")
	public Response removeVmsFromCG(@Path("groupId") long groupId,
			@Body VmUIDSet vmUIDSet);

	@POST(BASE_URL + "groups/bookmarks")
	public Response createGroupBookmark(
			@Body CreateBookmarkParams createBookmarkParams);
	
	@POST(BASE_URL + "group_sets/subsets/snapshots")
	public Response createGroupSetBookmark(
			@Body CreateBookmarkForGroupSetSubSetParams createBookmarkForGroupSetSubSetParams);
	
	
	@GET(BASE_URL + "groups/statistics")
	public ConsistencyGroupStatisticsSet getGroupStatistics();
	
	
	@PUT(BASE_URL + "groups/{groupId}/virtual_machines/powerup_sequence")
	public Response changeVmsPowerUpSequence(@Path("groupId") long groupId, @Body VmPowerUpSequenceParamSet vmPowerUpSequenceParamSet);
	
	
	@PUT(BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/failover")
	public Response failOver(@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId, @Query("startTransfer") boolean startTransfer);
	
	
	@PUT(BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/set_production_copy?startTransfer=true")
	public Response setProductionCopy(@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId);
	
	
	@GET(BASE_URL + "settings/defaults/group_link_policy/local")
	public ConsistencyGroupLinkPolicy getDefaultLocalGroupLinkPolicy();
	
	
	@GET(BASE_URL + "settings/defaults/group_link_policy/remote")
	public ConsistencyGroupLinkPolicy getDefaultRemoteGroupLinkPolicy();
	
	
	@PUT(BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/topology?startTransfer=true")
	public ConsistencyGroupLinkPolicy setConsistencyGroupTopology(@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId, @Body ConsistencyGroupTopologyParams consistencyGroupTopologyParams);
	
	
	@PUT(BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/recover_production")
	public Response recoverProduction(@Path("clusterId") long clusterId, @Path("groupId") long groupId,
			@Path("copyId") int copyId, @Query("startTransfer") boolean startTransfer);
	
	
	@GET(BASE_URL + "clusters/{clusterId}/virtual_infra_configuration")
	public ClusterVirtualInfraConfiguration getClusterVirtualInfraConfiguration(@Path("clusterId") long clusterId);
	
		
	@GET(BASE_URL + "clusters/{clusterId}/vcenter_servers/{vcUID}/{dcUID}/{esxClusterUID}/available_vms_for_replication")
	public VmEntitiesInformationSet getAvailableVMsForReplication(@Path("clusterId") long clusterId, 
			                                                        @Path("vcUID") String vcUID, 
			                                                          @Path("dcUID") String dcUID, 
			                                                            @Path("esxClusterUID") String esxClusterUID);	
	
	
	@PUT(BASE_URL
			+ "group_sets/subsets/clusters/{clusterId}/image_access/enable")
	public Response enableImageAccessForGroupSetSubset(
			@Path("clusterId") long clusterId, @Body EnableImageAccessForGroupSetsSubsetParams params);
	
	
	@PUT(BASE_URL
			+ "group_sets/subsets/clusters/{clusterId}/image_access/disable")
	public Response disableImageAccessForGroupSetSubset(
			@Path("clusterId") long clusterId, @Body ConsistencyGroupSetSubset params, @Query("startTransfer") boolean startTransfer);
	
	
	
	@PUT(BASE_URL
			+ "group_sets/subsets/clusters/{clusterId}/failover")
	public Response failoverGroupSetSubset(
			@Path("clusterId") long clusterId, @Body ConsistencyGroupSetSubset params, @Query("startTransfer") boolean startTransfer);
	
	
	
	@PUT(BASE_URL
			+ "group_sets/subsets/clusters/{clusterId}/recover_production")
	public Response recoverProductionForGroupSetSubset(
			@Path("clusterId") long clusterId, @Body ConsistencyGroupSetSubset params, @Query("startTransfer") boolean startTransfer);
		
	
	@GET(BASE_URL + "group_sets/{groupSetId}")
	public ConsistencyGroupSetSettings getGroupSetSettings(@Path("groupSetId") long groupSetId);
	
	
	
	


}
