import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int[] array = {100, 28, 39, 4, 0, -1, 5, 1, 27};

        Iterator<Integer> iterator = new ForwardArrayIterator(array);

        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.print(number + " ");
        }
        System.out.println();

        Iterator<Integer> bcwIterator = new BackwardArrayIterator(array);

        while (bcwIterator.hasNext()) {
            int number = bcwIterator.next();
            System.out.print(number + " ");
        }
        System.out.println();

        Iterator<Integer> incrIterator = new IncreasingArrayIterator(array);
        while (incrIterator.hasNext()) {
            int number = incrIterator.next();
            System.out.print(number + " "); //print elements by increasing order expected
        }
    }
}
