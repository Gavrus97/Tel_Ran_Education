import animal.Animal;

import java.lang.reflect.InvocationTargetException;

public class AnimalStore {

    // Violates the second SOLID principle.
    // S - single responsibility - принип единой ответсвенноести. Метод должен решать одну задачу.
    // Класс должен описывать только что-то одно
    // O - open close. Код открыт к расширению но закрыт к изменению.

    /**
     * the method accepts a type of the wanted animal as a name of the class.
     * @param type the name of the class
     * @return an instance of the class
     */
    public Animal sale(String type) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       String newType = "animal.".concat(type);
       Class<?> classFromString = Class.forName(newType);
       return (Animal) classFromString.getConstructor().newInstance();
    }
}
