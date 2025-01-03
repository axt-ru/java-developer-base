package ru.otus.java.basic.homeworks.pw7;

public interface Transport {
    boolean move(int distance, Locality locality);

    String getName(); // наименование транспорта
}
