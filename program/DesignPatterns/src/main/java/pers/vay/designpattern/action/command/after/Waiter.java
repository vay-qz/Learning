package pers.vay.designpattern.action.command.after;

import lombok.Setter;
import pers.vay.designpattern.action.command.after.command.AbstractCommand;

/**
 * @author qiaozhe
 */
public class Waiter {
    @Setter
    private AbstractCommand command;

    Waiter() {
        System.out.println("请您点菜");
    }

    public void call() {
        command.execute();
    }

}
