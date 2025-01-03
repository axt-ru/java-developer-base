package ru.otus.java.basic.homeworks.pw7;

public class Rover implements Transport {

    public String getName() {
        String name = "Вездеход";
        return name;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        return true; // Вездеход везде проедет
    }


}
