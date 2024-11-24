package ru.otus.java.basic.homeworks.hw4;

import java.time.Year;

public class MyHomework4 {

    public static void main(String[] args) {

        User user = new User("Иванов", "Иван", "Иванович",
                2000, "ivan@mail.ru");

        /*
        4. В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и с помощью
        цикла выведите информацию только о пользователях старше 40 лет.
         */

        User[] arrayUsers = {
                new User("Иванов", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Петров", "Иван", "Иванович", 1960, "ivan@mail.ru"),
                new User("Сидоров", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Жеглов", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Шарапов", "Иван", "Иванович", 1983, "ivan@mail.ru"),
                new User("Леонов", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Никулин", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Вицин", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Моргунов", "Иван", "Иванович", 2000, "ivan@mail.ru"),
                new User("Яковлев", "Иван", "Иванович", 1970, "ivan@mail.ru")
        };

        int currentYear = Year.now().getValue();
        System.out.println("Информация о пользователях старше 40 лет: ");
        for (int i = 0; i < arrayUsers.length; i++) {
            if (arrayUsers[i].getYearBirth() < (currentYear - 40)) {
               user.info(arrayUsers[i].getSurname(), arrayUsers[i].getName(), arrayUsers[i].getPatronymicSurname(),
                       arrayUsers[i].getYearBirth(), arrayUsers[i].getEmail());
            }
            ;
        }

        /**
         * 5. Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
         * Коробку можно открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после создания нельзя.
         * У коробки должен быть метод, печатающий информацию о ней в консоль.
         * В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда
         * (только если предмет в ней есть), только при условии, что коробка открыта (предметом читаем просто строку).
         * Выполнение методов должно сопровождаться выводом сообщений в консоль.
         */

        Box box = new Box(10, 10, 10, "red");

        box.info();   // первоначальная информация

        box.open();   // кладем предмет в коробку
        box.putBox("ручка");
        box.close();
        box.info();

        box.putBox("ручка");  // пробуем положить в закрытую коробку

        box.throwAwayFromBox("ручка");   // пробуем выкинуть из закрытой коробки
        box.info();

        box.open();
        box.throwAwayFromBox("ручка");  // удаляем из коробки предмет
        box.close();
        box.info();


    }

}
