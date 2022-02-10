import java.util.Scanner;

public class EvenNumber {

    private final Scanner scan;

    public EvenNumber() {
        this.scan = new Scanner(System.in);
    }

    public void evenNumbers(){
        System.out.println("количество элементов");
        int n = scan.nextInt();
        int[] array = new int[n];

        System.out.println("вводите числа");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        for (int j : array) {
            if (j % 2 == 0)
                System.out.print(j + "\t");
        }
        scan.close();
     }
}
