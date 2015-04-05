package com.emc.rpsp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by morand3 on 12/23/2014.
 */
@Entity
@Table(name = "T_VMDATA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class VirtualMachineData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:mm")
    private DateTime sampleTime;

    @Column
    private String vmId;

    @Column
    private String vmName;

    @Column
    private long clusterId;

    @Column
    private String clusterName;

    @Column
    private String clusterCountry;

    @Column
    private String role;

    public VirtualMachineData() {
    }

    private VirtualMachineData(DateTime sampleTime, long clusterId, String clusterName, String vmId, String vmName) {
        this.sampleTime = sampleTime;
        this.vmId = vmId;
        this.vmName = vmName;
        this.clusterId = clusterId;
        this.clusterName = clusterName;
    }

    public VirtualMachineData(DateTime sampleTime, long clusterId, String clusterName,
                              String vmId, String vmName, String clusterCountry, String role) {
        this(sampleTime, clusterId, clusterName, vmId, vmName);
        this.role = role;
        this.clusterCountry = clusterCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getSampleTime() {
        return new DateTime(sampleTime);
    }

    public void setSampleTime(DateTime sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocalMachine() {
        return role;
    }

    public void setLocalMachine(String role) {
        this.role = role;
    }

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public long getClusterId() {
        return clusterId;
    }

    public void setClusterId(long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterCountry() {
        return clusterCountry;
    }

    public void setClusterCountry(String clusterCountry) {
        this.clusterCountry = clusterCountry;
    }

    public String asCsv() {
        return id + "," +
                sampleTime + "," +
                vmId + "," +
                vmName + "," +
                clusterId + "," +
                clusterName + "," +
                clusterCountry + "," +
                role;
    }

    @Override
    public String toString() {
        return "VirtualMachineData{" +
                "id=" + id +
                ", sampleTime=" + sampleTime +
                ", vmId='" + vmId + '\'' +
                ", vmName='" + vmName + '\'' +
                ", clusterId=" + clusterId +
                ", clusterName='" + clusterName + '\'' +
                ", clusterCountry='" + clusterCountry + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static String csvTitle() {
        return "id,sampleTime,vmId,vmName,clusterId,clusterName,clusterCountry,state,localMachine";
    }
}
