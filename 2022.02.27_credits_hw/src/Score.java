public class Score {

    String name;
    long time;

    public Score(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Employee " + name + " gave all credits for " + time + " milliseconds\n";
    }
}
