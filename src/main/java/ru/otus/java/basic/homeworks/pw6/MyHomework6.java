package ru.otus.java.basic.homeworks.pw6;

public class MyHomework6 {
    public static void main(String[] args) {

        Plate plate = new Plate(100);  // Тарелка с едой

        // Массив котов
        Cat[] cats = {
                new Cat("Матроскин", 20),
                new Cat("Пушок", 25),
                new Cat("Мурзик", 30),
                new Cat("Леопольд", 40)
        };

        // Коты пытается покушать из тарелки
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        // Данные, о том, что коты сыты
        for (Cat cat : cats) {
            String filledWithFood = cat.isFilled() ? "сыт" : "голоден";
            System.out.println(cat.getName() + " " + filledWithFood);
        }
    }
}
