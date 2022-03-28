import java.util.List;
import java.util.function.Predicate;

public class PredicateService {

    /**
     * @param list a list of predicates
     * @return the intersection of the predicates
     * @throws IllegalArgumentException if no items in the list
     */
    public <T> Predicate<T> intersect(List<Predicate<T>> list) {
        if(list.size() == 0) throw new IllegalArgumentException();

        Predicate<T> startPredicate = list.get(0);
        int count = 1;
        while (count < list.size()) {
            startPredicate = startPredicate.and(list.get(count));
            count++;
        }
        return startPredicate;
    }

    /**
     * @param list a list of predicates
     * @return the union of the predicates
     * @throws IllegalArgumentException if no items in the list
     */
    public <T> Predicate<T> union(List<Predicate<T>> list) {
        if(list.size() == 0) throw new IllegalArgumentException();

        Predicate<T> startPredicate = list.get(0);
        int count = 1;
        while (count < list.size()) {
            startPredicate = startPredicate.or(list.get(count));
            count++;
        }
        return startPredicate;
    }
}
