import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class NormalisedNumbersCollector implements Collector<Double, List<Double>, List<Double>> {

    @Override
    public Supplier<List<Double>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Double>, Double> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
        return (list1, list2) ->{
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Double>, List<Double>> finisher() {
        return list -> {
            Collections.sort(list);
            List<Double> res = new ArrayList<>();
            double min = list.get(0);
            double max = list.get(list.size() - 1);

            for (double temp : list) {
                temp = (temp - min) / (max - min);
                res.add(temp);
            }
            return res;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Collector.Characteristics.CONCURRENT));
    }
}
