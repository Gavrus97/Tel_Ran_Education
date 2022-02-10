public class Main {

    public static void main(String[] args) {
        ConcatenationTester tester = new ConcatenationTester();
        IConcatenator stringConcat = new StringConcatenator();
        IConcatenator charConcat = new CharArrayConcatenator();
        IConcatenator bufConcat = new StringBufferConcatenator();
        IConcatenator buildConcat = new StringBuilderConcatenator();


        System.out.println(tester.test(stringConcat, "Hello world guys", 100000));//8496
        System.out.println(tester.test(buildConcat, "Hello world guys", 100000));//4
        System.out.println(tester.test(bufConcat, "Hello world guys", 100000));//4
        System.out.println(tester.test(charConcat, "Hello world guys", 100000));//39

    }


}
