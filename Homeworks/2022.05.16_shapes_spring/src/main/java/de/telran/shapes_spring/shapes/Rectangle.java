package de.telran.shapes_spring.shapes;

public class Rectangle extends Shape {

    private final int height;
    private final int width;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height) {
                    System.out.print(getSymbol());
                }
                else{
                   if (j == 1 || j == width)
                       System.out.print(getSymbol());
                   else System.out.print(" ");
                }
            }
            System.out.println();
        }
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
