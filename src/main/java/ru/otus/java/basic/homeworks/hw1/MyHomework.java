package ru.otus.java.basic.homeworks.hw1;

public class MyHomework {

    public static void main(String[] args) {
        greetings();
        checkSign(10, -20, 30);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(1, 2, true);

    }

    /**
     * (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
     */
    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    /**
     * (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
     * Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
     * в противном случае - “Сумма отрицательная”;
     *
     * @param a
     * @param b
     * @param c
     */
    public static void checkSign(int a, int b, int c) {
        int s = a + b + c;
        if (s > 0) {
            System.out.println("Сумма положительна и равна " + s);
        } else {
            System.out.println("Сумма отрицательна и равна " + s);
        }
    }

    /**
     * (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
     * Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно,
     * то “Желтый”, если больше 20 - “Зеленый”;
     */
    private static void selectColor() {
        int data = 38;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    /**
     * (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
     * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
     */
    private static void compareNumbers() {
        int a;
        int b;
        a = 1;
        b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
     * (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment).
     * Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
     * @param initValue
     * @param delta
     * @param increment
     */
    private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int temp;
        if (increment == true) {
            temp = initValue + delta;
            System.out.println(temp);
        } else {
            temp = initValue - delta;
            System.out.println(temp);
        }
    }

}
