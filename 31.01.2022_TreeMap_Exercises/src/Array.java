import java.util.Scanner;

public class Array {

    private final Scanner scan;

    public Array() {
        this.scan = new Scanner(System.in);
    }

    public void findMax(){
        System.out.println("введите количество чисел");
        int n = scan.nextInt();
        int[] array = new int[n];
        int max = array[1];
        int count = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
            sum += array[i];
            if(array[i] > max)
                max = array[i];
            if(array[i] == max)
                count++;
        }
        System.out.println(sum);
        System.out.println(max);
        System.out.println(count);
    }


}
