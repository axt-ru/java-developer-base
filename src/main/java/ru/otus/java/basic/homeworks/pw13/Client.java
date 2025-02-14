package ru.otus.java.basic.homeworks.pw13;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Сервер: " + in.readLine());

            System.out.print("Введите операцию: ");
            String operation = scanner.nextLine();
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            out.println(operation);
            out.println(num1);
            out.println(num2);

            System.out.println("Сервер: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
