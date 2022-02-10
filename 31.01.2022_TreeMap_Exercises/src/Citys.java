import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Citys {

    public void city() {

        Map<String, String> map = new HashMap<>();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= n; i++) {
            Scanner in2 = new Scanner(in.nextLine());
            String val = in2.next();
            while (in2.hasNext())
                map.put(in2.next(), val);
        }

        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            String s = in.next();
            if(map.containsKey(s))
                System.out.println(map.get(s));
        }
    }


}
