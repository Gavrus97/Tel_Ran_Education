public class StringConcatenator implements IConcatenator{

    @Override
    public String concatenate(String[] strings) {
        String str1 = "";
        for (int i = 0; i < strings.length; i++) {
            str1 += strings[i];
        }
        return str1;
    }
}
