package pers.vay.designpattern.create.factory.abstractfactory;


import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.IHotDog;
import pers.vay.designpattern.create.factory.bean.KFCHamburger;
import pers.vay.designpattern.create.factory.bean.KFCHogDog;

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
