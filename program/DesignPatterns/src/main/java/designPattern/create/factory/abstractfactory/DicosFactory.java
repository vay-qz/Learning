package designPattern.create.factory.abstractfactory;

import designPattern.create.factory.bean.DicosHamburger;
import designPattern.create.factory.bean.DicosHotDog;
import designPattern.create.factory.bean.IHamburger;
import designPattern.create.factory.bean.IHotDog;

public class DicosFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new DicosHamburger();
    }

    @Override
    public IHotDog getHotDog() {
        return new DicosHotDog();
    }
}
