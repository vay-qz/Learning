package pers.vay.designpattern.create.factory.abstractfactory;


import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.IHotDog;
import pers.vay.designpattern.create.factory.bean.McDHamburger;
import pers.vay.designpattern.create.factory.bean.McDHotDog;

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
