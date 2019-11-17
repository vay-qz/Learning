package pers.vay.designpattern.action.strategy.after;

import lombok.Setter;
import pers.vay.designpattern.action.strategy.after.strategy.AbstractAccount;
import pers.vay.designpattern.action.strategy.after.strategy.VIPAccount;

public class MoiveTicket {
    private double price;
    @Setter
    private AbstractAccount account;

    public MoiveTicket(double price) {
        this.price = price;
    }

    public double getPrice() {
        return account.getPrice(this.price);
    }

    public static void main(String[] args) {
        MoiveTicket ticket = new MoiveTicket(40);
        ticket.setAccount(new VIPAccount());
        System.out.println("VIP price:" + ticket.getPrice());;
    }
}
