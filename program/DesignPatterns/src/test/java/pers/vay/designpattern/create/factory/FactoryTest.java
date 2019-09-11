package pers.vay.designpattern.create.factory;



import org.junit.jupiter.api.Test;
import pers.vay.designpattern.create.factory.abstractfactory.KFCFactory;
import pers.vay.designpattern.create.factory.factorymethod.AbstractFactory;
import pers.vay.designpattern.create.factory.factorymethod.KFCHamburgerFactory;
import pers.vay.designpattern.create.factory.simplefactory.SimpleFactory;

public class FactoryTest {

    @Test
    public void simpleFactoryGetInstance() {
        System.out.println(SimpleFactory.getInstance(SimpleFactory.KFC).say());
        System.out.println(SimpleFactory.getInstance(SimpleFactory.McD).say());
    }

    @Test
    public void factoryMethodGetInstance(){
        AbstractFactory factory = new KFCHamburgerFactory();
        System.out.println(factory.getHamburger());
    }

    @Test
    public void abstractFactoryGetInstance() {
        pers.vay.designpattern.create.factory.abstractfactory.AbstractFactory factory = new KFCFactory();
        System.out.println(factory.getHamburger());
        System.out.println(factory.getHotDog());
    }

}
