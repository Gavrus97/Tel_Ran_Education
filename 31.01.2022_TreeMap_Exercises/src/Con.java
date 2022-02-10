import java.util.Scanner;

public class Con {

    private final Scanner scan;

    public Con(Scanner scan) {
        this.scan = new Scanner(System.in);
    }

    public int readNext(int number){
        System.out.println("введи число № " + number);
        return scan.nextInt();
    }

    public int searchMax(){
        System.out.println("введи n (количество эл-тов)");
        int n = scan.nextInt();

        int maxElt = readNext(1);
        int tmp;

        for (int i = 2; i <= n ; i++) {
            tmp = readNext(i);
            if(tmp > maxElt){
                maxElt = tmp;
            }
        }
        scan.close();
        return maxElt;
    }
}
