package ru.otus.java.basic.homeworks.pw7;

public class Car implements Transport {
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        String name = "Машина";
        return name;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (fuel <= 0) {
            System.out.println("Недостаточно бензина для перемещения.");
            return false;
        }
        if (locality == Locality.DENSE_FOREST || locality == Locality.SWAMP) {
            return false; // Машина не проедет по густому лесу и болоту
        }
        fuel -= distance / 5; // Расход топлива
        return true;
    }

}
