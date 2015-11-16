package com.emc.rpsp.config.auditing;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by morand3 on 11/16/2015.
 */
@Entity @Table(name = "T_AUDIT", schema = "RpspAudit")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) public class AuditEntry {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Column private Date date;
    @Column private String user;
    @Column private String action;
    @Column private String subject;
    @Column private String status;

    public AuditEntry() {
    }

    public AuditEntry(Date date, String user, String action, String subject, String status) {
        this.date = date;
        this.user = user;
        this.action = action;
        this.subject = subject;
        this.status = status;
    }

    @JsonIgnore public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getAction() {
        return action;
    }

    public String getSubject() {
        return subject;
    }

    public String getStatus() {
        return status;
    }
}
