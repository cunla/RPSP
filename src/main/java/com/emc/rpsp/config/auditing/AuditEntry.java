package com.emc.rpsp.config.auditing;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by morand3 on 11/16/2015.
 */
@Entity @Table(name = "T_AUDIT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) public class AuditEntry {
    @JsonIgnore private static SimpleDateFormat dateFormat = new SimpleDateFormat(
    "yyyy.MM.dd @ HH:mm:ss z");

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Column private Date date;
    @Column private String user;
    @Column private String action;
    @Column private String subject;
    @Column private String status;
    @Column private String objects;

    public AuditEntry() {
    }

    public AuditEntry(Date date, String user, String action, String subject, String status,
    String objects) {
        this.date = date;
        this.user = user;
        this.action = action;
        this.subject = subject;
        this.status = status;
        this.objects = objects;
    }

    @JsonIgnore public long getId() {
        return id;
    }

    public String getDate() {
        return dateFormat.format(date);
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

    public String getObjects() {
        return objects;
    }

    @Override public String toString() {
        return "AuditEntry{" +
        "id=" + id +
        ", date=" + date +
        ", user='" + user + '\'' +
        ", action='" + action + '\'' +
        ", subject='" + subject + '\'' +
        ", status='" + status + '\'' +
        ", objects='" + objects + '\'' +
        '}';
    }
}
