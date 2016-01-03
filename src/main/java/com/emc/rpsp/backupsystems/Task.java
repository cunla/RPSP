package com.emc.rpsp.backupsystems;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by morand3 on 1/3/2016.
 */
public class Task implements Runnable {
    @JsonIgnore
    public static final String STATUS_PENDING = "Pending";
    @JsonIgnore
    public static final String STATUS_RUNNING = "In process";
    @JsonIgnore
    public static final String STATUS_SUCCESS = "Success";
    @JsonIgnore
    public static final String STATUS_FAILURE = "Failure";

    private Long id;
    private String status = STATUS_PENDING;

    @Override
    public void run() {
        this.status=STATUS_RUNNING;
        //...
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

}
