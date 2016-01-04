package com.emc.rpsp.backupsystems.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by morand3 on 1/3/2016.
 */

public class BackupWorker implements Runnable {
    public static final String EVERY_MINUTE = "1 * * * * *";
    private static final Logger log = LoggerFactory.getLogger(BackupWorker.class);
    private static boolean running = false;
    private static Queue<Task> tasks = new LinkedBlockingQueue<>();

    public static synchronized void addTask(Task t) {
        tasks.add(t);
        if (!running) {
            new Thread(new BackupWorker()).start();
            running = true;
        }
    }

    public static Queue<Task> getTasks() {
        return tasks;
    }

    @Scheduled(cron = EVERY_MINUTE)
    public void run() {
        log.info("Started Backup worker...");
        while (tasks.size() > 0) {
            running = true;
            Task t = tasks.poll();
            log.info("Started working on task {} : {}", t.getId(), t.toString());
        }
        running = false;
    }
}
