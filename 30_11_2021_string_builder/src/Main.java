public class Main {

    public static void main(String[] args) {

        String helloWorld = "hello world";

        String res = "";

        for (int i = 0; i < 10000; i++) {
            res += helloWorld;
            //res = res.concat(helloWorld);
        }
        //  1) на каждой итерации происзодит создание новой строки у которой внутри находится массив.
        // 2) происзодит поэлементное копирование символов старого res в новый массив и еще 11 символов
        //тогда простейших оппераций в данном алгоритме будет 0 + 11 + 22 + 33 + ... +110000 = 10001 * 110000 / 2 = 55000 * 10001

        StringBuilder sb = new StringBuilder();//string builder
        for (int i = 0; i < 100000; i++) {
            sb.append(helloWorld);
        }

        res = sb.toString();

        StringBuffer sbuf = new StringBuffer(); //string buffer
        for (int i = 0; i < 100000; i++) {
            sbuf.append(helloWorld);
        }

        res = sbuf.toString();
    }
}
