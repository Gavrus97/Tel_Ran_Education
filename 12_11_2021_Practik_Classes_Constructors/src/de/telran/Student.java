package de.telran;

public class Student {

    private String name;
    private int number;
    private String surname;

    public Student(String specifiedName, String specifiedSurname, int specifedNumber){
        this.name = specifiedName;
        this.number = specifedNumber;
        this.surname = specifiedSurname;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
