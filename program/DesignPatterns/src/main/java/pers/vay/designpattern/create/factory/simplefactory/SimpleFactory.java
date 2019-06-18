package pers.vay.designpattern.create.factory.simplefactory;

import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.KFCHamburger;
import pers.vay.designpattern.create.factory.bean.McDHamburger;

/**
 * @author
 */
public class SimpleFactory {

    public final static String KFC = "KFC";
    public final static String McD = "McD";

    public static IHamburger getInstance(String type) {
        if(type == KFC){
            return new KFCHamburger();
        }else if(type == McD){
            return new McDHamburger();
        }else {
            return null;
        }
    }
}
