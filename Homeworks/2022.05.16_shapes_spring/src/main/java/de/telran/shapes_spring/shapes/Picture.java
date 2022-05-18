package de.telran.shapes_spring.shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Picture extends Shape{

    private final List<Shape> shapes;
    private final int frameSize;


    public Picture(List<Shape> shapes, char symbol) {
        super(symbol);
        this.shapes = new ArrayList<>(shapes);
        this.frameSize = getCountOfChars();
    }

    @Override
    public void draw() {
        drawBorder();
        for (Shape shape : shapes){
            shape.draw();
        }
        drawBorder();
    }



    @Override
    public int getCountOfChars() {
        return shapes
                .stream()
                .mapToInt(Shape::getCountOfChars)
                .max()
                .orElse(0);
    }


    public List<Shape> getShapes() {
        return shapes;
    }

    public int getFrameSize() {
        return frameSize;
    }

    private void drawBorder(){
        for (int i = 0; i < frameSize; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
