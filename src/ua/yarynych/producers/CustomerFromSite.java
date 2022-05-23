package ua.yarynych.producers;

public class CustomerFromSite implements Customer{
    @Override
    public String doRequest() {
        return CustomerFromSite.class.getSimpleName() + " do some request. Can somebody handle it?";
    }
}
