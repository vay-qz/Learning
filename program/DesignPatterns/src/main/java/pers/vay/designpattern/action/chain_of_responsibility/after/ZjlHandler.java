package pers.vay.designpattern.action.chain_of_responsibility.after;

import pers.vay.designpattern.action.chain_of_responsibility.Order;

public class ZjlHandler extends HandlerChain {
    @Override
    void handler(Order order) {
        if (order.getMoney() < 1000) {

        } else {
            this.getSuccessor().handler(order);
        }
    }
}
