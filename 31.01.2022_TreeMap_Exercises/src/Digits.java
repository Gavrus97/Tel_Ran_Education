import java.util.Scanner;

public class Digits {

    private final Scanner scan;

    public Digits() {
        this.scan = new Scanner(System.in);
    }

    public int findSumOfNumbers(){
        System.out.println("введите любое число");
        int n = scan.nextInt();
        int res = 0;

        while(n != 0){
            int  a = n % 10;
            n = n / 10;
            res += a;
        }
        scan.close();
        return res;
    }
}
