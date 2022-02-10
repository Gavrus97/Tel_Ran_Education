import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testSolve() {
        List<Integer> numbers = Arrays.asList(3, 10, 5, 3, 10, 15, 18, 10, 3, 3);
        assertEquals(3, solution.solve(numbers));
    }


}