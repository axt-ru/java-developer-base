package ru.otus.java.basic.homeworks.pw71;

public interface Transport {
    boolean move(int distance, Locality locality);

    String getName();
}
