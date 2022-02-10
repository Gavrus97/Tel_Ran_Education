import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WithoutPairTest {

    WithoutPair example = new WithoutPair();

    @Test
    public void test_noPair(){
        List<Integer> list = Arrays.asList(1,2,3,1,4,3,2,4,1);
        assertEquals(1,example.intWithoutPair(list));
    }
}