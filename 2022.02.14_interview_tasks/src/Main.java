public class Main {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 3, 1, 2, 5};
        System.out.println(prefix(numbers, 2, 3));

    }
    //Есть массив целых чисел. Петя и Вася задумывают по своему любимому числу.
    //Найти наибольшую длину префикса этого массива, такого, что он (префикс массива)
    // содержит поровну любимого числа Васи и Пети.
    // (7, 42, {6, 42, 11, 7, 1, 42})) -> 5
    // (7, 42, new int[]{7, 42, 11, 7, 1, 42})) -> 6

    public static int prefix(int[] numbers, int vasjaNumber, int petjaNumber) {
        int res = 0;
        int countVasja = 0;
        int countPetja = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == vasjaNumber) {
                countVasja++;
            }
            if (numbers[i] == petjaNumber) {
                countPetja++;
            }
            if (countPetja == countVasja)
                res = i + 1;
        }
        return res;
    }

    //Вася бросает кубик определенное число раз. Известны результаты
    // некоторых его бросков (записаны в массив). F - число бросков,
    // результаты которых неизвестны. Оказалось, что среднее арифметическое
    // всех бросков равно M. Задача - вывести массив длины F
    // с возможными результатами неизвестных бросков.
    //({3, 2, 4, 2}, 4, 2) -> {1, 1, 1, 2}
    //({3, 2, 4, 3}, 2, 4)
    //({1, 5, 6}, 4, 3)

    public int[] cube (int[] existingNumbers, int f, int avg){

        int existingSum = 0;
        for(int i : existingNumbers){
            existingSum += i;
        }
        int nonExistingSum = (existingNumbers.length + f) * avg - existingSum;

        int[] res = new int[f];

        for (int i = 0; i < res.length; i++) {
            res[i] = nonExistingSum / f;
            if (i == res.length - 1)
                res[i] = nonExistingSum / f + nonExistingSum % f;
        }
        return res;
    }
}
