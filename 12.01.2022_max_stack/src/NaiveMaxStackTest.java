import org.junit.jupiter.api.BeforeEach;

class NaiveMaxStackTest extends MaxStackTest {

    @BeforeEach
    public void init() {
        stack = new NaiveMaxStack();
    }
}