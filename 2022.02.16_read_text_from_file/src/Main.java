import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
