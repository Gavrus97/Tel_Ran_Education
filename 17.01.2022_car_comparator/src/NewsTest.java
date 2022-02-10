import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @Test
    public void testCompareTo(){
        News news1 = new News("Hello world", 7);
        News news2 = new News("Hello", 7);
        News news3 = new News("Hello", 8);
        News news4 = new News("Hello", 8);
        News news5 = new News("Hello World ", 10);
        News news6 = new News("Hell", 10);

        assertTrue(news1.compareTo(news2) > 0);
        assertTrue(news2.compareTo(news1) < 0);
        assertTrue(news3.compareTo(news1) < 0);
        assertTrue(news3.compareTo(news2) < 0);
        assertEquals(0, news4.compareTo(news3));
        assertTrue(news4.compareTo(news5) > 0);
        assertTrue(news5.compareTo(news3) < 0);
        assertTrue(news6.compareTo(news5) < 0);

    }

}