import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    //1
    public int sumSqrt(Stream<Integer> stream) {
        return stream.collect(summingInt(x -> x * x));
    }

    //2
    public int multiplySqrt(Stream<Integer> stream) {
        return stream.collect(reducing(1, (res, cur) -> cur * cur * res));
    }

    //3

    public Map<Boolean, List<String>> palindromes(List<String> strings) {
        return strings.stream()
                .collect(partitioningBy(Main::isPalindrome));
    }

    public Map<Boolean, Long> countPalindrome(List<String> strings) {
        return strings.stream()
                .collect(partitioningBy(Main::isPalindrome, counting()));
    }

    public static boolean isPalindrome(String s) {
        boolean res = false;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i))
                res = true;
            else return false;
        }
        return res;
    }

    //4
    public Map<String, Long> totalTransactionsByAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(groupingBy(Transaction::getAccountUuid,
                        summingLong(Transaction::getSum)));
    }

    //5 a
    public Map<String, Long> countVisitsByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }

    //5 b
    public Map<String, Long> countUniqueVisits(List<LogEntry> logs){
        return logs.stream()
                .collect(collectingAndThen(groupingBy(LogEntry::getUrl, toSet()), ));
    }

    //5 c
    public Map<String, Set<String>> getSetOfVisitsByLogin(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getLogin, mapping(LogEntry::getUrl, toSet())));
    }
}

class Transaction {
    String uuid;
    long sum;
    String accountUuid;

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public Transaction(String uuid, long sum, String accountUuid) {
        this.uuid = uuid;
        this.sum = sum;
        this.accountUuid = accountUuid;
    }

}

class LogEntry {
    String login;
    String url;

    public LogEntry(String login, String url) {
        this.login = login;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }
}
