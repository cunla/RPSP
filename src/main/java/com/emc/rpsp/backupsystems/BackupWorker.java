package com.emc.rpsp.backupsystems;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by morand3 on 1/3/2016.
 */

public class BackupWorker {
    Queue<Task> tasks = new ConcurrentLinkedDeque<>();


}
