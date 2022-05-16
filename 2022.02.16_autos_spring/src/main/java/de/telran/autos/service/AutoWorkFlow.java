package de.telran.autos.service;

import de.telran.autos.model.Auto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//tells Spring to create an instance of AutoWorkFlow
@Component
public class AutoWorkFlow implements CommandLineRunner { //CommandLineRunner tells Spring, that after creation
                                                         // of the instance, it is necessary to run the "run" method

    private final AutoService autoService;

    private final Auto opel;
    private final Auto mazda;
    private final Auto bentley;
    private final List<Auto> autos;
    private final List<Auto> cheapAutos;

    public AutoWorkFlow(AutoService autoService,
                        Auto opel,
                        Auto mazda,
                        Auto bentley,
                        List<Auto> autos,
                        @Qualifier("cheapAutos")List<Auto> cheapAutos){

        this.autoService = autoService;
        this.opel = opel;
        this.mazda = mazda;
        this.bentley = bentley;
        this.autos=autos;
        this.cheapAutos = cheapAutos;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring");

        autoService.repaintAuto(mazda,"blue");

        autoService.printAutos(autos);

        System.out.println();

        autoService.printAutos(cheapAutos);
        System.out.println();
    }
}
