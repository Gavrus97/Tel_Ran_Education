package de.telran;

public class Main {

    public static void main(String[] args) {
// create an instance of the class Human

        Human vasja = new Human("Vasja", "Vasin", 20);
        Human petja = new Human("Petja", "Kozlow", 36);
        Human sasha = new Human ("Sasha","Pupkin", 47);
        Human olga = new Human("Olga", "Stepanova", 57);
        Human nikita = new Human ("Nikita", "Burak", 98);
        Human masha = new Human("Masha", "Petrova", 37,"Maria.pet@gmail.com");

        olga.introduce();
        nikita.introduce();
        vasja.introduce();
        petja.introduce();
        sasha.introduce();

//        System.out.println(vasja.getName());
//        System.out.println(vasja.getAge());
//        System.out.println(vasja.getSurname());


        System.out.println(Human.getHumanNumber());//2
        System.out.println(Human.getAverageAge());//28

        nikita.die();
        vasja.die();
        olga.die();
        System.out.println(Human.getHumanNumber());//1
        System.out.println(Human.getAverageAge());//36

        vasja.setEmail("vasja.vas@gmail.com");
        System.out.println(vasja.getEmail());
        System.out.println(masha.getEmail());
        System.out.println(nikita.getEmail());
    }
}


