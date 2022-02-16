import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) throws IOException {
        FileOperations fo = new FileOperations();


        List<String> str = new ArrayList<>();
        str.add("Hello world");
        str.add("my name");
        str.add("is");
        str.add("petja pechkin");

        fo.writeToFile(str, "output.txt");
        System.out.println(fo.readFromFile("output.txt"));

        List<Integer> numbers = Arrays.asList(4, 15, -9, 239, 198, -17, 23, 4, 15);
        fo.writeNumbers(numbers, "outNumbers.txt");
        System.out.println(fo.readNumbers("outNumbers.txt"));

    }

}
