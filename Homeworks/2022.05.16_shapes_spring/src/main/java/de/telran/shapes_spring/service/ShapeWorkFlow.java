package de.telran.shapes_spring.service;

import de.telran.shapes_spring.shapes.Shape;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShapeWorkFlow implements CommandLineRunner {

    private final Shape picture1;
    private final Shape picture2;

    public ShapeWorkFlow(Shape picture1, Shape picture2) {
        this.picture1 = picture1;
        this.picture2 = picture2;
    }


    @Override
    public void run(String... args) throws Exception {
        picture1.draw();
        System.out.println();
        picture2.draw();
    }
}
