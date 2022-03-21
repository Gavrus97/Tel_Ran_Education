import java.util.List;
import java.util.function.Predicate;

public class PredicateService<T> {

    public Predicate<T> intersect(List<Predicate<T>> list) {
        Predicate<T> startPredicate = list.get(0);
        int count = 1;
        while (count < list.size()) {
            startPredicate = startPredicate.and(list.get(count));
            count++;
        }
        return startPredicate;
    }

    public Predicate<T> union(List<Predicate<T>> list) {
        Predicate<T> startPredicate = list.get(0);
        int count = 1;
        while (count < list.size()) {
            startPredicate = startPredicate.or(list.get(count));
            count++;
        }
        return startPredicate;
    }
}
