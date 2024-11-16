package ru.otus.java.basic.homeworks.hw4;

public class User {

    String surname;     // фамилия
    String name;    // имя
    String patronymicSurname;   // отчество
    int yearBirth;  // год рождения
    String email;

    public User(String surname, String name, String patronymicSurname, int yearBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymicSurname = patronymicSurname;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymicSurname + "\n" + "Год рождения: " + yearBirth
                + "\n" + "e-mail: " + email);
    }

}
