package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

public class ChangeElementArrayList {
    public ArrayList<Integer> changeElementArrayList(int n, ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
                 arrayList.set(i, n);
        }
        return arrayList;
    }
}