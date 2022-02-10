import java.util.*;

public class WithoutPair {

    public int intWithoutPair(List<Integer> numbers){
        Map<Integer, Integer> map = new HashMap<>();

        for(int element : numbers){
            if(map.containsKey(element)){
                int value = map.get(element);
                map.put(element, value + 1);
            }
            else
            map.put(element, 1);
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()){
            int elt = iterator.next();
            if(map.get(elt) % 2 != 0)
                return elt;
        }
        throw new NoSuchElementException();
    }
}
