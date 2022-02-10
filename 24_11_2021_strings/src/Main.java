import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String string = "Hello world";
        String string2 = "Hello world";

        String string3 = new String("Hello world");
        //constructor from char array
        String stringFromChars = new String(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'});

        System.out.println(string == string2);//true
        System.out.println((string == string3));//false
        System.out.println((string3 == stringFromChars));//false
        System.out.println((string == stringFromChars));//false

        System.out.println(string.equals(string2));//true
        System.out.println((string.equals(string3)));//true
        System.out.println((string3.equals(stringFromChars)));//true
        System.out.println((string.equals(stringFromChars)));//true


        //char
        char a = 'a';
        System.out.println(a);//'a'
        System.out.println(a + 0);//97 в таком случае берется целочисленное значение char символа
        System.out.println(string + a);//Hello worlda
        System.out.println(string + (a + 0));//Hello worlda0


        // charAt() -> char
        System.out.println(string.charAt(2));//'l'

        //concatenation
        System.out.println(string.concat(string2));// Hello worldHello world (string + string2)
//      string = string + string2;// ссылка string теперь будет указывать на новый объект состоязий из двух старых

        //contains() -> boolean
        System.out.println(string.contains("l"));//true
        System.out.println(string.contains("llo"));//true
        System.out.println(string.contains("llom"));//false

        // startWith(), endsWith() -> boolean
        System.out.println(string.startsWith("Hell"));//true

        // equalsIgnoreCase() -> boolean (сравнивает строки на идентичность не обращая внимание на регистр(большая или маленькая))
        String hello1 = "HeLlO";
        String hello2 = "hello";
        System.out.println(hello1.equalsIgnoreCase(hello2));//true

        // indexOf() -> int - returns the first index of the pattern in the string
        System.out.println(string.indexOf("l"));//2 возвразает первый индекс на котором находться жтот элемент
        System.out.println(string.indexOf("l", 4));//9 ищет начиная с 4 индекса

        // lastIndexOf() -> int - return the last index of the pattern
        System.out.println(string.lastIndexOf("l"));//9
        System.out.println(string.lastIndexOf("l", 8));//3 справа на лево от 8 индекса

        // length() -> int длинна строки
        System.out.println(string.length());//11

        // split() -> String[]
        String[] fromString = string.split("l"); //разбиваем массив по букве l
        System.out.println(Arrays.toString(fromString));//[He, , o wor, d]
        System.out.println(Arrays.toString(string.split(" ")));

        // toCharArray() -> char[]
        char[] chars = string.toCharArray();//{H, e, l, l, o, ' ' , w, o, r, l, d}
        System.out.println(Arrays.toString(chars));

        // toLowerCase(), toUpperCase() -> String
        String upperString = string.toUpperCase();// создает новую строку и пишет ее большими буквами
        System.out.println(string);//Hello world
        System.out.println(upperString);//HELLO WORLD

        // substring() -> String - новая строка от какого то индекса и возможно до какого то(не включительно)
        String substring1 = string.substring(2);//llo world
        String substring2 = string.substring(2,8);//llo wo (cо 2 по 7 индекс)
        System.out.println(substring1);
        System.out.println(substring2);

        //reverse
        System.out.println(reverse(string));

        //palindrome
        String line = "Paap Hello alla olleh paap";
        System.out.println(palindrome(line));
        System.out.println();

        //findNumberOfMatches
        String line2 = "Halololo Halolo";
        System.out.println(findNumberOfMatches(line2,"lo"));

        //countPattern()
        System.out.println(countPattern("aaabcbcbcddd", "bc"));
        System.out.println(countPattern("aaabcbcbcddd", "bcbc"));

        //cutString
        System.out.println(cutString("hello world guys", 0)); //""

        System.out.println(cutString("hello world guys", 5)); //"hello"
        System.out.println(cutString("hello world guys", 4)); //""
        System.out.println(cutString("hello world guys", 6)); //"hello"
        System.out.println(cutString("hello world guys", 7)); //"hello"
        System.out.println(cutString("hello world guys", 10)); //"hello"

        System.out.println(cutString("hello world guys", 11)); //"hello world"
        System.out.println(cutString("hello world guys", 12)); //"hello world"
        System.out.println(cutString("hello world guys", 13)); //"hello world"

        System.out.println(cutString("hello world guys", 16)); //"hello world guys"
        System.out.println(cutString("hello world guys", 17)); //"hello world guys"
    }

//    Развернуть строку
    static String reverse(String str){
        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(chars.length -1 - i);
        }
        return new String(chars);
    }

    //very slow variant
    static String reverse2(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(str.length() - 1 - i);
        }
        return res;
    }

//    1. Написать метод, который принимает строку, а возвразает boolean - является ли строка палиндромом
//    (игнорируя регистр). Пример: Алла. "А роза упала на лапу Азора" - не палиндром в рамках указанной
//    задачи. Пробелы не игнорируются. (Использовать метод с урока по развороту строки)
    static boolean palindrome(String str){
        String str2 = reverse(str);
        return str.equalsIgnoreCase(str2);
    }

//    3. Написать метод, который принимает строку и паттерн, и возвращает количество
//    вхождений паттерна в строку. Пример: ("Hello world", "l") -> 3
    static int findNumberOfMatches(String str, String pattern){
        int numberOfMatches;

        numberOfMatches = (str.length() - str.replaceAll(pattern,"").length()) / pattern.length();

        return numberOfMatches;
    }
//    3.Написать метод, который принимает строку и паттерн, и возвращает количество
//   вхождений паттерна в строку. Пример: ("Hello world", "l") -> 3
    static int countPattern(String str, String pattern){
        int count = 0;
        int index = str.indexOf(pattern);


        while(index > -1) {
            count++;
            index++;
            index = str.indexOf(pattern, index);
        }
       return count;
    }

//    2. (*) Дана строка, состоящая только из слов и пробелов, и число N.
//    Вернуть новую строку максимальной длины, состоящую из начала исходной строки,
//    содержащую ТОЛЬКО слова целиком, при этом длины не больше чем N.
//    Пример: (Hello world guys, 8 ) -> Hello. (Hello world guys, 12 ) -> Hello world.
//    (Hello world guys, 16+ ) -> Hello world guys.
    static String cutString(String str, int n){
        if(n >= str.length())
            return str;

        String cut = str.substring(0,n+1);

        int lastSpaceIndex = cut.lastIndexOf(" ");
        if (lastSpaceIndex < 0)
            return "";

        return cut.substring(0, lastSpaceIndex);
    }
}
