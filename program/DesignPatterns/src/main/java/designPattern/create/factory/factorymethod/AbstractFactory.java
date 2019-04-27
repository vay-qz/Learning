package designPattern.create.factory.factorymethod;

import designPattern.create.factory.bean.IHamburger;

public abstract class AbstractFactory {
    public abstract IHamburger getHamburger();
}
