package ru.otus.java.basic.homeworks.pw8;

/*
    - Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
    Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
    - Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
    должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    - В методе main() необходимо вызвать полученный метод, обработать возможные исключения AppArraySizeException
    и AppArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный
    массив).
 */

public class MyApp {
    public static void main(String[] args) throws AppArraySizeException, AppArrayDataException {
        // Массив correctArr для проверки
        String[][] correctArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        // Массив incorrectArr для проверки
        String[][] incorrectArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "text", "11", "12"},
                {"13", "14", "15", "16"}
        };
        System.out.println("Массив верный");
        arrayProcess(correctArr);
        System.out.println("Массив неправильный");
        try {
            arrayProcess(incorrectArr);
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void arrayProcess(String[][] arr) throws AppArraySizeException, AppArrayDataException  {
        int sum = 0;
        if (arr.length != 4 || arr[0].length != 4) {
            throw new AppArraySizeException("Размер массива должен быть 4x4");
        }
        // Перебор элементов массива
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    // Бросаем исключение с детализацией ошибки
                    throw new AppArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: " + arr[i][j] +
                            " не является числом.");
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }
}

