package ru.otus.java.basic.homeworks.pw71;

public class Bicycle implements Transport {

    public String getName() {
        String name = "Велосипед";
        return name;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (locality == Locality.SWAMP) {
            return false; // Велосипед не может проехать по болоту
        }
        return true;
    }

}
