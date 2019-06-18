package pers.vay.designpattern.create.factory.factorymethod;


import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.KFCHamburger;

public class KFCHamburgerFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new KFCHamburger();
    }
}
