package de.telran.autos.model;

public class Auto {
    private final String make;
    private final String model;
    private String colour;
    private final int yom;
    private int km;

    public Auto(String make, String model, int yom, String colour) {
        this.make = make;
        this.model = model;
        this.yom = yom;
        this.colour=colour;
    }

    public Auto(String make, String model, int yom, String colour,  int km) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.yom = yom;
        this.km = km;
    }

    public void addKm(int moreKm){
        km += moreKm;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYom() {
        return yom;
    }

    public int getKm() {
        return km;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", yom=" + yom +
                ", km=" + km +
                '}';
    }
}
