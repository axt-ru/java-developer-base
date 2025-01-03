package ru.otus.java.basic.homeworks.pw7;

public class Horse implements Transport {
    private int stamina;

    public String getName() {
        String name = "Лошадь";
        return name;
    }

    public Horse(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (locality == Locality.SWAMP) {
            return false; // Лошадь не может ходить по болоту
        }
        stamina -= distance / 5; // Расход сил
        if (stamina < 0) {
            System.out.println("Нехватает сил для перемещения");
            return false;
        }
        return true;
    }

}
