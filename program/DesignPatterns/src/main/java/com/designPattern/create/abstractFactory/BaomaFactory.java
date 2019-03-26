package com.designPattern.create.abstractFactory;

public class BaomaFactory extends AbstractCarFactory{
    public Shoe getShoe() {
        return new BaomaShoe();
    }

    public Window getWindow() {
        return new BaomaWindow();
    }
}
