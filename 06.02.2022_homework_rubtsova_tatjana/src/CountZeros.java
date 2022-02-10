import java.util.Scanner;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println((zeros()));
    }

    public static int zeros(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int count = 0;

        while (n != 0) {
            if(n % 10 == 0)
                count +=1;
            n = n / 10;
        }
        return count;
    }
}
