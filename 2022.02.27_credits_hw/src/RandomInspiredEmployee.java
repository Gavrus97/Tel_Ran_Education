import java.util.List;
import java.util.Random;

public class RandomInspiredEmployee extends Thread {

    final int normalMinTime;
    final int normalMaxTime;
    final int inspiredMinTime;
    final int inspiredMaxTime;
    final long startTime;
    final int creditsNumber;
    final String name;

    final List<Score> scores;
    Random rnd = new Random();

    public RandomInspiredEmployee(int normalMinTime, int normalMaxTime, int inspiredMinTime, int inspiredMaxTime,
                                  long startTime, int creditsNumber, String name, List<Score> scores) {
        this.normalMinTime = normalMinTime;
        this.normalMaxTime = normalMaxTime;
        this.inspiredMinTime = inspiredMinTime;
        this.inspiredMaxTime = inspiredMaxTime;
        this.startTime = startTime;
        this.creditsNumber = creditsNumber;
        this.name = name;
        this.scores = scores;
    }

    @Override
    public void run() {
        for (int i = 0; i < creditsNumber; i++) {

            int inspiration = rnd.nextInt(5) + 1;

            if (inspiration == 1) {
                int inspiredStepTime = rnd.nextInt(inspiredMaxTime - inspiredMinTime + 1) + inspiredMinTime;
                int count = 1;
                while (count <= 3) {
                    try {
                        Thread.sleep(inspiredStepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    i++;
                }
            } else {
                int stepTime = rnd.nextInt(normalMaxTime - normalMinTime + 1) + normalMinTime;
                try {
                    Thread.sleep(stepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        long finalTime = System.currentTimeMillis() - startTime;
        Score sc = new Score(name, finalTime);
        synchronized (scores) {
            scores.add(sc);
        }
    }
}
