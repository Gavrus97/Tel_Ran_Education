import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    /**
     * Writes the Strings into the file, one string as one line
     * @param strings  list of strings
     * @param fileName the name of file
     */
    public void writeToFile(List<String> strings, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (String str : strings)
                pw.println(str);
        }
    }

    /**
     * Creates a list of Strings based on the file
     *
     * @param fileName the name of file
     * @return List of Strings
     */
    public List<String> readFromFile(String fileName) throws IOException {
        List<String> str = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null)
                str.add(line);
        }
        return str;
    }

    /**
     * Write numbers into the file so that the file has one String composed of numbers written one by one
     * with delimiter " ".
     * {4,15,-9} -> "4 15 -9"
     *
     * @param numbers  the list of integers
     * @param fileName the name of file
     */
    public void writeNumbers(List<Integer> numbers, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (int n : numbers)
                pw.print(n + " ");
        }
    }

    /**
     * "4 15 -9" -> {4,15,-9}
     *
     * @param fileName the name of file
     * @return list of integers
     */
    public List<Integer> readNumbers(String fileName) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] strings = str.split(" ");
                for (String s : strings)
                    numbers.add(Integer.valueOf(s));
            }
        }
        return numbers;
    }
}


