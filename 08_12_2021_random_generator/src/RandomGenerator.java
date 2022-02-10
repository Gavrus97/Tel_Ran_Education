import random_rule.IRandomRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private final IRandomRule randomRule;

    public RandomGenerator(IRandomRule randomRule) {
        this.randomRule = randomRule;
    }

    /**
     * The method generate n random numbers according to randomRule
     * @param n numbers to be created
     * @return an array with random numbers
     */
    public List<Integer> generate(int n){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(randomRule.nextInt());
        }
        return numbers;
    }


}
