package pers.vay.designpattern.action.strategy.after.strategy;

public class StudentAccount extends AbstractAccount{
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}
