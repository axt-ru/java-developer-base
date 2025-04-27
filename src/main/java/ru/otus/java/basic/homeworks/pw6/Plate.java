package ru.otus.java.basic.homeworks.pw6;

public class Plate {
    private int maxFood;        // Максимальное количество еды
    private int currentQuantityFood;        // Количество еды в тарелке в текущий момент

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentQuantityFood = maxFood; // Тарелка вначале полностью заполняется едой
    }

    // Метод, позволяющий добавить еду в тарелку
    public void addFood(int amount) {
        if (currentQuantityFood + amount > maxFood) {
            currentQuantityFood = maxFood; // Когда добавляют еду и она превышает максимум, то наполняем едой до максимума
        } else {
            currentQuantityFood += amount;
        }
    }

    public boolean decreaseFood(int amount) {
        if (currentQuantityFood >= amount) {
            currentQuantityFood -= amount; // Уменьшение еды
            return true;
        } else {
            return false; // Если еды не хватает, возвращаем false
        }
    }

    public int getCurrentQuantityFood() {
        return currentQuantityFood;
    }
}
