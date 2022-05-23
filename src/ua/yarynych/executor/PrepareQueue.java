package ua.yarynych.executor;

import ua.yarynych.producers.CustomerFromSite;
import ua.yarynych.producers.CustomerFromTelephone;
import ua.yarynych.producers.CustomerInShop;

import java.util.*;

public class PrepareQueue {

    public List<WorkerItem> prepare() {

        List<WorkerItem> queue = Collections.synchronizedList( new LinkedList<>() );

        queue.add(new WorkerItem(new CustomerFromSite()));
        queue.add(new WorkerItem(new CustomerInShop()));
        queue.add(new WorkerItem(new CustomerFromTelephone()));
        queue.add(new WorkerItem(new CustomerFromTelephone()));
        queue.add(new WorkerItem(new CustomerFromSite()));

        return queue;
    }
}
