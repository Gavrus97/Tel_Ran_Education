package de.telran;

public class Truck extends Car {

    private int power;

    public Truck(String model, int maxSpeed, int productionYear, int power){
        super(model, maxSpeed, productionYear);
        this.power=power;
    }

    public int getPower() {
        return power;
    }
}
