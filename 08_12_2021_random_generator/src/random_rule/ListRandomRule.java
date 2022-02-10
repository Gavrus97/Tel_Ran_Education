package random_rule;

import random_rule.IRandomRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements IRandomRule {

    private final List<Integer> numbers;
    private final Random rnd = new Random();

    public ListRandomRule(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    //{10,15,90,-8} -> one of this numbers
    @Override
    public int nextInt() {
        return numbers.get(rnd.nextInt(numbers.size()));
    }

}
