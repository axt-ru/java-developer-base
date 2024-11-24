package ru.otus.java.basic.homeworks.hw4;

public class User {

    private String surname;     // фамилия
    private String name;    // имя
    private String patronymicSurname;   // отчество
    private int yearBirth;  // год рождения
    private String email;

    public int getYearBirth() {
        return yearBirth;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymicSurname() {
        return patronymicSurname;
    }

    public String getEmail() {
        return email;
    }

    public User(String surname, String name, String patronymicSurname, int yearBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymicSurname = patronymicSurname;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void info(String surname, String name, String patronymicSurname, int yearBirth, String email) {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymicSurname + "\n" + "Год рождения: " + yearBirth
                + "\n" + "e-mail: " + email);
    }

}
