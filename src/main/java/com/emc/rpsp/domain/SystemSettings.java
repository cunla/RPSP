package com.emc.rpsp.domain;

import com.emc.rpsp.tools.StringXORer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by morand3 on 1/13/2015.
 */
@Entity
@Table(name = "T_SYSTEMS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SystemSettings {
    private static final String ENCRYPT_KEY1 = "Bar12345Bar12345";
    private static final String ENCRYPT_KEY2 = "ThisIsASecretKey";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("ip")
    @Column
    private String systemIp;
    @Column
    private String user;
    @Column
//    @JsonIgnore
    private String password;
    @Column
    private Boolean testResult;
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastTested;
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastCollected;
    @Column
    private String systemVersion;

    @Column
    @OneToMany(mappedBy = "systemSettings", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonProperty("clusters")
    private List<ClusterSettings> clusters;

    public static enum TestResult {OK, AUTH_FAILED, FAILED}

    ;

    public SystemSettings() {
        clusters = new LinkedList<>();
    }

    public SystemSettings(String systemIp, String user, String password) {
        this();
        this.systemIp = systemIp;
        this.user = user;
        setPassword(password);
    }

    public void addCluster(ClusterSettings cluster) {
        clusters.add(cluster);
    }

    public String getSystemIp() {
        return systemIp;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    @JsonIgnore
    public String getRealPassword() {
        return StringXORer.decrypt(ENCRYPT_KEY1, ENCRYPT_KEY2, password);
    }

    public String getPassword() {
        return "*****";
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public DateTime getLastTested() {
        return new DateTime(lastTested);
    }

    public void setTestResult(Boolean result) {
        this.testResult = result;
        this.lastTested = DateTime.now();//.toString();
    }

    public void setSystemIp(String systemIp) {
        this.systemIp = systemIp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = StringXORer.encrypt(ENCRYPT_KEY1, ENCRYPT_KEY2, password);
    }

    public DateTime getLastCollected() {
        return lastCollected;
    }

    public void setLastCollected(DateTime lastCollected) {
        this.lastCollected = lastCollected;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public List<ClusterSettings> getClusters() {
        return clusters;
    }

}
