package ua.yarynych.executor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class WorkerThread implements Callable<Object>{
    private final String nameOfThread;
    private final List<WorkerItem> queue;

    public WorkerThread(String nameOfThread, List<WorkerItem> queue){
        this.nameOfThread = nameOfThread;
        this.queue = queue;
    }

    @Override
    public Future<?> call() {

        WorkerItem item = findNotLocked(queue);
        Callable<String> func = item::func;
        FutureTask<?> future = new FutureTask(func);
        future.run();

        queue.remove(item);

        return future;
    }

    public WorkerItem findNotLocked(List<WorkerItem> queue ){
        for(WorkerItem item: queue){
            if(!item.isLocked()) {
                item.setLocked();
                return item;
            }
        }
        return null;
    }

    public String getNameOfThread() {
        return nameOfThread;
    }
}
