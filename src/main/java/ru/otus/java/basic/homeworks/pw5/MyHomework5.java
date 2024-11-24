package ru.otus.java.basic.homeworks.pw5;

import ru.otus.java.basic.homeworks.pw5.animals.Cat;
import ru.otus.java.basic.homeworks.pw5.animals.Dog;
import ru.otus.java.basic.homeworks.pw5.animals.Horse;

public class MyHomework5 {

    public static void main(String[] args) {
        Cat cat = new Cat("Мурзик", 10, 0, 10);
        Dog dog = new Dog("Полкан", 15, 5, 80);
        Horse horse = new Horse("Юлий", 35, 10, 160);

        cat.info();
        dog.info();
        horse.info();

        int distance = 40;

        cat.run(distance);
        dog.run(distance);
        horse.run(distance);

        cat.swim(distance);
        dog.swim(distance);
        if (dog.swim(distance) == -1) {
            System.out.println(dog.getName() + " устал и не может проплыть данную дистанцию");
        } else {
            System.out.println(dog.getName() + " проплыл расстояние " + distance + " метров за "
                    + dog.swim(distance) + " секунд");
        }

        horse.swim(distance);
        if (horse.swim(distance) == -1) {
            System.out.println(horse.getName() + " устал и не может проплыть данную дистанцию");
        } else {
            System.out.println(horse.getName() + " проплыл расстояние " + distance + " метров за "
                    + horse.swim(distance) + " секунд");
        }

    }
}
