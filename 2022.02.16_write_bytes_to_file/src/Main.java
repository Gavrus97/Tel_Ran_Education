import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String hello = "Hello world!";
        byte[] bytes = hello.getBytes();
//
//        FileOutputStream fos = new FileOutputStream("output.txt", true);
//        fos.write(bytes);
//        fos.close();

        writeBytes(bytes, "output.txt");
    }

    public static void writeBytes(byte[] bytes, String fileName) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(fileName)){
            fos.write(bytes);
        }

        //тоже самое что снизу

//        FileOutputStream fos = new FileOutputStream(fileName);
//        try{
//            fos.write(bytes);
//        }
//        finally {
//            fos.close();
//        }
    }
}
