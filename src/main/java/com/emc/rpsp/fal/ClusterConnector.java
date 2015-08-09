package com.emc.rpsp.fal;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresState;
import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySettingsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSnapshots;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStatisticsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupUIDSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupVolumesStateSet;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkForGroupSetSubSetParams;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkParams;
import com.emc.fapi.jaxws.v4_3.DisableImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.EnableLatestImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EnableLatestImageAccessResponse;
import com.emc.fapi.jaxws.v4_3.FullRecoverPointSettings;
import com.emc.fapi.jaxws.v4_3.RecoverPointClustersInformation;
import com.emc.fapi.jaxws.v4_3.RecoverPointTimeStamp;
import com.emc.fapi.jaxws.v4_3.RecoverPointVersion;
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
	
	


}
