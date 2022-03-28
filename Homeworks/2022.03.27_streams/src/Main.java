import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //1
        System.out.println(isPrime(13));

        //2
        IntStream s1 = IntStream.of(1, 60, 2, 45, 4, 5, 6, 15, 30);
        IntStream s2 = IntStream.of(2, 5, 4, 15, 8, 10, 9);
        makeStream(s1, s2).forEach(System.out::println);

        //3
        System.out.println(findFactorial(6));

        //4
        IntStream stream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println(sum(stream1, 1, 5));

        //5
        List<Transaction> transactions1 = Arrays.asList(
                new Transaction("1", "Canceled", 100, 2012L),
                new Transaction("2", "Finished", 30, 2021),
                new Transaction("3", "Processing", 49, 2021),
                new Transaction("4", "Canceled", 50, 2021)
        );

        List<Transaction> transactions2 = Arrays.asList(
                new Transaction("1", "Canceled", 30, 2012L),
                new Transaction("2", "Finished", 20, 2021),
                new Transaction("3", "Processing", 49, 2021),
                new Transaction("4", "Canceled", 20, 2021)
        );

        List<Transaction> transactions3 = Arrays.asList(
                new Transaction("1", "Canceled", 10, 2012L),
                new Transaction("2", "Canceled", 20, 2021),
                new Transaction("3", "Processing", 49, 2021),
                new Transaction("4", "Canceled", 30, 2021)
        );

        List<Account> accounts1 = Arrays.asList(
                new Account("1", 100000, transactions1),
                new Account("2", 20000, transactions2),
                new Account("3", 9000, transactions2)
        );

        List<Account> accounts2 = Arrays.asList(
                new Account("1", 100000, transactions1),
                new Account("2", 0, transactions2),
                new Account("3", -9000, transactions2)
        );
        System.out.println(function(accounts1));
        System.out.println(function(accounts2));

        //6
        List<Employee> employees1 = Arrays.asList(
          new Employee("Vasja", 2000),
          new Employee("Petja", 2500),
          new Employee("Masha", 2300),
          new Employee("Kolya", 2600)
        );

        List<Employee> employees2 = Arrays.asList(
          new Employee("Nikita", 2100),
          new Employee("Kostya", 1800),
          new Employee("Sasha", 2200),
          new Employee("Vera", 2400)
        );

        List<Employee> employees3 = Arrays.asList(
          new Employee("Katya", 1900),
          new Employee("Petya", 2250),
          new Employee("Oleg", 1800),
          new Employee("Varya", 3000)
        );

        List<Department> departments = Arrays.asList(
                new Department("PriorBank", "111-182", employees1),
                new Department("Sparkasse", "110-182", employees2),
                new Department("DeutscheBank", "111-001", employees3)
        );
        System.out.println(countEmployees(departments, 2300));

        //7
        Account_Exercise7 account1 = new Account_Exercise7("1", 90000, false);
        Account_Exercise7 account2 = new Account_Exercise7("2", 100000, false);
        Account_Exercise7 account3 = new Account_Exercise7("3", 97000, false);
        Account_Exercise7 account4 = new Account_Exercise7("4", 110000, true);
        Account_Exercise7 account5 = new Account_Exercise7("5", 96000, false);
        Account_Exercise7 account6 = new Account_Exercise7("6", 98000, false);

        List<Account_Exercise7> accounts = Arrays.asList(
                account1,
                account2,
                account3,
                account4,
                account5,
                account6
        );

        blockAccount(accounts, 98000);
    }

    //1
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;

        return IntStream.range(2, number).filter(x -> number % x == 0).count() == 0;
    }

    //2
    public static IntStream makeStream(IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .distinct()
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2);
    }

    //3
    public static int findFactorial(int s) {
        return IntStream.rangeClosed(1,s).reduce(1, (result, x) -> result * x);
    }

    //4
    public static int sum(IntStream s, int left, int right) {
        return s.filter(x -> x % 2 != 0).limit(right).skip(left).reduce(0, Integer::sum);
    }

    //5
    public static long function(List<Account> accounts) {
        return accounts.stream().filter(x -> x.balance > 0)
                .flatMap(x -> x.transactions.stream()
                        .filter(y -> y.state.equals("Canceled")))
                .map(x -> x.sum)
                .reduce(0L, Long::sum);
    }

    //6
    public static int countEmployees(List<Department> departments, long threshold){
        return (int) departments.stream().filter(x -> x.code.startsWith("111-"))
                .flatMap(x -> x.employees.stream()
                        .filter(y -> y.salary >= threshold))
                .count();
    }

    //7
    public static void blockAccount(List<Account_Exercise7> accounts, long threshold){
        accounts.stream()
                .filter(y -> y.sum > threshold && !y.isLocked)
                .peek(Account_Exercise7::lock)
                .forEach(x -> System.out.println("Account " + x.uuid + " was blocked"));
    }
}
