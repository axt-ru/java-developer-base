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
        int time = distance/speedSwim;
        float remainingEndurance = (endurance/4) - distance;
        if (remainingEndurance < 0) {
            return -1;
        }
        return time;
    }


}
