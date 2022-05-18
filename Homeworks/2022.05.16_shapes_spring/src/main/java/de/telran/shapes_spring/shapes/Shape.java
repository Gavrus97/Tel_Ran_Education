package de.telran.shapes_spring.shapes;

public abstract class Shape {

    protected char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();

    public char getSymbol(){
        return symbol;
    }

    public abstract int getCountOfChars();
}
