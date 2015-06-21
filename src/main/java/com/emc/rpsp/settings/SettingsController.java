package com.emc.rpsp.settings;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller public class SettingsController {

    @RequestMapping(value = "/locale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<String> findUsers(HttpServletRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders
        .add(HttpHeaders.ACCEPT_LANGUAGE, request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

}
