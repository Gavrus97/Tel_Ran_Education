import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayDequeTest {

    CustomDeque<Integer> deque = new CustomArrayDeque<>();

    @Test
    public void testCustomArrayDeque_addLast(){
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);

        assertArrayEquals(new int[]{10,9,8}, deque);
    }

    @Test
    public void testCustomArrayDeque_addFirst(){
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);

        assertArrayEquals(new int[]{8,9,10}, deque);
    }

    @Test
    public void testCustomArrayDeque_getFirst_getLast(){
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);

        assertEquals(8,deque.getLast());
        assertEquals(10,deque.getFirst());
    }

    @Test
    public void testCustomArrayDeque_removeFirst(){
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);

        assertEquals(10,deque.removeFirst());

        deque.removeFirst();
        assertArrayEquals(new int[]{9,8},deque);
    }

    @Test
    public void testCustomArrayDeque_removeLast(){
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(8);

        assertEquals(8,deque.removeLast());

        deque.removeLast();
        assertArrayEquals(new int[]{10,9},deque);
    }

    @Test
    public void testCustomArrayDeque_removeLast_emptyDeque(){
        assertThrows(NoSuchElementException.class, () -> deque.removeLast());
    }

    @Test
    public void testCustomArrayDeque_removeFirst_emptyDeque(){
        assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
    }

    @Test
    public void testCustomArrayDeque_size(){
        deque.addLast(10);
        deque.addLast(11);
        deque.addLast(12);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        assertEquals(6,deque.size());
        assertArrayEquals(new int[]{2,3,4,10,11,12}, deque);
    }



    private void assertArrayEquals(int[] ints, CustomDeque<Integer> deque) {
    }

    //Iterator tests

    CustomDeque<Integer> deq = new CustomArrayDeque<>();

    @Test
    public void testIterator_dequeWith5Elements(){
        deq.addLast(5);
        deq.addLast(6);
        deq.addLast(7);
        deq.addFirst(2);
        deq.addFirst(1);

        Iterator<Integer> deqIterator = deq.iterator();
        int[] array = {1,2,5,6,7};

        int i = 0;
        while(deqIterator.hasNext()){
            int number = deqIterator.next();
            int arrayNumber = array[i];
            assertEquals(number, arrayNumber);
            i++;
        }
        assertEquals(i, 5);
    }

    @Test
    public void testIterator_dequeWith8Elements(){
        deq.addLast(5);
        deq.addLast(6);
        deq.addLast(7);
        deq.addLast(2);
        deq.addLast(1);
        deq.addFirst(4);
        deq.addFirst(9);
        deq.addFirst(10);

        Iterator<Integer> deqIterator = deq.iterator();
        int[] array = {10,9,4,5,6,7,2,1};

        int i = 0;
        while(deqIterator.hasNext()){
            int number = deqIterator.next();
            int arrayNumber = array[i];
            assertEquals(number, arrayNumber);
            i++;
        }
        assertEquals(i,8);
    }


}
