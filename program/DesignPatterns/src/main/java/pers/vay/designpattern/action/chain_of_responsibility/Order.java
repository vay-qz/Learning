package pers.vay.designpattern.action.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单
 */
@Getter
@Setter
@AllArgsConstructor
public class Order {

    private int money;
    private Object goods;

}
