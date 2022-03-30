import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
    }

    public <T> Predicate<T> intersect(List<Predicate<T>> list){
        return list.stream().reduce(Predicate::and).orElseThrow(IllegalArgumentException::new);//метод orElseThrow
    }

    public <T> Predicate<T> union (List<Predicate<T>> list){
        if(list.size() == 0)
            throw new IllegalArgumentException();
        return list.stream().reduce(Predicate::or).get();

    }

    public List<String> findBadWords(Set<String> badWords, String text){
        return Stream.of(text.replaceAll("[,.:;?!]", "").split(" "))
                .map(String::toLowerCase)
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
