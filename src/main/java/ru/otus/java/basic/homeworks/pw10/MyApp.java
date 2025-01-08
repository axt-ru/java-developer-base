package ru.otus.java.basic.homeworks.pw10;

public class MyApp {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Сильвестр Сталлоне", "111111");
        phoneBook.add("Арнольд Шварценеггер", "222222");
        phoneBook.add("Жан-Клод ван Дамм", "333333");
        phoneBook.add("Жан-Клод ван Дамм", "444444");
        phoneBook.add("Жан-Клод ван Дамм", "555555");

        phoneBook.telephoneBook();

        System.out.println("Найти номер телефона Арнольда Шварценеггера");
        System.out.println("Найден: " + phoneBook.find("Арнольд Шварценеггер"));

        System.out.println("Найти номер телефона Жан-Клод ван Дамм");
        System.out.println("Найден: " + phoneBook.find("Жан-Клод ван Дамм"));

        System.out.println("Наличие телефона - 000000 в справочнике: " + phoneBook.containsPhoneNumber("000000"));
        System.out.println("Наличие телефона - 111111 в справочнике: " + phoneBook.containsPhoneNumber("111111"));



    }
}
