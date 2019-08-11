package pers.vay.designpattern.action.command.after;

import pers.vay.designpattern.action.command.after.command.FishCommand;

/**
 * @author qiaozhe
 */
public class Consumer {

    public void orderFish() {
        Waiter waiter = new Waiter();
        waiter.setCommand(new FishCommand());
        waiter.call();
    }

}
