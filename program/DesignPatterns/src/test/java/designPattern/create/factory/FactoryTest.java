package designPattern.create.factory;


import designPattern.create.factory.abstractfactory.KFCFactory;
import designPattern.create.factory.factorymethod.AbstractFactory;
import designPattern.create.factory.factorymethod.KFCHamburgerFactory;
import designPattern.create.factory.simplefactory.SimpleFactory;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void simpleFactoryGetInstance() {
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getInstance("KFC").say());
        System.out.println(simpleFactory.getInstance("McD").say());
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
