package designPattern.create.factory.abstractfactory;

import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.IHotDog;
import designPattern.create.factory.bean.McDHamburger;
import designPattern.create.factory.bean.McDHotDog;

public class McDFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new McDHamburger();
    }

    @Override
    public IHotDog getHotDog() {
        return new McDHotDog();
    }
}
