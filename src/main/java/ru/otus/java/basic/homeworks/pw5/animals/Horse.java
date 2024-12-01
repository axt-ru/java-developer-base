package ru.otus.java.basic.homeworks.pw5.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    @Override
    public float swim(int distance) {
        float rateEndurance = 4;                // расход выносливости - 4 у.е на 1 метр.
        int time = distance/speedSwim;
        float remainingEndurance = endurance - (rateEndurance * distance);
        if (remainingEndurance < 0) {
            return -1;
        }
        return time;
    }


}
