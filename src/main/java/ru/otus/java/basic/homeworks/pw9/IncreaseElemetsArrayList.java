package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

public class IncreaseElemetsArrayList {

    public ArrayList<Integer> increaseElemetsArrayList(int n, ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i) + n);
        }
        return arrayList;
    }
}
