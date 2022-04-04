import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void test_sumSqrt() {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4);
        assertEquals(30, main.sumSqrt(s1));
    }

    @Test
    public void test_multiplySqrt() {
        Stream<Integer> s2 = Stream.of(1, 2, 3, 4);
        assertEquals(576, main.multiplySqrt(s2));
    }

    @Test
    public void test_palindromes() {
        List<String> strings = Arrays.asList("mam", "mama", "pep", "sos", "papa");
        Map<Boolean, List<String>> res = new HashMap<>();
        res.put(false, Arrays.asList("mama", "papa"));
        res.put(true, Arrays.asList("mam", "pep", "sos"));
        assertEquals(res, main.palindromes(strings));
    }

    @Test
    public void test_countPalindrome() {
        List<String> strings = Arrays.asList("mam", "mama", "pep", "sos", "papa");
        Map<Boolean, Long> res = new HashMap<>();
        res.put(false, 2L);
        res.put(true, 3L);
        assertEquals(res, main.countPalindrome(strings));
    }

    @Test
    public void test_totalTransactionByAccount() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", 100, "12"),
                new Transaction("2", 10, "12"),
                new Transaction("3", 15, "25"),
                new Transaction("4", 20, "36"),
                new Transaction("5", 40, "25"),
                new Transaction("6", 15, "12"),
                new Transaction("7", 5, "36")
        );
        Map<String, Long> res = new HashMap<>();
        res.put("12", 125L);
        res.put("25", 55L);
        res.put("36", 25L);
        assertEquals(res, main.totalTransactionsByAccount(transactions));
    }

    @Test
    public void test_countVisitsByUrl() {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 15", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de"),
                new LogEntry("MacBook Air 13", "www.bahn.de"),
                new LogEntry("MacBook Air 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de")
        );
        Map<String, Long> res = new HashMap<>();
        res.put("www.tel-ran.de", 5L);
        res.put("www.bahn.de", 3L);
        res.put("www.sparkasse.de", 2L);
        assertEquals(res, main.countVisitsByUrl(logs));
    }

    @Test
    public void test_getSetOfVisitsByLogin() {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 15", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de"),
                new LogEntry("MacBook Air 13", "www.bahn.de"),
                new LogEntry("MacBook Air 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.bahn.de"),
                new LogEntry("MacBook Pro 15", "www.sparkasse.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de")
        );

        Set<String> mbPro13 = new HashSet<>();
        mbPro13.add("www.tel-ran.de");
        mbPro13.add("www.sparkasse.de");
        mbPro13.add("www.bahn.de");

        Set<String> mbPro15 = new HashSet<>();
        mbPro15.add("www.tel-ran.de");
        mbPro15.add("www.sparkasse.de");

        Set<String> mbAir13 = new HashSet<>();
        mbAir13.add("www.bahn.de");
        mbAir13.add("www.tel-ran.de");

        Set<String> lenovo = new HashSet<>();
        lenovo.add("www.tel-ran.de");
        lenovo.add("www.bahn.de");

        Map<String, Set<String>> res = new HashMap<>();
        res.put("MacBook Pro 13", mbPro13);
        res.put("MacBook Pro 15", mbPro15);
        res.put("MacBook Air 13", mbAir13);
        res.put("Lenovo PC", lenovo);
        assertEquals(res, main.getSetOfVisitsByLogin(logs));
    }

    @Test
    public void test_countUniqueVisits(){
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 15", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.tel-ran.de"),
                new LogEntry("Lenovo PC", "www.bahn.de"),
                new LogEntry("MacBook Pro 13", "www.sparkasse.de"),
                new LogEntry("MacBook Air 13", "www.bahn.de"),
                new LogEntry("MacBook Air 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de"),
                new LogEntry("MacBook Pro 13", "www.bahn.de"),
                new LogEntry("MacBook Pro 15", "www.sparkasse.de"),
                new LogEntry("MacBook Pro 13", "www.tel-ran.de")
        );

        Map<String, Integer> res = new HashMap<>();
        res.put("www.tel-ran.de", 4);
        res.put("www.bahn.de", 3);
        res.put("www.sparkasse.de", 2);
        assertEquals(res, main.countUniqueVisits(logs));

    }
}