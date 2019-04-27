package designPattern.create.factory.factorymethod;

import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.KFCHamburger;

public class KFCHamburgerFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new KFCHamburger();
    }
}
