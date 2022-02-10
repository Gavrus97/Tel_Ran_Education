package random_rule;

import random_rule.IRandomRule;

import java.util.Random;

public class MaxRandomRule implements IRandomRule {

    private final int max;
    private final Random rnd = new Random();

    public MaxRandomRule (int max){
        this.max = max;
    }

    public int nextInt(){
        return rnd.nextInt(max);
    }

}
