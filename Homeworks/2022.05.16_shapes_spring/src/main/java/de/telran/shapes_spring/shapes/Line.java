package de.telran.shapes_spring.shapes;


public class Line extends Shape {

    private final int length;
    private final char symbol;

    public Line(char symbol, int length) {
        this.symbol = symbol;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int getCountOfChars() {
        return length;
    }
}
