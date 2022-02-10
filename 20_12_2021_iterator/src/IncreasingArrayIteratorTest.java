import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingArrayIteratorTest {

    @Test
    public void testIterator_oneElement(){
        int [] array = {5};

        int [] res = iterateToArray(array);
        assertArrayEquals(new int []{5}, res);
    }

    public int[] iterateToArray(int[]array){
        int [] res = new int[array.length];

        Iterator<Integer> iterator = new IncreasingArrayIterator(array);
        int i = 0;
        while(iterator.hasNext()){
            res[i++] = iterator.next();
        }
        return res;
    }

}