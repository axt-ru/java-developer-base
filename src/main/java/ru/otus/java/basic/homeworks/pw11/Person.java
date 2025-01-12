package ru.otus.java.basic.homeworks.pw11;


public class Person {
    String name;
    Position position;
    Long id;

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }
}


