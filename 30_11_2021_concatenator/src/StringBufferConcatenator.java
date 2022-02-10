public class StringBufferConcatenator implements IConcatenator{

    @Override
    public String concatenate(String[] strings) {
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sbuf.append(strings[i]);
        }
        return sbuf.toString();
    }
}
