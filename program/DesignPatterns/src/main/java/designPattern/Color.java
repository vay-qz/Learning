package designPattern;

public enum Color {
    White("white"),

    Black("black");

    public final String color;

    private Color(String color) {
        this.color = color;
    }
}
