import random_rule.IRandomRule;
import random_rule.ListRandomRule;
import random_rule.MaxRandomRule;
import random_rule.RangeRandomRule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        IRandomRule maxRandomRule = new MaxRandomRule(10);
        RandomGenerator maxGenerator = new RandomGenerator(maxRandomRule);

        System.out.println(maxGenerator.generate(20));

        IRandomRule rangeRule = new RangeRandomRule(10, 20);
        RandomGenerator rangeGenerator = new RandomGenerator(rangeRule);
        System.out.println(rangeGenerator.generate(20));

        List<Integer> number = new ArrayList<>();
        number.add(10);
        number.add(15);
        number.add(98);
        number.add(23);
        number.add(16);
        number.add(-1);
        IRandomRule listRule = new ListRandomRule(number);
        RandomGenerator listGenerator = new RandomGenerator(listRule);
        System.out.println(listGenerator.generate(6));
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
        System.out.println(listRule.nextInt());
    }
}
