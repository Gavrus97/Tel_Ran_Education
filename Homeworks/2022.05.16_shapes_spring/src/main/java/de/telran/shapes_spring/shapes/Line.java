package de.telran.shapes_spring.shapes;


public class Line extends Shape {

    private final int length;


    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(getSymbol());
        }
        System.out.println();
    }


    @Override
    public int getCountOfChars() {
        return length;
    }
}
