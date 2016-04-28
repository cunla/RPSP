package com.emc.rpsp.groupset.controller;

import java.util.List;

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

import com.emc.rpsp.groupset.service.GroupSetService;
import com.emc.rpsp.vmstructure.domain.GroupSet;

@Controller
public class GroupSetController {
	

	@Autowired
	private GroupSetService groupSetService;
	
	

    @RequestMapping(value = "/groups-sets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<GroupSet>> getGroupSets() {
        List<GroupSet> groupSets = groupSetService.getAllGroupSets();
        return new ResponseEntity<>(groupSets, HttpStatus.OK);
    }


    @RequestMapping(value = "/groups-sets", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> createGroupSet(@RequestBody GroupSet groupSet) {
        groupSetService.createGroupSet(groupSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
    @RequestMapping(value = "/groups-sets", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> updateGroupSet(@RequestBody GroupSet groupSet) {
        groupSetService.updateGroupSet(groupSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
    @RequestMapping(value = "/groups-sets/{groupSetId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> removeGroupSet(@PathVariable("groupSetId") String groupSetId) {
        groupSetService.removeGroupSet(groupSetId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	

}
