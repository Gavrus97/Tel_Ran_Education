import list.AdvancedArrayList;
import list.CustomArrayList;
import list.CustomLinkedList;
import list.CustomList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


//        CustomList<Integer> list = new CustomArrayList<>();
//
//        list.add(10);
//        list.add(15);
//        list.add(3);
//        list.add(3);
//        list.add(15);
//        list.add(10);
//        list.println();
//
//        list.removeByValue(10);
//        list.println();
//        list.removeByValue(15);
//        list.println();
//        list.removeByValue(3);
//        list.println();
//
//
////        list.removeById(0);
////        list.println();
////        list.removeById(2);
////        list.println();
//
//        CustomList<Integer> list1 = new AdvancedArrayList<>();
//        list1.add(2);
//        list1.add(4);
//        list1.add(6);
//        list1.add(1);
//        list1.add(9);
//        list1.add(15);
//        list1.add(3);
//        list1.add(4);
//        list1.println();
//        System.out.println(list1.removeByValue(4));
//        list1.println();

        //LinkedList
        CustomLinkedList<Integer> cll = new CustomLinkedList<>();
        cll.add(1);
        cll.add(2);
        cll.add(3);
        cll.add(4);
        cll.add(5);
        cll.println();
        System.out.println(cll.size());
        cll.insert(3,0);
        System.out.println(cll.size());
        cll.println();






//        System.out.println(cll.contains(2));
//        System.out.println(cll.contains(1));
//        System.out.println(cll.contains(5));
//        System.out.println(cll.contains(6));

//        CustomLinkedList<Integer> cll1 = new CustomLinkedList<>();
//        cll1.removeById(1);

//      System.out.println(cll1.contains(1));

        CustomList<Integer> list = new CustomArrayList<>();

        list.add(10);
        list.add(15);
        list.add(3);
        list.add(3);
        list.add(15);
        list.add(10);
        list.println();

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int number = iterator.next();
            System.out.println(number);
        }

        for (int number : list){
            System.out.println(number);
        }

    }


}
