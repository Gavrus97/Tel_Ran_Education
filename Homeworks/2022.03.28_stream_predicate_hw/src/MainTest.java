import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    List<Predicate<Integer>> predicates = Arrays.asList(x -> x % 2 == 0, y -> y % 4 == 0);
    List<Predicate<Integer>> predicates1 = new ArrayList<>();

    //intersect
    @Test
    public void testIntersect_1(){
        assertFalse(main.intersect(predicates).test(1));
    }

    @Test
    public void testIntersect_2(){
        assertFalse(main.intersect(predicates).test(2));
    }

    @Test
    public void testIntersect_3(){
        assertFalse(main.intersect(predicates).test(3));
    }

    @Test
    public void testIntersect_4(){
        assertTrue(main.intersect(predicates).test(4));
    }

    @Test
    public void testIntersect_6(){
        assertFalse(main.intersect(predicates).test(6));
    }

    @Test
    public void testIntersect_8(){
        assertTrue(main.intersect(predicates).test(8));
    }

    @Test
    public void testIntersect_empty_list(){
        assertThrows(IllegalArgumentException.class, () ->  main.intersect(predicates1).test(1));
    }

    //union

    @Test
    public void testUnion_1(){
        assertFalse(main.union(predicates).test(1));
    }

    @Test
    public void testUnion_2(){
        assertTrue(main.union(predicates).test(2));
    }

    @Test
    public void testUnion_3(){
        assertFalse(main.union(predicates).test(3));
    }

    @Test
    public void testUnion_4(){
        assertTrue(main.union(predicates).test(4));
    }

    @Test
    public void testUnion_6(){
        assertTrue(main.union(predicates).test(6));
    }

    @Test
    public void testUnion_8(){
        assertTrue(main.union(predicates).test(8));
    }

    @Test
    public void testUnion_emty_list(){
        assertThrows(IllegalArgumentException.class, () -> main.union(predicates1).test(1));
    }

    //findBadWords
    @Test
    public void testFindBadWords() {
        String text = "Маша взяла ручку, стала писать письмо Пете ,о том как он ее бесит. Через день Петя получил " +
                "письмо и написал ответ: Маша, это взаимно!";

        Set<String> badWords = new HashSet<>();
        badWords.add("писать");
        badWords.add("бесит");
        badWords.add("о");
        badWords.add("письмо");
        badWords.add("он");
        badWords.add("ручку");
        badWords.add("взаимно");

        List<String> expected = Arrays.asList(
                "бесит",
                "взаимно",
                "о",
                "он",
                "писать",
                "письмо",
                "ручку"
        );
        assertEquals(expected, main.findBadWords(badWords, text));
    }

    @Test
    public void testFindBadWords_emptyText(){
        String text = "";

        Set<String> badWords = new HashSet<>();
        badWords.add("писать");
        badWords.add("бесит");
        badWords.add("о");
        badWords.add("письмо");
        badWords.add("он");
        badWords.add("ручку");
        badWords.add("взаимно");

        List<String> expected = new ArrayList<>();

        assertEquals(expected, main.findBadWords(badWords, text));
    }

    @Test
    public void testFindBadWords_emptySet(){
        String text = "Маша взяла ручку, стала писать письмо Пете ,о том как он ее бесит. Через день Петя получил " +
                "письмо и написал ответ: Маша, это взаимно!";

        Set<String> badWords = new HashSet<>();

        List<String> expected = new ArrayList<>();

        assertEquals(expected, main.findBadWords(badWords, text));

    }

}