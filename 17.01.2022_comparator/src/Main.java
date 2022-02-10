import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human vasja = new Human(70, false,"vasja");
        Human petja = new Human(50, false, "petja");
        Human masha = new Human(30, true, "masha");
        Human tanja = new Human(40, true, "tanja");

        List<Human> humans = Arrays.asList(vasja, petja, masha, tanja);
        humans.sort(new VaccinationComparator()); // tanja, masha, vasja, petja
        System.out.println(humans);
    }
}

    class Human{
        int age;
        boolean isDoctor;
        String name;

        public Human(int age, boolean isDoctor, String name) {
            this.age = age;
            this.isDoctor = isDoctor;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    class VaccinationComparator implements Comparator<Human>{

        @Override
        public int compare(Human o1, Human o2) {
           if (o1.isDoctor && !o2.isDoctor)
               return -1;
           if(!o1.isDoctor && o2.isDoctor)
               return 1;

           return o2.age - o1.age;
        }
    }
