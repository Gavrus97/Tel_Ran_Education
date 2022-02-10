package list;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class CustomListTest {

    CustomList<Integer> intList;
    CustomList<String> stringList;


    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {

        assertThrows(CustomOutOfBoundsException.class, () -> intList.set(0, 10));
    }

    //remove by id
    @Test
    public void testRemoveById_idTwo() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertEquals(3, intList.removeById(2));
        assertListContents(new int[]{1, 3, 4});

    }

    @Test
    public void testRemoveById_idThree() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertEquals(4, intList.removeById(3));
        assertListContents(new int[]{1, 3, 3});

    }

    @Test
    public void testRemoveById_idZero() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertEquals(1, intList.removeById(0));
        assertListContents(new int[]{3, 3, 4});
    }

    @Test
    public void testRemoveById_idTwFour() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertThrows(CustomOutOfBoundsException.class, () -> intList.removeById(4));
    }

    //remove by Value
    @Test
    public void testRemoveByValue_one() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertTrue(intList.removeByValue(1));
    }

    @Test
    public void testRemoveByValue_three() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertTrue(intList.removeByValue(3));
    }

    @Test
    public void testRemoveByValue_twoFalse() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);
        assertFalse(intList.removeByValue(2));
    }

    @Test
    public void testGetAdd_threeNumbers() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);
        assertEquals(20, intList.get(0));
        assertEquals(10, intList.get(1));
        assertEquals(-5, intList.get(2));
    }

    @Test
    public void testAddSize_threeNumbers() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        assertEquals(7, intList.size());
    }

    @Test
    public void testAddGet_100RandomNumbers() {
        int[] randomNumbers = generateRandomNumbers(100);

        for (int i = 0; i < randomNumbers.length; i++) {
            intList.add(randomNumbers[i]);
        }

        assertListContents(randomNumbers);
    }

    protected void assertListContents(int[] array) {
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], intList.get(i));
        }
    }

    private int[] generateRandomNumbers(int n) {
        int[] res = new int[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            res[i] = rnd.nextInt();
        }
        return res;
    }

    @Test
    public void testContains_severalNumbers_true() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);
        assertTrue(intList.contains(10));
    }

    //string
    //remove by value
    @Test
    public void testRemoveByValue_mikeFalse() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertFalse(stringList.removeByValue("mike"));
    }

    @Test
    public void testRemoveByValue_hello() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertTrue(stringList.removeByValue("hello"));
    }

    @Test
    public void testRemoveByValue_everyone() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertTrue(stringList.removeByValue("everyone"));
    }

    //remove by id
    @Test
    public void testRemoveById_one() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertEquals("world", stringList.removeById(1));
    }

    @Test
    public void testRemoveById_zero() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertEquals("hello", stringList.removeById(0));
    }

    @Test
    public void testRemoveById_fourException() {
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("everyone");
        assertThrows(CustomOutOfBoundsException.class, () -> stringList.removeById(4));
    }

    @Test
    public void testInsert_EmptyList() {
        intList.insert(0, 10);

        //assertEquals(1,intList.size());

        assertListContents(new int[]{10});
    }

    @Test
    public void testInsert_nonEmptyList() {
        intList.add(10);
        intList.insert(0, 15);

        assertEquals(2, intList.size());

        assertListContents(new int[]{15, 10});
    }

    @Test
    public void testInsert_nonEmptyListMiddleIndex() {
        intList.add(10);
        intList.add(18);
        intList.insert(1, 15);

        assertEquals(3, intList.size());

        assertListContents(new int[]{10, 15, 18});
    }

    @Test
    public void testIterator_severalElements() {
        intList.add(5);
        intList.add(10);
        intList.add(2);
        intList.add(25);
        intList.add(6);

        int[] expected = {5, 10, 2, 25, 6};

        Iterator<Integer> iterator = intList.iterator();

        int i = 0;
        while(iterator.hasNext()){
           int currentNumber = iterator.next();
           assertEquals(expected[i], currentNumber);
           i++;
        }
        assertEquals(i, expected.length);
    }

    @Test
    public void testIterator_oneElement(){
        intList.add(4);
        intList.add(4);
        Iterator<Integer> iterator = intList.iterator();

        int i = 0;
        while(iterator.hasNext()){
            int currentNumber = iterator.next();
            assertEquals(4, currentNumber);
            i++;
        }
        assertEquals(i, 2);
    }

    @Test
    public void testIterator_zeroElements(){
        Iterator<Integer> iterator = intList.iterator();

        int i = 0;
        while(iterator.hasNext()){
            int currentNumber = iterator.next();
            assertEquals(4, currentNumber);
            i++;
        }
        assertEquals(i, 0);
    }




}


