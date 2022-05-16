package de.telran.shapes_spring.shapes;

public abstract class Shape {

    private char symbol;

    public abstract void draw();

    public abstract char getSymbol();

    public abstract int getCountOfChars();
}
