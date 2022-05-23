package ua.yarynych.executor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public class Executor {
    private final int maxCountOfThreads;
    private final List<WorkerItem> queue;
    private final List<WorkerThread> listOfThreads = new LinkedList<>();


    public Executor(int maxCountOfThreads, List<WorkerItem> queue) {
        this.maxCountOfThreads = maxCountOfThreads;
        this.queue = queue;
    }


    public synchronized void execute() throws InterruptedException {
        int countOfThreads;

        while(!queue.isEmpty()) {
            countOfThreads = Math.min(queue.size(), maxCountOfThreads);

            for (int i = 0; i < countOfThreads; i++) {
                ua.yarynych.executor.WorkerThread workerThread = new ua.yarynych.executor.WorkerThread("worker " + i, queue);

                Thread.sleep(2000);
                try {
                    Future futureResult = workerThread.call();
                    System.out.print(futureResult.get());
                    System.out.println(workerThread.getNameOfThread());
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

                listOfThreads.add(workerThread);
            }
        }

        shutdown();

    }


    private void shutdown(){
        listOfThreads.clear();
        queue.clear();
        System.out.println("Service is stopped");

    }
}
