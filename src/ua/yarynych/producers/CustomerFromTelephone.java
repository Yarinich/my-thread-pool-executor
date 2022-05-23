package ua.yarynych.producers;

public class CustomerFromTelephone implements Customer{
    @Override
    public String doRequest() {
        return CustomerFromTelephone.class.getSimpleName() + " do some request. Can somebody handle it?";
    }
}
