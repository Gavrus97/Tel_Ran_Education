package figures;

public class Rectangle extends Shape {

     final int height;
     final int width;
     final Line line;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
        line = new Line(symbol,width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            line.draw();
        }
    }
}
