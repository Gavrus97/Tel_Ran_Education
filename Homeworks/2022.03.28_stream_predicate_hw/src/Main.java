import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
    }

    public <T> Predicate<T> intersect(List<Predicate<T>> list){
        if(list.size() == 0)
            throw new IllegalArgumentException();
        return list.stream().reduce(Predicate::and).get();
    }

    public <T> Predicate<T> union (List<Predicate<T>> list){
        if(list.size() == 0)
            throw new IllegalArgumentException();
        return list.stream().reduce(Predicate::or).get();
    }

    public List<String> findBadWords(Set<String> badWords, String text){
        return Stream.of(text.replaceAll("[,.:;?!]", "").split(" "))
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
