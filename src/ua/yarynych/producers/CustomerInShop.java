package ua.yarynych.producers;

public class CustomerInShop implements Customer {

    @Override
    public String doRequest() {
        return CustomerInShop.class.getSimpleName() + " do some request. Can somebody handle it?";
    }
}
