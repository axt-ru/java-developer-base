package ru.otus.java.basic.homeworks.pw6;

public class Cat {
    private String name;
    private int appetite; // Аппетит
    private boolean isFilled; // Сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFilled = false; // В начале кот голодный
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            isFilled = true; // Если коту удалось покушать (хватило еды), сытость = true
        }
    }

    public boolean isFilled() {
        return isFilled;
    }

    public String getName() {
        return name;
    }
}
