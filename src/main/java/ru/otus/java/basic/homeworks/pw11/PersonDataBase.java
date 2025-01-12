package ru.otus.java.basic.homeworks.pw11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap;

    public PersonDataBase() {
        personMap = new HashMap<>();
    }

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        Position position = person.getPosition();
        return position == Position.MANAGER || position == Position.DIRECTOR ||
                position == Position.BRANCH_DIRECTOR || position == Position.SENIOR_MANAGER; // O(1)
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id); // O(1)
        if (person != null) {
            return !isManager(person); // O(1)
        }
        return false; // если person не найден, возвращаем false
    }

}
