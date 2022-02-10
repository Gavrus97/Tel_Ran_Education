import java.util.Arrays;

public class CharArrayConcatenator implements IConcatenator{

    @Override
    public String concatenate(String[] strings) {
            int totalLength = 0;
            for (int i = 0; i < strings.length; i++) {
                totalLength +=strings[i].length();
            }

            char[] charArray = new char[totalLength];

            int n = 0;
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length(); j++) {
                    charArray[n] = strings[i].charAt(j);
                    n++;
                }

            }
            return String.valueOf(charArray); //return new String(charArray);
        }

}
