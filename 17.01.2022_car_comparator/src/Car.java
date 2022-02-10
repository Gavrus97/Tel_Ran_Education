import java.util.Comparator;

public class Car {

    int km;
    int year;
    String make;

    public Car(int km, int year, String make) {
        this.km = km;
        this.year = year;
        this.make = make;
    }

    @Override
    public String toString() {
        return make;
    }
}
    class CarComparator implements Comparator<Car>{

        @Override
        public int compare(Car o1, Car o2) {
            if (o1.year == o2.year)
                return o1.km - o2.km;

            return o2.year - o1.year;
        }
    }

