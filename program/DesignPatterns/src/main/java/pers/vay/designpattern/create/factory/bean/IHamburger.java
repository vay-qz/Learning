package pers.vay.designpattern.create.factory.bean;

public interface IHamburger {
    default String say() {
        return this.getClass().getName();
    }
}
