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

import com.emc.rpsp.bookmarks.service.GroupBookmarksService;
import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;

@Controller
public class GroupBookmarksController {

	@Autowired
	private GroupBookmarksService groupBookmarksService;

	@RequestMapping(value = "/groups/{groupId}/bookmarks", method = RequestMethod.POST, 
										consumes = MediaType.APPLICATION_JSON_VALUE, 
												produces = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action=AuditConsts.CREATE_BOOKMARK)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.CREATE_BOOKMARK_RESULT) ResponseEntity<HttpStatus> createBookmark(@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId , 
			@RpspAuditObject(AuditConsts.BOOKMARK_PARAMS) @RequestBody Map<String, String> params) {
		groupBookmarksService.createGroupBookmark(groupId, params.get("name"), params.get("consistencyType"));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
