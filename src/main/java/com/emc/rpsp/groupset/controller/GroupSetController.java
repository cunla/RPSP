package com.emc.rpsp.groupset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.groupset.domain.GroupSet;
import com.emc.rpsp.groupset.service.GroupSetService;

@Controller
public class GroupSetController {

	@Autowired
	private GroupSetService groupSetService;


	@SuppressWarnings("unchecked")
    @RequestMapping(value = "/groups-sets", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> createGroupSet(@RequestBody GroupSet groupSet) {
        groupSetService.createGroupSet(groupSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

	

}
