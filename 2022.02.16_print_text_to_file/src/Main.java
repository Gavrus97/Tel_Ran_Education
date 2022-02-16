import javax.sound.midi.Soundbank;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        printWriterToFile();
    }

    public static void printStreamToFile() throws IOException{
       try(PrintStream ps = new PrintStream(new FileOutputStream("output.txt"))) {
           ps.println("Hello world");
           ps.println("Hello world");
           ps.println("Hello world");
           ps.println("Hello world");
           ps.println("Hello world");
       }
    }

    public static void printWriterToFile() throws IOException{
        PrintWriter pw = new PrintWriter("output.txt");

        pw.println("Hello world");
        pw.println("Hello world");
        pw.println("Hello world");
        pw.println("Hello world");
        //pw.flush();
        pw.println("Hello world");
        pw.close();
    }
}
