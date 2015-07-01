package com.emc.rpsp.imageaccess.controller;

import java.util.Map;

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

import com.emc.rpsp.imageaccess.service.GroupCopiesImageAccessService;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;

@Controller public class GroupCopiesImageAccessController {

    @Autowired 
    private GroupCopiesImageAccessService imageAccessService;

    @RequestMapping(value = "/groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/enable-latest", 
    		method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<HttpStatus> enableLatestImageAccess(
    @PathVariable("clusterId") Long clusterId, @PathVariable("groupId") Long groupId,
    @PathVariable("copyId") Integer copyId) {
        imageAccessService.enableLatestImageAccess(clusterId, groupId, copyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    	
    

    @RequestMapping(value = "/groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/enable", method = RequestMethod.PUT, 
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<HttpStatus> enableSnapshotImageAccess(
    @PathVariable("clusterId") Long clusterId, @PathVariable("groupId") Long groupId,
    @PathVariable("copyId") Integer copyId, @RequestBody Map<String, Long> params) {
        CopySnapshot copySnapshot = new CopySnapshot();
        copySnapshot.setId(params.get("snapshotId"));
        copySnapshot.setOriginalClosingTimeStamp(params.get("timestamp"));
        imageAccessService.enableSnapshotImageAccess(clusterId, groupId, copyId, copySnapshot);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    

    @RequestMapping(value = "/groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/disable", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> disableImageAccess(@PathVariable("clusterId") Long clusterId,
    		@PathVariable("groupId") Long groupId, @PathVariable("copyId") Integer copyId) {
        imageAccessService.disableImageAccess(clusterId, groupId, copyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
