package com.emc.rpsp.config.auditing;

import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by morand3 on 11/23/2015.
 */
@RestController @RequestMapping("/app") public class AuditedResourceExample {

    @RpspAudited @RequestMapping(value = "/audittest/{subject}",
    method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public @RpspAuditResult("x") ResponseEntity<List<SystemSettings>> findSystems(
    @PathVariable("subject") @RpspAuditSubject("x") String subject,
    @RequestParam(value = "object", required = false) @RpspAuditObject("x") String object) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
