package ru.otus.java.basic.homeworks.pw5.animals;

import javax.lang.model.element.Name;

public class Cat extends Animal {
    public Cat(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    @Override
    public float swim(int distance) {
        System.out.println(name + " не умеет плавать");
        return -1;
    }

    @Override
    public void info() {
        System.out.println("Имя - " + name + ", скорость бега (м/с) - " + speedRun + ", плавать не умеет, " +
                "выносливость при беге - " + endurance + " ед.");
    }
}
