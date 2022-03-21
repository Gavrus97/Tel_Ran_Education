import java.util.function.*;

public class Main {

    static String GREETINGS = "Hello";

    public static void main(String[] args) {

        Function<Double, Double> sqrt = Math::sqrt;

        Function<Double, Double> sqrt2 = sqrt::apply;
        Function<Double, Double> sqrt3 = sqrt;

        System.out.println(sqrt == sqrt2); //false
        System.out.println(sqrt == sqrt3); //true

        Supplier<String> generator = String::new;
        Function<String, String> identity = String::new;

        //closure - замыкание
        String greetings = "vasja";
        Function<String, String> hello = (String name) -> GREETINGS + name;

        // принимает строку и распечатывает в консоль
        Consumer<String> printer = System.out::println;
        printer.accept("Hello 22 group");

        IntPredicate isEven = x -> x % 2 == 0;

        // IntSupplier                          // () -> 3
        // Consumer<String>                     // System.out::println
        // DoubleUnaryOperator                  // Math::sin
        // BiPredicate<Integer, Integer>        //(x,x) -> x % 5 == 0
        // Function<Double, String>             // (x) -> String.valueOf(x)

        Function<String, Double> f1 = Double::valueOf; // f.apply("125") -> 125.0
        Function<Integer, String> g1 = String::valueOf; // g.apply(239) -> "239"
        Function<Integer, Double> h1 = f1.compose(g1); // h.apply(38) ~ f.apply(g.apply(38))

        Function<Double, Double> f = x -> x * x + 3 * x + 5;
        Function<Double, Double> g = x -> 3 * x - 7;

        Function<Double,Double> h = f.compose(g);   // одно и тоже
                                                    //    ||
        Function<Double, Double> h2 = g.andThen(f); // одно и тоже

        System.out.println(h.apply(3.0)); // 15
        System.out.println(h2.apply(3.0)); // 15

        // Предикаты
        IntPredicate isOdd = x -> x % 2 != 0;
        IntPredicate dividedByThree = x -> x % 3 == 0;
        IntPredicate isOddAndDividedByThree = isOdd.and(dividedByThree); // оба условия проверяются
        IntPredicate isEvenOrDividedByThree = isOdd.negate().or(dividedByThree); // отрицание negate() и функция or()
    }
}
