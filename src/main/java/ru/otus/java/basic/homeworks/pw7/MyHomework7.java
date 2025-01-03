package ru.otus.java.basic.homeworks.pw7;

public class MyHomework7 {

    public static void main(String[] args) {
        Man man = new Man("Иван");

        Transport car = new Car(20);
        man.getOnTransport(car);
        man.move(100, Locality.PLAIN); // Перемещение по равнине

        man.getOffTransport();
        man.move(50, Locality.PLAIN); // Пешим

        man.getOnTransport(new Horse(30));
        man.move(50, Locality.SWAMP); // Пробуем на лошади по болоту

        man.getOnTransport(new Bicycle());
        man.move(50, Locality.DENSE_FOREST); // Пробуем на велосипеде по лесу

        man.getOnTransport(new Rover());
        man.move(200, Locality.SWAMP); // По болоту на вездеходе
    }


}
