import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Long> stream = Stream.of(100L, 34L, 5L);
        stream.map(x -> x / 2);
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1, 5, 8),
                Arrays.asList(-5, 7),
                Arrays.asList(10, 50, -8));
        //Function<List<Integer> , Stream<Integer>>unwrap = list -> list.stream();
        //System.out.println(listStream.flatMap(unwrap).collect(Collectors.toList()));

        //есть коллекция строк. Хотим составить строку состоязую из всех сдлв короче 5 букв в uppercase каждле слово
        // встречается один раз
        List<String> words = Arrays.asList("Hello", "word", "and", "Vasja", "in", "the", "world");
        String res = words.stream().filter(x -> x.length() < 5).map(String::toUpperCase).distinct().reduce(
                "", (accumulated, currentElement) -> accumulated + currentElement);
        System.out.println(res);


    }
}
