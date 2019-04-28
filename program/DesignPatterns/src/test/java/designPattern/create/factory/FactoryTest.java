package designPattern.create.factory;


import designPattern.create.factory.abstractfactory.KFCFactory;
import designPattern.create.factory.factorymethod.AbstractFactory;
import designPattern.create.factory.factorymethod.KFCHamburgerFactory;
import designPattern.create.factory.simplefactory.SimpleFactory;
import org.junit.jupiter.api.Test;

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
        designPattern.create.factory.abstractfactory.AbstractFactory factory = new KFCFactory();
        System.out.println(factory.getHamburger());
        System.out.println(factory.getHotDog());
    }

}
