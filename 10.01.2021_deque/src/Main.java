import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        CustomDeque<Integer> deq = new CustomArrayDeque<>();

        deq.addLast(5);
        deq.addLast(6);
        deq.addLast(7);
        deq.addLast(8);
        deq.addLast(9);
        deq.addLast(10);
        deq.addFirst(1);
        deq.addFirst(0);
        deq.removeLast();
        deq.removeFirst();


        Iterator<Integer> iter = deq.iterator();

        while(iter.hasNext()){
            int curNumber = iter.next();
            System.out.println(curNumber);
        }


    }

}
