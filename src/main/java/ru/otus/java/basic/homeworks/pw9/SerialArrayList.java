package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

public class SerialArrayList {

    public ArrayList<Integer> serialArrayList(int min, int max) {
        ArrayList<Integer> integerList = new ArrayList<>();
        while (min <= max) {
            integerList.add(min);
            min++;
        }
        return integerList;
    }

}
