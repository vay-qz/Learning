package pers.vay.designpattern.action.command.after.command;

import pers.vay.designpattern.action.command.after.Cook;

/**
 * @author qiaozhe
 */
public class FishCommand extends AbstractCommand{

    private Cook cook;

    @Override
    public void execute() {
        this.cook.cookFish();
    }
}
