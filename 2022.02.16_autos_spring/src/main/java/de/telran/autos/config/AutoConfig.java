package de.telran.autos.config;

import de.telran.autos.model.Auto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class AutoConfig {

    @Bean
    @Order(2)
    @Qualifier("cheapAutos")
    public Auto opel() {
        return new Auto("Opel", "Astra", 2015, "grey", 100000);
    }

    @Bean
    @Order(1)
    @Qualifier("cheapAutos")
    public Auto mazda() {
        return new Auto("Mazda", "5",2017, "Red", 70000);
    }

    @Bean
    @Order(3)
    public Auto bentley() {
        return new Auto("Bentley", "Continental",2022, "silver");
    }

    @Bean
    public List<Auto> cheapAutos(Auto opel, Auto mazda){
        return List.of(opel, mazda);
    }



}
