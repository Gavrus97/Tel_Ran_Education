package de.telran.shapes_spring.config;

import de.telran.shapes_spring.shapes.Line;
import de.telran.shapes_spring.shapes.Picture;
import de.telran.shapes_spring.shapes.Rectangle;
import de.telran.shapes_spring.shapes.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShapesConfig {

    @Bean
    @Qualifier("1")
    public Shape line8() {
        return new Line('@', 8);
    }

    @Bean
    @Qualifier("1")
    public Shape line10() {
        return new Line('%', 10);
    }

    @Bean
    @Qualifier("2")
    public Shape line5() {
        return new Line('*', 5);
    }

    @Bean
    @Qualifier("1")
    public Shape rectangle1() {
        return new Rectangle('#', 4, 8);
    }

    @Bean
    @Qualifier("2")
    public Shape rectangle2() {
        return new Rectangle('^', 7, 12);
    }

    @Bean
    public List<Shape> list1() {
        return List.of(line8(), line10(), rectangle1());
    }

    @Bean
    public List<Shape> list2() {
        return List.of(rectangle2(),line5());
    }

    @Bean
    public Shape picture1 (){
        return new Picture(list1());
    }

    @Bean
    public Shape picture2 (){
        return new Picture(list2());
    }

}
