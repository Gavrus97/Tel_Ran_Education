import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        //dictionary method test
//        List<String> list = new ArrayList<>();
//        list.add("human");
//        list.add("man");
//        list.add("woman");
//        list.add("sister");
//        list.add("huma");
//        list.add("woma");
//        list.add("ma");
//        list.add("actor");
//        list.add("acto");
//        System.out.println(dictionary(list));

        //autosMap method test
        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto("Volvo", "V60", 12000));
        autos.add(new Auto("Volvo", "V40", 10000));
        autos.add(new Auto("Volvo", "V30", 9000));
        autos.add(new Auto("BMW", "M5", 79000));
        autos.add(new Auto("BMW", "M3", 58000));
        autos.add(new Auto("Mercedes", "C-Klasse", 65000));
        autos.add(new Auto("Mercedes", "E-Klasse", 80000));

        Auto auto = new Auto();
        System.out.println(auto.autosMap(autos));
    }

    // Написать метод, принимающий лист слов, а возвращающий TreeMap,
    // ключами которого являются буквы, а значениями - листы слов,
    // начинающихся с данной буквы и расположенных в лексикографическом порядке
    // ({hello, world, hell} -> {h: [hell, hello], w: [world]})
    public static TreeMap<String, List<String>> dictionary(List<String> words) {
        TreeMap<String, List<String>> res = new TreeMap<>();
        Collections.sort(words);
        int nextWord = 0;


        while (nextWord < words.size()) {
            int i = nextWord;
            String firstLetter = words.get(i).substring(0, 1);
            List<String> resList = new ArrayList<>();

            for (int j = i; j < words.size(); j++) {
                if (words.get(j).startsWith(firstLetter))
                    resList.add(words.get(j));
                else {
                    nextWord = j;
                    break;
                }
            }
            if (!res.containsKey(firstLetter))
                res.put(firstLetter, resList);
            else
                break;
        }
        return res;
    }
}
