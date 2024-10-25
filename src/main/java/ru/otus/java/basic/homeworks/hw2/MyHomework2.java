package ru.otus.java.basic.homeworks.hw2;

public class MyHomework2 {

    public static void main(String[] args) {
        int num = 5;
        String txt = "word";
        numeralStringToPrint(num, txt);
        int[] array = {1, 2, 3, 4, 5, 0, 2, 5, 6, 7};
        sumArrayIfElementMoreFive(array);
        int numForArray = 10;
        int[] arrayForFill = new int[5];
        fillArrayForNumeral(arrayForFill, numForArray);
        int[] arrayForIncreaseEachElement = {0, 1, 2, 3, 4, 6};
        increaseEachElementArray(arrayForIncreaseEachElement, num);
        compareSumHalfArrayElements(array);
    }

    /**
     * (1)
     * Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку указанное количество раз
     *
     * @param num - целое число
     * @param txt - строка, печатающаяся в консоль num количество раз
     */
    public static void numeralStringToPrint(int num, String txt) {
        System.out.println("(1 task)");
        for (int i = 0; i < num; i++) {
            System.out.println(txt);
        }
        System.out.println("--------------------------");
    }


    /**
     * (2)
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
     * значение которых больше 5, и печатающий полученную сумму в консоль.
     */
    public static void sumArrayIfElementMoreFive(int[] array) {
        System.out.println("(2 task)");
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                summ += array[i];
            }
        }
        System.out.println(summ);
        System.out.println("--------------------------");
    }

    /**
     * (3)
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
     * метод должен заполниться каждую ячейку массива указанным числом.
     */
    public static void fillArrayForNumeral(int[] arrayForFill, int numForArray) {
        System.out.println("(3 task)");
        for (int i = 0; i < arrayForFill.length; i++) {
            arrayForFill[i] = numForArray;
            System.out.println(arrayForFill[i]);
        }
        System.out.println("--------------------------");
    }

    /**
     * (4)
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
     * увеличивающий каждый элемент которого на указанное число.
     */
    public static void increaseEachElementArray(int[] array, int num) {
        System.out.println("(4 task)");
        for (int i = 0; i < array.length; i++) {
            array[i] += num;
            System.out.print(array[i] + ", ");
            //System.out.print(array[i] + ',');
        }
        System.out.println();
        System.out.println("--------------------------");
    }

    /**
     * (5)
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
     * и печатающий в консоль сумма элементов какой из половин массива больше.
     */

    public static void compareSumHalfArrayElements(int[] array) {
        System.out.println("(5 task)");
        int sumOneHalf = 0;
        int sumSecondHalf = 0;
        for (int i = 0; i < (array.length / 2); i++) {
            sumOneHalf += array[i];
        }
        for (int i = (array.length / 2); i < array.length; i++) {
            sumSecondHalf += array[i];
        }
        if (sumOneHalf > sumSecondHalf) {
            System.out.println(sumOneHalf);
        } else {
            System.out.println(sumSecondHalf);
        }
    }

}
