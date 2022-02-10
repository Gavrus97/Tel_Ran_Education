import java.util.Scanner;

public class SolutionPalindrome {
    public static void main(String[] args) {
       palindrome();
    }

    public static void palindrome(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int res = 0;
        int i = 0;
        int j = str.length()-1;
        while (i != j && i < str.length() && j >= 0){
            if(str.charAt(i) != str.charAt(j)) {
                res = 1;
                break;
            }
            i++;
            j--;
        }
        if(res == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
