package pers.vay.designpattern.action.chain_of_responsibility.after;

import pers.vay.designpattern.action.chain_of_responsibility.Order;

public class PurchaseRequestHandler {

    private HandlerChain chain;

    public PurchaseRequestHandler() {
        makeChain();
    }

    private void makeChain() {
        ZrHandler handler = new ZrHandler();
        ZjlHandler handler1 = new ZjlHandler();
        DszHandler handler2 = new DszHandler();
        handler.setSuccessor(handler1);
        handler1.setSuccessor(handler2);
        chain = handler;
    }

    public void buy (Order order) {
        chain.handler(order);
    }

}
