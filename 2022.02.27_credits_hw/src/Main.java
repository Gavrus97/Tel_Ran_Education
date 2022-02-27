import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //ДЗ
        //Вася, Петя и Маша выдают кредиты. Маша тратит на каждый кредит от 100 до 150
        // милисекунд. Петя тратит на каждый кредит от 150 до 200 милисекунд.
        // Вася в обычном расположении духа тратит на каждый кредит от 150 до 200 милисекунд,
        // но иногда на него снисходит вдохновение, и он тратит на последующие 3 кредита
        // от 50 до 100 милисекунд. Вероятность того, что Вася станет вдохновленным,
        // если он не вдохновлен в данный момент, равняется 20%. Необходимо выдать 20 кредитов.
        // Составить лист результов для работников.

        List<Score> scores = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        Employee masha = new Employee(20, startTime, 100, 150,
                "Masha", scores);

        Employee petja = new Employee(20, startTime, 150, 200,
                "Petja", scores);

        RandomInspiredEmployee vasja = new RandomInspiredEmployee(150, 200,
                50, 100, startTime, 20, "Vasja", scores);


        masha.start();
        petja.start();
        vasja.start();

        masha.join();
        petja.join();
        vasja.join();

        System.out.println(scores);
    }

}
