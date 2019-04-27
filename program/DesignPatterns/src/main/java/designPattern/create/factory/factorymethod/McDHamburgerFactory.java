package designPattern.create.factory.factorymethod;

import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.McDHamburger;

public class McDHamburgerFactory extends AbstractFactory {

    @Override
    public IHamburger getHamburger() {
        return new McDHamburger();
    }
}
