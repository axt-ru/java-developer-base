package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Employee> employeeThisAge(int minAge, ArrayList<Employee> arrayListEmployee) {
        for (int i = 0; i < arrayListEmployee.size(); i++) {
            if (arrayListEmployee.get(i).getAge() < minAge) {
                arrayListEmployee.remove(i);
            }
        }
        return arrayListEmployee;
    }

    public static boolean contolEmployeeAverageAge(int minAge, ArrayList<Employee> arrayListEmployee) {
        double avg = 0, sum = 0, count = 0;
        for (int i = 0; i < arrayListEmployee.size(); i++) {
            sum += arrayListEmployee.get(i).getAge();
            count++;
        }
        if ((sum / count) > minAge) {
            return true;
        }

        return false;
    }

    public static Employee youngEmployee(ArrayList<Employee> arrayList) {
        Employee young = arrayList.get(0);
        for (Employee employee : arrayList) {
            if (employee.getAge() < young.getAge()) {
                young = employee;
            }
        }
        return young;
    }

    @Override
    public String toString() {
        return '{' + "Имя = " + name + ", возраст = " + age + '}';
    }

}
