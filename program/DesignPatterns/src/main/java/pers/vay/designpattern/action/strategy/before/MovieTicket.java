package pers.vay.designpattern.action.strategy.before;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 电影票
 */
public class MovieTicket {

    private double price;

    public MovieTicket(double price) {
        this.price = price;
    }

    public double getPrice (String type) {
        if (StringUtils.equals(type, "student")) {
            return price * 0.5;
        } else if (StringUtils.equals(type, "net")) {
            return price * 0.88;
        } else {
            return price;
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(40);
        System.out.println("student price:" + ticket.getPrice("student"));
        System.out.println("net price:" + ticket.getPrice("net"));
    }

}
