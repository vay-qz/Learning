package pers.vay.designpattern.action.command.before;

/**
 * @author qiaozhe
 */
public class Consumer {

    public void orderFish(Cook cook) {
        cook.cookFish();
    }

}
