import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void test_prefix9() {
        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 3, 1, 2, 5};
        assertEquals(9, main.prefix(numbers, 2, 3));
    }

    @Test
    public void test_prefix11() {
        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 3, 1, 2, 5};
        assertEquals(11, main.prefix(numbers, 1, 2));
    }

    @Test
    public void test_prefix0() {
        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 3, 1, 2, 5};
        assertEquals(11, main.prefix(numbers, 6, 0));
    }

    @Test
    public void test_prefix10() {
        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 3, 2, 5};
        assertEquals(10, main.prefix(numbers, 5, 1));
    }

    @Test
    public void test_cube1() {
        int[] exist = {3, 2, 4, 2};
        assertArrayEquals(new int[]{1, 1, 1, 2}, main.cube(exist, 4, 2));
    }

    @Test
    public void test_cube2() {
        int[] exist = {3, 2, 4, 3};
        assertArrayEquals(new int[]{6, 6}, main.cube(exist, 2, 4));
    }

    @Test
    public void test_cube3() {
        int[] exist = {1, 5, 6};
        assertArrayEquals(new int[]{2, 2, 2, 3}, main.cube(exist, 4, 3));
    }

}