import animal.Animal;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // create an instance of a class by itself
        String type = "animal.Cat";

        // forName("fish") returns the Object animal.Fish.class
        Class classFromString = Class.forName(type);
        Animal animal = (Animal) classFromString.getConstructor().newInstance();

        System.out.println(animal.sound());

        AnimalStore animalStore = new AnimalStore();
        Animal animal1 = animalStore.sale("Dog");
        System.out.println(animal1.sound());
    }
}
