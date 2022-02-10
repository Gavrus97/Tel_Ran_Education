import java.util.Scanner;

public class Main {



    public static void findMaxAndMin(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = 0;
        int min = 9;

        if(n == 0) {
            System.out.println((min = 0) + " " + max);
            return;
        }

        while (n != 0) {
            if(n % 10 > max)
                max = n % 10;
            if(n % 10 < min)
                min = n % 10;
            n = n / 10;
        }
        scan.close();
        System.out.println(min + " " + max);
    }
}
