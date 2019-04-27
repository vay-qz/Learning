package designPattern.create.factory.factorymethod;

import designPattern.create.factory.bean.DicosHamburger;
import designPattern.create.factory.bean.IHamburger;

public class DicosHamburgerFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new DicosHamburger();
    }
}
