import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<List<String>, List<String>> fc = (List<String> list) -> {
            Set<String> set = new HashSet<>(list);
            return new ArrayList<>(set);
        };
        System.out.println(fc.apply(Arrays.asList("Vasja", "Petja", "Vasja", "Petja", "Masha")));


        BiFunction<Integer, Integer, Integer> summarizer = (Integer x, Integer y) ->  x + y;
        System.out.println(summarizer.apply(10, 5));


        print((String input) -> {
            return input;
        }, "Vasja");

        print2((String input) -> {
            return input;
        }, "Vasja");
    }

    public static void print(OurFunctionalInterface ourFunctionalInterface, String line){
        System.out.println(ourFunctionalInterface.print(line));
    }

    public static void print2(AnotherFunctionalInterface anotherFunctionalInterface, String line){
        System.out.println(anotherFunctionalInterface.some(line));
    }
}

interface OurFunctionalInterface{
    public String print(String line);
}

interface AnotherFunctionalInterface{
    public String some(String line);
}
