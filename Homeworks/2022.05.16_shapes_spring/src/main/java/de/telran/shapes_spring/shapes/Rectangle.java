package de.telran.shapes_spring.shapes;

public class Rectangle extends Shape {

    private final int height;
    private final int width;
    private final char symbol;

    public Rectangle(char symbol, int height, int width) {
        this.symbol = symbol;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height) {
                    System.out.print(symbol);
                }
                else{
                   if (j == 1 || j == width)
                       System.out.print(symbol);
                   else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int getCountOfChars() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
