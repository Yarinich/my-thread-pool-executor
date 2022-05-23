package ua.yarynych.executor;

import ua.yarynych.producers.Customer;

public class WorkerItem {

    private boolean isLocked;
    private final Customer customer;

    WorkerItem(Customer customer){
        this.customer = customer;
        this.isLocked = false;
    }

    public String func() {
        return customer.doRequest() + " - Yes, everything is done by ";
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked (){ this.isLocked = true;}

    public Customer getCustomer(){ return customer; }

}
