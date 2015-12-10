package com.emc.rpsp.imageaccess.controller;

import java.util.Map;

import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.imageaccess.service.GroupSetImageAccessService;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;

@Controller public class GroupSetImageAccessController {

    @Autowired
    private GroupSetImageAccessService groupSetImageAccessService;


    @RequestMapping(value = "/group-sets/{groupSetId}/clusters/{clusterId}/image-access/enable", method = RequestMethod.PUT,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RpspAudited(action="Enable DR test")
    @ResponseBody public @RpspAuditResult("DR test result") ResponseEntity<HttpStatus> enableSnapshotImageAccess(
    		@RpspAuditObject("cluster") @PathVariable("clusterId") Long clusterId, @RpspAuditSubject("gs") @PathVariable("groupSetId") Long groupSetId,
    @RequestBody Map<String, Long> params) {
        CopySnapshot copySnapshot = new CopySnapshot();
        copySnapshot.setId(params.get("snapshotId"));
        copySnapshot.setOriginalClosingTimeStamp(params.get("timestamp"));
        groupSetImageAccessService.enableImageAccessForGroupSetSubset(clusterId, groupSetId, copySnapshot);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @RequestMapping(value = "/group-sets/{groupSetId}/clusters/{clusterId}/image-access/disable", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @RpspAudited(action="Disable DR test")
    @ResponseBody
    public @RpspAuditResult("Disable DR test result") ResponseEntity<HttpStatus> disableImageAccess(@RpspAuditObject("cluster") @PathVariable("clusterId") Long clusterId,
    		@RpspAuditSubject("gs") @PathVariable("groupSetId") Long groupSetId) {
        groupSetImageAccessService.disableImageAccessForGroupSetSubset(clusterId, groupSetId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
