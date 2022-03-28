import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        //1.
        int a = 2;
        int b = 3;
        int c = 7;
        Function<Double, Double> f = x -> a * x * x + b * x + c;
        System.out.println(f.apply(2.0));

        //2.
        List<Account> accounts = Arrays.asList(new Account(1, 2000, false),
                new Account(2, 12000, true),
                new Account(3, 11000, false),
                new Account(4, -120, false));

        Function<List<Account>, List<Account>> firstFilter = list -> {
            List<Account> res = new ArrayList<>();
            for (Account account : list) {
                if (account.getBalance() > 0)
                    res.add(account);
            }
            return res;
        };

        System.out.println(firstFilter.apply(accounts));

        Function<List<Account>, List<Account>> secondFilter = list -> {
            List<Account> res = new ArrayList<>();
            for (Account account : list) {
                if (!account.isLocked() && account.getBalance() > 10000)
                    res.add(account);
            }
            return res;
        };
        System.out.println(secondFilter.apply(accounts));

        //3.
        TernaryIntPredicate predicate = (x, y, z) -> x != y && x != z && y != z;

        //4.
        Function<Integer, Integer> f1 = x -> 2 * x;
        Function<Integer, Integer> h = x -> x + 3;
        Function<Integer, Integer> g = f1.compose(h);
        System.out.println(g.apply(2));

        //5.
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x % 2 == 0, y -> y % 4 == 0);
        PredicateService predicateService = new PredicateService();
        Predicate<Integer> result1 = predicateService.intersect(predicates);
        System.out.println("Predicate Service - intersect");
        System.out.println(result1.test(2)); // false
        System.out.println(result1.test(4)); // true
        Predicate<Integer> result2 = predicateService.union(predicates);
        System.out.println("Predicate service - union");
        System.out.println(result2.test(2)); // true
        System.out.println(result2.test(4)); // true
        System.out.println(result2.test(3)); // false
    }
}
