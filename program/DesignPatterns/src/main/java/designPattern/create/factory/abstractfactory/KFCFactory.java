package designPattern.create.factory.abstractfactory;

import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.IHotDog;
import designPattern.create.factory.bean.KFCHamburger;
import designPattern.create.factory.bean.KFCHogDog;

public class KFCFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new KFCHamburger();
    }

    @Override
    public IHotDog getHotDog() {
        return new KFCHogDog();
    }
}
