package de.telran.shapes_spring.shapes;

import java.util.Arrays;
import java.util.List;

public class Picture extends Shape{

    private final List<Shape> shapes;
    private final int frameSize;
    private final List<String> frame = Arrays.asList("This", "is", "a", "frame");


    public Picture(List<Shape> shapes) {
        this.shapes = shapes;
        this.frameSize = getCountOfChars();
    }

    @Override
    public void draw() {
//        for (int i = 0; i < frameSize; i++) {
//            System.out.print("FrAmE");
//        }
//        System.out.println();

        for (String s : frame){
            System.out.print(s + " ");
        }
        System.out.println();

        for (Shape shape : shapes){
            shape.draw();
        }
//        for (int i = 0; i < frameSize; i++) {
//            System.out.print("FrAmE");
//        }

        for (String s : frame){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public char getSymbol() {
        return 0;
    }

    @Override
    public int getCountOfChars() {
        return shapes
                .stream()
                .max((x,y) -> Integer.compare(x.getCountOfChars(), y.getCountOfChars()))
                .get()
                .getCountOfChars();
    }


    public List<Shape> getShapes() {
        return shapes;
    }

    public int getFrameSize() {
        return frameSize;
    }
}
