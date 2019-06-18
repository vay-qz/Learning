package pers.vay.designpattern.create.factory.abstractfactory;


import pers.vay.designpattern.create.factory.bean.IHamburger;
import pers.vay.designpattern.create.factory.bean.IHotDog;

public abstract class AbstractFactory {
    public abstract IHamburger getHamburger();
    public abstract IHotDog getHotDog();
}
