import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapTest {

    CustomHashMap<String, Integer> map = new CustomHashMap<>();

    @Test
    public void testPut_Size_Get(){
        map.put("Vasja", 10);
        map.put("Petja", 7);
        map.put("Kolja", 13);
        map.put("Anja", 4);

        assertEquals(10, map.get("Vasja"));
        assertEquals(7, map.get("Petja"));
        assertEquals(13, map.get("Kolja"));
        assertEquals(4, map.get("Anja"));

        assertEquals(4,map.size());
    }

    @Test
    public void test_Contains(){
        map.put("Vasja", 10);
        map.put("Petja", 7);
        map.put("Kolja", 13);
        map.put("Anja", 4);

        assertTrue(map.contains("Vasja"));
        assertTrue(map.contains("Petja"));
        assertTrue(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));
        assertFalse(map.contains("Tolik"));

        Iterator<String> iterator = map.keyIterator();
        int i = 0;
        while(iterator.hasNext()){
            iterator.next();
            i++;
        }
        assertEquals(4,i );
    }

    @Test
    public void test_RemoveMy(){
        map.put("Vasja", 10);
        map.put("Petja", 7);
        map.put("Kolja", 13);
        map.put("Anja", 4);

        assertEquals(13, map.removeMy("Kolja"));
        assertEquals(3, map.size());
        assertTrue(map.contains("Vasja"));
        assertTrue(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(10, map.removeMy("Vasja"));
        assertEquals(2, map.size());
        assertFalse(map.contains("Vasja"));
        assertTrue(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(7, map.removeMy("Petja"));
        assertEquals(1, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertNull(map.removeMy("Petja"));
        assertEquals(1, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(4, map.removeMy("Anja"));
        assertEquals(0, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertFalse(map.contains("Anja"));
    }

    @Test
    public void test_Remove(){
        map.put("Vasja", 10);
        map.put("Petja", 7);
        map.put("Kolja", 13);
        map.put("Anja", 4);

        assertEquals(13, map.remove("Kolja"));
        assertEquals(3, map.size());
        assertTrue(map.contains("Vasja"));
        assertTrue(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(10, map.remove("Vasja"));
        assertEquals(2, map.size());
        assertFalse(map.contains("Vasja"));
        assertTrue(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(7, map.remove("Petja"));
        assertEquals(1, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertNull(map.remove("Petja"));
        assertEquals(1, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertTrue(map.contains("Anja"));

        assertEquals(4, map.remove("Anja"));
        assertEquals(0, map.size());
        assertFalse(map.contains("Vasja"));
        assertFalse(map.contains("Petja"));
        assertFalse(map.contains("Kolja"));
        assertFalse(map.contains("Anja"));
    }

}