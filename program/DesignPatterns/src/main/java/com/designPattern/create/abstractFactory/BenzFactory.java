package com.designPattern.create.abstractFactory;

public class BenzFactory extends AbstractCarFactory {

    public Shoe getShoe() {

        return new BenzShoe();
    }

    public Window getWindow() {

        return new BenzWindow();
    }
}
