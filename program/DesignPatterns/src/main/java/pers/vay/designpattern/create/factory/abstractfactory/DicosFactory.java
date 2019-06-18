package pers.vay.designpattern.create.factory.abstractfactory;


import pers.vay.designpattern.create.factory.bean.DicosHamburger;
import pers.vay.designpattern.create.factory.bean.DicosHotDog;
import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.IHotDog;

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
