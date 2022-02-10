import java.util.Arrays;

public class ConcatenationTester {

    /**
     * The method tests the performance of concatenation using "concatenator", adding the "string" "number"  times to itself
     * @param concatenator the way(implementation) to test performance with
     * @param string to concatenate
     * @param number times to concatenate
     * @return the time taken for the concatenation with "concatenator"
     */
    public long test(IConcatenator concatenator, String string, int number){
        String[] strings = composeStrings(string, number);

        long currentTime1 = System.currentTimeMillis();//время начала метода

        concatenator.concatenate(strings);

        long currentTime2 = System.currentTimeMillis();// время окончания метода

        return currentTime2-currentTime1;
    }


    private String[] composeStrings(String string, int number){
        String[] str = new String[number];

        Arrays.fill(str, string);
//        for (int i = 0; i < str.length; i++) {
//            str[i] = string;
//        }

        return str;
    }
}
