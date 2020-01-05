package pers.vay.designpattern.action.chain_of_responsibility.after;

import pers.vay.designpattern.action.chain_of_responsibility.Order;

public class ZrHandler extends HandlerChain {

    @Override
    void handler(Order order) {
        if (order.getMoney() < 100) {

        } else {
            this.getSuccessor().handler(order);
        }
    }

}
