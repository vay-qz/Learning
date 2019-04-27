package designPattern.create.factory.abstractfactory;

import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.IHotDog;

public abstract class AbstractFactory {
    public abstract IHamburger getHamburger();
    public abstract IHotDog getHotDog();
}
