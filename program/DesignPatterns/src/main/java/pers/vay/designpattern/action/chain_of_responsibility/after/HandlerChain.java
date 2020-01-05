package pers.vay.designpattern.action.chain_of_responsibility.after;

import lombok.Getter;
import lombok.Setter;
import pers.vay.designpattern.action.chain_of_responsibility.Order;

@Setter
@Getter
public abstract class HandlerChain {
    HandlerChain successor;
    abstract void handler(Order order);
}
