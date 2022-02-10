import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("Moscow", "Russia");
//        map.put("Petersburg", "Russia");
//        map.put("Novgorod", "Russia");
//        map.put("Kaluga", "Russia");
//        map.put("Kiev", "Ukraine");
//        map.put("Odessa", "Ukraine");
//
//        if(map.containsKey("Moscow"))
//            System.out.println(map.get("Moscow"));
//        else
//            System.out.println("Key doesn't exist");
//
//        if(map.containsKey("Petersburg"))
//            System.out.println(map.get("Petersburg"));
//        else
//            System.out.println("Key doesn't exist");
//
//        if(map.containsKey("Novgorod"))
//            System.out.println(map.get("Novgorod"));
//        else
//            System.out.println("Key doesn't exist");
//
//        if(map.containsKey("Odessa"))
//            System.out.println(map.get("Odessa"));
//        else
//            System.out.println("Key doesn't exist");
//
//        if(map.containsKey("Kiev"))
//            System.out.println(map.get("Kiev"));
//        else
//            System.out.println("Key doesn't exist");

//        System.out.println("введите люьое число от 1  до 10: ");
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        System.out.println("Вы ввели число " + number);

//        Scanner k = new Scanner(System.in);
//        int number1 = k.nextInt();
//        int number2 = k.nextInt();
//        System.out.println(number1 + number2);

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input 2 strings");
//        String phrase1 = sc.nextLine();
//        String phrase2 = sc.nextLine();
//        System.out.println(phrase1 + " " + phrase2);

//        Map<String, String> map = new HashMap<>();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        in.nextLine();
//
//        for (int i = 1; i <= n ; i++) {
//            Scanner in2 = new Scanner(in.nextLine());
//            String val = in2.next();
//            while (in2.hasNext()){
//                map.put(in2.next(), val);
//            }
//        }
//
//        n = in.nextInt();
//        for(int i = 1; i <= n; i++) {
//            String s = in.next();
//            if (map.containsKey(s)) {
//                System.out.println(map.get(s));
//            }
//        }

        Map<String, String> map = new HashMap<>();
        Scanner scan1 = new Scanner(System.in);
        int n = scan1.nextInt();

        scan1.nextLine();

        for (int i = 1; i <= n ; i++) {
            Scanner scan2 = new Scanner(scan1.nextLine());
            String value = scan2.next();
            while(scan2.hasNext())
                map.put(scan2.next(),value);
            //scan2.close();
        }


            String s = scan1.next();
            if(map.containsKey(s))
                System.out.println(map.get(s));

            scan1.close();
    }


//        Scanner scan = new Scanner(System.in);
//        double a;
//        double b;
//        double c;
//
//        System.out.println("введи первое число");
//        a = scan.nextDouble();
//        System.out.println("введи второе число");
//        b = scan.nextDouble();
//        System.out.println("введи второе число");
//        c = scan.nextDouble();
//        double average = (a + b + c) / 3;
//        System.out.println("Average = " + average);
//        System.out.println("delta first " + (a - average));
//        System.out.println("delta second " + (b - average));
//        System.out.println("delta third " + (c - average));
//    }

//        Digits dig = new Digits();
//        System.out.println(dig.findSumOfNumbers());
//    }
}
