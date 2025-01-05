package ru.otus.java.basic.homeworks.pw9;

import java.util.ArrayList;

import static ru.otus.java.basic.homeworks.pw9.Employee.contolEmployeeAverageAge;
import static ru.otus.java.basic.homeworks.pw9.Employee.employeeThisAge;

public class MyApp {
    public static void main(String[] args) {

        /**
         * Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList
         * с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
         */
        SerialArrayList list1 = new SerialArrayList();
        System.out.println(list1.serialArrayList(10,20));

        /**
         * Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
         * значение которых больше 5, и возвращающий сумму;
         */
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add((int) (Math.random() * 10));
        }
        System.out.println(list2);

        SumArrayList sumArrayListMoreFive = new SumArrayList();
        System.out.println(sumArrayListMoreFive.sumArrayList(list2));

        /**
         * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
         * метод должен переписать каждую заполненную ячейку списка указанным числом;
         */
        System.out.println(list2);

        ChangeElementArrayList newArrayListSameElements = new ChangeElementArrayList();
        System.out.println(newArrayListSameElements.changeElementArrayList(5, list2));

        /**
         * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
         * увеличивающий каждый элемент списка на указанное число;
         */
         System.out.println(list2);

         IncreaseElemetsArrayList newIncreaseElemetsArrayList = new IncreaseElemetsArrayList();
        System.out.println(newIncreaseElemetsArrayList.increaseElemetsArrayList(7, list2));

        /**
         * Создайте класс Сотрудник с полями: имя, возраст;
         * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
         */

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Иван", 25));
        employeeArrayList.add(new Employee("Петр", 35));
        employeeArrayList.add(new Employee("Влад", 45));

        System.out.println("Сотрудники");
        for (Employee employee : employeeArrayList) {
            System.out.println(employee.toString());
        }

        System.out.println("Имена сотрудников");
        for (Employee employee : employeeArrayList) {
            System.out.println(employee.getName());
        }

        /**
         * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
         * и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
         */

        System.out.println(employeeThisAge(30, employeeArrayList));

        /**
         * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,
         * и проверяющий, что средний возраст сотрудников превышает указанный аргумент;
         */
        ArrayList<Employee> employeeArrayList2 = new ArrayList<>();
        employeeArrayList2.add(new Employee("Иван", 25));
        employeeArrayList2.add(new Employee("Петр", 35));
        employeeArrayList2.add(new Employee("Влад", 45));

        System.out.println(contolEmployeeAverageAge(25, employeeArrayList2) ? "средний возраст сотрудников превышает указанный аргумент" :
                "средний возраст сотрудников не превышает указанный аргумент");

        /**
         * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку
         * на самого молодого сотрудника.
         */

       System.out.println("Cамый молодой сотрудник " + Employee.youngEmployee(employeeArrayList2));

    }



}