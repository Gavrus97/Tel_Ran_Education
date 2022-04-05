import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {

    //необходимо реалтзовать коллектор который будет выдавать медианный эл-т стрима Integer
    // {5, 0, 15} -> {0, 5, 15} -> 5
    // {5, 0, 15, -10, -17, 239} -> {-17, -10, 0, 5, 15, 239} -> 2,5
    public static void main(String[] args) {

        Stream<Integer> intStream = Stream.of(-17, -10, 0, 5, 15, 239);
        Collector<Integer, List<Integer>, Double> medianElementCollector = new MedianElementCollector();
        double median = intStream.collect(medianElementCollector);
        System.out.println(median);
        System.out.println();
        Collector<Double, List<Double>, List<Double>> normalisedNumbersCollector = new NormalisedNumbersCollector();
        Stream<Double> doubleStream = Stream.of(12.0, 34.0, 45.5, 3.5, 5.4, 2.5, 10.3, 15.2);
        System.out.println(doubleStream.collect(normalisedNumbersCollector));
    }
}
