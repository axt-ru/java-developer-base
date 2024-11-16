package ru.otus.java.basic.homeworks.pw5.animals;

public class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int endurance;

    public String getName() {
        return name;
    }

    public float run(int distance) {
        float rateEndurance = 1;                // расход выносливости
        int time = distance/speedRun;
        float remainingEndurance = distance/rateEndurance - distance;
        if (remainingEndurance < 0) {
            System.out.println(name + " устал и не может пробежать данную дистанцию");
            return -1;
        }
        System.out.println(name + "побежал дистанцию в " + distance + " за " + time + "сек.");
        return time;
    }

    public float swim(int distance) {
        System.out.println(name + "поплыл");
        float time = distance/speedSwim;
        return time;
    }

    public void info() {
        System.out.println("Имя - " + name + ", скорость бега (м/с) - " + speedRun + ", скорость плавания" + speedSwim +
                ", выносливость - " + endurance + " ед.");
    }

}
