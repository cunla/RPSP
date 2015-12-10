package com.emc.rpsp.bookmarks.controller;

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

import com.emc.rpsp.bookmarks.service.GroupSetBookmarksService;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;

@Controller
public class GroupSetBookmarksController {

	@Autowired
	private GroupSetBookmarksService groupSetBookmarksService;

	@RequestMapping(value = "/group-sets/{groupSetId}/bookmarks", method = RequestMethod.POST, 
										consumes = MediaType.APPLICATION_JSON_VALUE, 
												produces = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action="Create bookmark")
	@ResponseBody
	public @RpspAuditResult("Create bookmark result") ResponseEntity<HttpStatus> createBookmark(@RpspAuditSubject("gs") @PathVariable("groupSetId") Long groupSetId , 
			@RpspAuditObject("bookmark params") @RequestBody Map<String, String> params) {
		groupSetBookmarksService.createGroupSetBookmark(groupSetId, params.get("name"), params.get("consistencyType"));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
