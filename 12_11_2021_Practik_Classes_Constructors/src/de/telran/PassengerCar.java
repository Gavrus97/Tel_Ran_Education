package de.telran;

public class PassengerCar extends Car {

    private int seatsNumber;

    public PassengerCar(String model, int maxSpeed, int productionYear, int seatsNumber) {
        super(model, maxSpeed, productionYear);
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }
}
