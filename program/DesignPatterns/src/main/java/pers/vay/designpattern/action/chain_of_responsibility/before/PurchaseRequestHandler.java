package pers.vay.designpattern.action.chain_of_responsibility.before;

import pers.vay.designpattern.action.chain_of_responsibility.Order;

public class PurchaseRequestHandler {

    public void buy(Order order) {
        if (order.getMoney() < 100) {
            this.zrHandler(order);
        }
        if (order.getMoney() < 1000) {
            this.zjdHandler(order);
        }
        if (order.getMoney() < 10000) {
            this.dszHandler(order);
        }
    }

    private void zrHandler(Order order) {}

    private void dszHandler(Order order) {}

    private void zjdHandler(Order order) {}

    public static void main(String[] args) {
        PurchaseRequestHandler handler = new PurchaseRequestHandler();
        handler.buy(new Order(10000, null));
    }

}
