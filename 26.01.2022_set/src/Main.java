import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        java.util.Set numbers = new HashSet<>();
//        java.util.Set numbers2 = new HashSet<>();
//        //{1, 7, -5, 10} numbers
//        //{8, 10, ,7, 15, 17} numbers2
//
//        numbers.addAll(numbers2); //объединение (в numbers будут ледать эл-ты из обоих множеств)
//        //{1, 7, -5, 10, 8, 15, 17}
//        numbers.removeAll(numbers2);// в numbers будут лежать только те эл-ты которые есть в numbers и которых
//        // нет в numbers2 {1, -5}
//        numbers.retainAll(numbers2); //оставит только те эл-ты которые назодятся в обоих множествах {7, 10}

        //CustomHashSet
//        CustomSet<Integer> source = new CustomHashSet<>();
//        System.out.println(source.add(5));
//        System.out.println(source.add(2));
//        System.out.println(source.add(1));
//        System.out.println(source.add(7));
//        Set<Integer> set = new HashSet<>();
//        set.add(3);
//        set.add(5);
//        set.add(1);
//        set.add(6);
//        source.removeAll(set);
//        System.out.println(source.size());
//        System.out.println(source.contains(5));
//        System.out.println(source.contains(2));
//        System.out.println(source.contains(1));
//        System.out.println(source.contains(7));
//        System.out.println(source.contains(3));
//        System.out.println(source.contains(6));
//
//        Iterator<Integer> iterator = source.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next() + " ");
//        }

        //CustomTreeSet
        CustomSet<Auto> tree = new CustomTreeSet<>(new Auto.CarComparator());
        System.out.println(tree.add(new Auto("volvo", 2017)));
        System.out.println(tree.add(new Auto("volvo", 2019)));
        System.out.println(tree.add(new Auto("volvo", 2018)));
        System.out.println(tree.add(new Auto("mercedes", 2013)));
        System.out.println(tree.add(new Auto("mercedes", 2017)));
        System.out.println(tree.add(new Auto("mercedes", 2015)));
        System.out.println(tree.add(new Auto("bmw", 2019)));
        System.out.println(tree.add(new Auto("bmw", 2016)));
        Set<Auto> set2 = new HashSet<>();
        set2.add(new Auto("volvo", 2017));
        set2.add(new Auto("volvo", 2020));
        set2.add(new Auto("volvo", 2013));
        set2.add(new Auto("mercedes", 2013));
        set2.add(new Auto("mercedes", 2018));
        set2.add(new Auto("mercedes", 2019));
        tree.addAll(set2);
        System.out.println(tree.size());

        Iterator<Auto> iteratorTree = tree.iterator();
        while (iteratorTree.hasNext()){
            System.out.print(iteratorTree.next() + " ");
        }
    }
}
