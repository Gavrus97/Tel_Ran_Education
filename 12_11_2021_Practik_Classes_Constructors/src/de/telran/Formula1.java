package de.telran;

public class Formula1 extends Car{

    private int acceleration;

    public Formula1(String model, int maxSpeed, int productionYear, int acceleration) {
        super(model, maxSpeed, productionYear);
        this.acceleration = acceleration;
    }

    public int getAcceleration() {
        return acceleration;
    }
}
