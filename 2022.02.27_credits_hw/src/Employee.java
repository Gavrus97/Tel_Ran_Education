import java.util.List;
import java.util.Random;

public class Employee extends Thread{

    final int creditsNumber;
    final long startTime;
    final int minCreditTime;
    final int maxCreditTime;
    final String name;

    final List<Score> scores;
    Random rnd = new Random();

    public Employee(int creditsNumber, long startTime, int minCreditTime, int maxCreditTime, String name, List<Score> scores) {
        this.creditsNumber = creditsNumber;
        this.startTime = startTime;
        this.minCreditTime = minCreditTime;
        this.maxCreditTime = maxCreditTime;
        this.name = name;
        this.scores = scores;
    }

    @Override
    public void run() {
        for (int i = 0; i < creditsNumber; i++) {
            int stepTime = rnd.nextInt(maxCreditTime - minCreditTime + 1) + minCreditTime;
            try {
                Thread.sleep(stepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long finalTime = System.currentTimeMillis() - startTime;
        Score sc = new Score(name, finalTime);
        scores.add(sc);
    }
}
