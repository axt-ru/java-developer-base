package ru.otus.java.basic.homeworks.hw3;

import java.util.Scanner;

public class MyHomework3 {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arrayFill(arr);
        arrayPrint(arr);

        // № 1
        System.out.println(sumOfPositiveElements(arr));

        // № 4
        System.out.println("Максимальный элемент массива равен " + findMax(arr));

        // № 2
        int size = 0;
        square(size);

        // № 3
        arrayWithZeroInDiagonals(arr);
        arrayPrint(arr);

        // № 4
        System.out.println("Максимальный элемент массива равен " + findMax(arr));

        // № 5
        System.out.println(sumOfSecondRow(arr));

    }

    /**
     * 1. Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
     * метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
     *
     * @param array
     */

    public static void arrayFill(int[][] array) {
        int value;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                value = (int) (Math.random() * 10) + 1;
                array[i][j] = value;
            }
        }
    }

    public static void arrayPrint(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int sumOfPositiveElements(int array[][]) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    summ += array[i][j];
                }
            }

        }
        return summ;
    }

    /**
     * 2. Реализовать метод, который принимает в качестве аргумента int size и
     * печатает в консоль квадрат из символов * со сторонами соответствующей длины;
     */

    public static void square(int size) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону квадрата");
        size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 3. Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
     * и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
     */

    public static void arrayWithZeroInDiagonals(int[][] array) {
        int x;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                x = array[i].length;  // длина i-ой строки
                if (i == j || (i + j) == (x + 1)) {
                    array[i][j] = 0;            // главная диагональ
                    array[i][x - j - 1] = 0;    // побочная диагональ
                }
            }
        }
    }

    /**
     * 4. Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
     */
    public static int findMax(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;

    }

    /**
     * 5. Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
     * если второй строки не существует, то в качестве результата необходимо вернуть -1
     */

    public static int sumOfSecondRow(int[][] array) {
        // Проверка существования второй строки
        if (array.length < 2) {
            return -1;  // Второй строки нет
        }
        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }
}


