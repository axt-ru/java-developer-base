package ru.otus.java.basic.homeworks.pw7;

public class Man {
    private String name;
    private Transport currentTransport;

    public Man(String name) {
        this.name = name;
    }

    public void getOnTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " управляет " + transport.getName());
    }

    public void getOffTransport() {
        this.currentTransport = null;
        System.out.println(name + " вышел с транспорта");
    }

    public void move(int distance, Locality locality) {
        if (currentTransport != null) {
            if (currentTransport.move(distance, locality)) {
                System.out.println(name + " проехал " + distance + " метров на " + currentTransport.getName());
            } else {
                System.out.println(currentTransport.getName() + " не может перемещаться по " + locality);
            }
        } else {
            System.out.println(name + " прошел пешком " + distance + " метров");
        }
    }

}
