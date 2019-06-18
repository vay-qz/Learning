package pers.vay.designpattern.create.factory.factorymethod;


import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.McDHamburger;

public class McDHamburgerFactory extends AbstractFactory {

    @Override
    public IHamburger getHamburger() {
        return new McDHamburger();
    }
}
