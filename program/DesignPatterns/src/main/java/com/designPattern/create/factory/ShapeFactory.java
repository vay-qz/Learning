package com.designPattern.create.factory;

public class ShapeFactory {
    public Shape getShape(String shape){
        if("circle".equals(shape)){
            return new Circle();
        }else if("block".equals(shape)){
            return new Block();
        }else {
            return null;
        }
    }
}
