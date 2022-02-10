import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * The method must return an element from the list which appears at most (or any of such element)
     * only one element satisfies this requirement.
     *
     * @param numbers a list of numbers
     * @return the most occurred element in the list
     * {1,5,-10,1} -> 1
     */
    public int solve(List<Integer> numbers) {

        //переменная хранит числа из листа в качесте ключей и кол-во раз сколько каждое число встречается в листе как значение
        Map<Integer, Integer> qutByNumber = new HashMap<>();

        for (int number : numbers) {
            if (qutByNumber.containsKey(number)) {
                int oldValue = qutByNumber.get(number);
                qutByNumber.put(number, oldValue + 1);
            } else {
                qutByNumber.put(number, 1);
            }
        }

        Iterator<Integer> keyIterator = qutByNumber.keySet().iterator();
        int res = keyIterator.next();
        int maxOccurrence = qutByNumber.get(res);

        while (keyIterator.hasNext()) {
            int currentNumber = keyIterator.next();
            if (maxOccurrence < qutByNumber.get(currentNumber)) {
                maxOccurrence = qutByNumber.get(currentNumber);
                res = currentNumber;
            }
        }
        return res;
    }
}
