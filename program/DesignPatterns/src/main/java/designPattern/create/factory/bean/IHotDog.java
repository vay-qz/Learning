package designPattern.create.factory.bean;

public interface IHotDog {
    default String say() {
        return this.getClass().getName();
    }
}
