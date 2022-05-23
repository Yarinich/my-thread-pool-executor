package ua.yarynych;

import ua.yarynych.executor.Executor;
import ua.yarynych.executor.PrepareQueue;
import ua.yarynych.producers.CustomerInShop;
import ua.yarynych.producers.Customer;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        PrepareQueue prepareQueue = new PrepareQueue();
        Executor executor = new Executor(3, prepareQueue.prepare());
        executor.execute();
    }
}
