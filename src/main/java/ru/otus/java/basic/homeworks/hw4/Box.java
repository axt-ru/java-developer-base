package ru.otus.java.basic.homeworks.hw4;

import java.util.Objects;
import java.util.Spliterator;

public class Box {
    private int height;
    private int length;
    private int width;
    public String color;
    private boolean openedBox;
    private String item;

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean isOpenedBox() {
        return openedBox;
    }

    public Box(int height, int length, int width, String color) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public void info() {
        System.out.println("Информация о коробке: " + color + ", " + height + "," + width + "," + width +
                ", состояние: " + openedBox + ", наполненность: " + this.item);
    }

    public void open() {
        System.out.println("коробка открыта");
        openedBox = true;
    }

    public void close() {
        System.out.println("коробка закрыта");
        openedBox = false;
    }

    public void putBox(String item) {
        if (openedBox && this.item == null) {
            this.item = item;
            System.out.println("В коробку положили " + item);
        } else {
            System.out.println("Нельзя положить предмет");
        }
    }

    public void throwAwayFromBox(String item) {
        if (openedBox) {
            if (this.item == item) {
                this.item = null;
                System.out.println("В коробке пусто");
            }
        } else {
            System.out.println("Коробка закрыта");
        }


    }


}




