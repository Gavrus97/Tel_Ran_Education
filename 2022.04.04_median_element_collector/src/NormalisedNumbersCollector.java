import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Double>, List<Double>> finisher() {
        return list -> {
            List<Double> res = new ArrayList<>();
            double min = Collections.min(list);
            double max = Collections.max(list);
            double splitter = max - min;

            return list.stream()
                    .map(x -> (x - min) / splitter)
                    .collect(Collectors.toList());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
