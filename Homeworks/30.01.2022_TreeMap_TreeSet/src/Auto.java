import java.util.*;

public class Auto{

    private final String make;
    private final String model;
    private final int price;


    public Auto(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Auto() {
        this.make = null;
        this.model = null;
        this.price = 0;
    }

    //(*)Есть класс автомобиль, в котором есть два три поля:
    // Марка, Модель, Цена. Написать функцию, которая принимает лист автомобилей,
    // а возвращает TreeMap, ключами которого являются марки автомобилей,
    // а значениями будут TreeSet автомобилей, в котором автомобили расположены
    // в лексикографическом порядке относительно модели, причем дешевые вперед
    // (необходимо написать правильный компаратор, который будет складывать автомобили в TreeSet в правильном порядке)
    public TreeMap<String, TreeSet<Auto>> autosMap(List<Auto> autos){
        TreeMap<String, TreeSet<Auto>> res = new TreeMap<>();
        autos.sort(new AutoComparator());
        int nextAuto = 0;

        while (nextAuto < autos.size()) {
            int i = nextAuto;
            String autoKey = autos.get(i).make;
            TreeSet<Auto> autoTreeSet = new TreeSet<>(new AutoComparator());

            for (int j = i; j < autos.size(); j++) {
                if (autos.get(j).make.equals(autoKey))
                    autoTreeSet.add(autos.get(j));
                else {
                    nextAuto = j;
                    break;
                }
            }
            if (!res.containsKey(autoKey))
                res.put(autoKey, autoTreeSet);
            else
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        return  "{ " +
                make + " " +
                model + " " +
                price + "$" +
                "}";
    }

    private static class AutoComparator implements Comparator<Auto>{
    @Override
    public int compare(Auto o1, Auto o2) {
        if(o1.make.equals(o2.make)){
            if(o1.model.equals(o2.model))
                return o1.price - o2.price;
            else
                return o1.model.compareTo(o2.model);
        }
        else
            return o1.make.compareTo(o2.make);
    }
}
}
