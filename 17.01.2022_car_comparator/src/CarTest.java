import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    public void testComparator(){
        Car car1 = new Car(100000,2010,"porsche");
        Car car2 = new Car(100000,2012,"volkswagen");
        Car car3 = new Car(90000,2010,"opel");
        Car car4 = new Car(60000,2017,"mercedes");
        Car car5 = new Car(100000,2018,"bmw");

        List<Car> cars = Arrays.asList(car1,car2,car3,car4,car5);
        Collections.sort(cars,new CarComparator());

        String[]array = {"bmw", "mercedes", "volkswagen", "opel", "porsche"};

        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).toString(),array[i]);
        }

    }


}