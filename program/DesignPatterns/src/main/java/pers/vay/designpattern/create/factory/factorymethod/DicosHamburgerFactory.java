package pers.vay.designpattern.create.factory.factorymethod;


import pers.vay.designpattern.create.factory.bean.DicosHamburger;
import pers.vay.designpattern.create.factory.bean.IHamburger;

public class DicosHamburgerFactory extends AbstractFactory {
    @Override
    public IHamburger getHamburger() {
        return new DicosHamburger();
    }
}
