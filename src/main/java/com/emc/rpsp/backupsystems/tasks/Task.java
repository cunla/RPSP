package com.emc.rpsp.backupsystems.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by morand3 on 1/3/2016.
 */
public abstract class Task implements Runnable {
    @JsonIgnore
    public static final String STATUS_PENDING = "Pending";
    @JsonIgnore
    public static final String STATUS_RUNNING = "In process";
    @JsonIgnore
    public static final String STATUS_SUCCESS = "Success";
    @JsonIgnore
    public static final String STATUS_FAILURE = "Failure";
    @JsonIgnore
    private static long nextId = 1;
    private Long id = nextId++;
    private String status = STATUS_PENDING;
    private Exception reason;

    public Long getId() {
        return id;
    }

    public void run() {
        this.status = STATUS_RUNNING;
    }

    public String getStatus() {
        return status;
    }

    public Exception getReason() {
        return reason;
    }

    public void success() {
        this.status = STATUS_SUCCESS;
    }

    public void failed(Exception e) {
        this.status = STATUS_FAILURE;
        this.reason = e;
    }
}
