import java.util.ArrayList;
import java.util.List;

public class Main {

    // Тараканьи бега
    // Есть 10 тараканов. Им необходимо пробежать 10 см. Каждый сантиметр таракан пробегает за от 100 до 150 милисекунд.
    // Тараканы бегут одновременно. Составить таблицу пробега (в которой указано имя таракана и его результат).
    public static void main(String[] args) throws InterruptedException {

        List<Score> scores = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        List<Tarakan> tarakans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Tarakan tarakan = new Tarakan(100, 150, 10, startTime,"Tarakan_" + i,scores);
            tarakans.add(tarakan);
        }

        for (Tarakan tarakan : tarakans) {
            tarakan.start();
        }

        for (Tarakan tarakan : tarakans) {
            tarakan.join();
        }

        System.out.println(scores);

    }
}
