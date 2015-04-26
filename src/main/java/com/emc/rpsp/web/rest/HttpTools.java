package com.emc.rpsp.web.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by morand3 on 2/19/2015.
 */
public class HttpTools {
	public static ResponseEntity<String> getCsvResponseEntity(String res) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Disposition",
		        "attachment; filename=\"yourData.csv\"");
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
}
