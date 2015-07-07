package com.emc.rpsp.fal;

import com.emc.fapi.jaxws.*;

import retrofit.client.Response;
import retrofit.http.*;
import retrofit.http.Path;

/**
 * Created by morand3 on 1/13/2015.
 */
public interface ClusterConnector {
    static final String BASE_URL = "/";

    @GET(BASE_URL + "system/version") public RecoverPointVersion getSystemVersion();

    @GET(BASE_URL + "settings") public FullRecoverPointSettings getFullRecoverPointSettings();

    @GET(BASE_URL + "time/current_time") public RecoverPointTimeStamp getSystemTime();

    @GET(BASE_URL + "system/virtual_infrastructures/state")
    public ClusterVirtualInfrastructuresStateSet getVirtualInfrastructuresStateFromAllCluster();

    @GET(BASE_URL + "clusters/{clusterId}/virtual_infrastructures/state")
    public ClusterVirtualInfrastructuresState getVirtualInfrastructuresStateFromCluster(
    @Path("clusterId") long clusterId);

    @GET(BASE_URL + "clusters") public RecoverPointClustersInformation getRpClustersInformation();

    @GET(BASE_URL + "groups/{groupId}/copies/settings")
    public ConsistencyGroupCopySettingsSet getAllGroupCopies(@Path("groupId") long groupId);

    @GET(BASE_URL + "groups") public ConsistencyGroupUIDSet getAllGroupsUIDs();

    @PUT(
    BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image_access/latest/enable")
    public EnableLatestImageAccessResponse enableLatestImageAccess(
    @Path("clusterId") long clusterId, @Path("groupId") long groupId, @Path("copyId") int copyId,
    @Body EnableLatestImageAccessParams params);

    @PUT(BASE_URL + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/enable_image_access")
    public EnableImageAccessResponse enableSnapshotImageAccess(@Path("clusterId") long clusterId,
    @Path("groupId") long groupId, @Path("copyId") int copyId,
    @Body EnableImageAccessParams params);

    @PUT(BASE_URL
    + "groups/{groupId}/clusters/{clusterId}/copies/{copyId}/disable_image_access?startTransfer=true")
    public DisableImageAccessResponse disableLatestImageAccess(@Path("clusterId") long clusterId,
    @Path("groupId") long groupId, @Path("copyId") int copyId);

    @GET(BASE_URL + "groups/state") public ConsistencyGroupStateSet getConsistencyGroupStateSet();

    @GET(BASE_URL + "groups/volumes/state")
    public ConsistencyGroupVolumesStateSet getConsistencyGroupVolumesStateSet();

    @GET(BASE_URL + "groups/{groupId}/snapshots")
    public ConsistencyGroupSnapshots getGroupSnapshots(@Path("groupId") long groupId,
    @Query("startTime") Long startTime, @Query("endTime") Long endTime);    
    
    @POST(BASE_URL + "groups/{groupId}/virtual_machines")
    public Response addVmToCG(@Path("groupId") long groupId, 
    		@Body VmReplicationSetParamSet vmReplicationSetParamSet);
    
    
    @DELETE_WITH_BODY(BASE_URL + "groups/{groupId}/virtual_machines")
    public Response removeVmsFromCG(@Path("groupId") long groupId, 
    		@Body VmUIDSet vmUIDSet);
    
    
    @POST(BASE_URL + "groups/bookmarks")
    public Response createGroupBookmark( 
    		@Body CreateBookmarkParams createBookmarkParams);



}
