import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class MaxStackTest {

    MaxStack stack;

    @Test
    public void testAdd(){
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.remove();
        assertEquals(2,stack.size());
    }



    @Test
    public void testMaxStack_getMax(){
        stack.add(1);
        stack.add(2);
        stack.add(4);
        stack.add(3);

        int max = stack.getMax();
        assertEquals(max, 4);
    }

    @Test
    public void testMaxStack_getMaxFirstMax(){
        stack.add(5);
        stack.add(2);
        stack.add(4);
        stack.add(3);

        int max = stack.getMax();
        assertEquals(max, 5);
    }

    @Test
    public void testMaxStack_getMaxAllTheSame(){
        stack.add(5);
        stack.add(5);
        stack.add(5);
        stack.add(5);

        int max = stack.getMax();
        assertEquals(max, 5);
    }

    @Test
    public void testMaxStack_getMaxAllTheSameLastMax(){
        stack.add(5);
        stack.add(5);
        stack.add(5);
        stack.add(6);

        int max = stack.getMax();
        assertEquals(max, 6);
    }


}