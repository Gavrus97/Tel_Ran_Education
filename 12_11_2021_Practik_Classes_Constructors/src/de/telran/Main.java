package de.telran;

public class Main {

    public static void main(String[] args) {

        Student vasja = new Student("Vasja", "Vasin", 2);

        System.out.println(vasja.getName());
        System.out.println(vasja.getNumber());
        System.out.println(vasja.getSurname());

        vasja.setName("Petja");
        vasja.setNumber(3);
        vasja.setSurname("Petin");
        System.out.println(vasja.getName());
        System.out.println(vasja.getNumber());
        System.out.println(vasja.getSurname());

        System.out.println("_________________________________________________________________________");

        Car car = new Car("Volvo", 220,2019);
        Truck truck = new Truck("MAN", 160,2019,500);
        PassengerCar passenger = new PassengerCar("Mercedes", 260,2012,5);
        Formula1 formula = new Formula1("McClaren", 400, 2020,2);

        System.out.println(car.getModel());
        System.out.println(truck.getPower());

        Car[] cars = {car, truck, passenger,formula};

    }
}

