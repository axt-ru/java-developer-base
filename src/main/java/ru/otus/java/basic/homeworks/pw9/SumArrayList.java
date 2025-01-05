package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

public class SumArrayList {

    public int sumArrayList(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > 5 ) {
                sum +=arrayList.get(i);
            }
        }
        return sum;
    }
}
