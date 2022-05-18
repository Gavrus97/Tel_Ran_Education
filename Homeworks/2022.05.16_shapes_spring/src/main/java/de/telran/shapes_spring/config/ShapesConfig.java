package de.telran.shapes_spring.config;

import de.telran.shapes_spring.shapes.Line;
import de.telran.shapes_spring.shapes.Picture;
import de.telran.shapes_spring.shapes.Rectangle;
import de.telran.shapes_spring.shapes.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class ShapesConfig {

    @Bean
    @Qualifier("1")
    @Order(1)
    public Shape line8() {
        return new Line('@', 8);
    }

    @Bean
    @Qualifier("1")
    @Order(3)
    public Shape line10() {
        return new Line('%', 10);
    }

    @Bean
    @Qualifier("2")
    @Order(1)
    public Shape line5() {
        return new Line('*', 5);
    }

    @Bean
    @Qualifier("1")
    @Order(2)
    public Shape rectangle1() {
        return new Rectangle('#', 4, 8);
    }

    @Bean
    @Qualifier("2")
    @Order(2)
    public Shape rectangle2() {
        return new Rectangle('^', 7, 12);
    }

    @Bean
    public Shape picture1 (@Qualifier("1")List<Shape> shapes){
        return new Picture(shapes, '!');
    }

    @Bean
    public Shape picture2 (@Qualifier("2")List<Shape> shapes){
        return new Picture(shapes, '?');
    }

}
