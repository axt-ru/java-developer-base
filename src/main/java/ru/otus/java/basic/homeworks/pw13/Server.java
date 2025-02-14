package ru.otus.java.basic.homeworks.pw13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("SERVER APPLICATION RUN!!!");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Клиент подключен");

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


                    out.println("Доступные операции: +, -, *, /");

                    String operation = in.readLine();
                    double num1 = Double.parseDouble(in.readLine());
                    double num2 = Double.parseDouble(in.readLine());

                    double result = 0.0;
                    switch (operation) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                out.println("Ошибка: Деление на ноль");
                                continue;
                            }
                            break;
                        default:
                            out.println("Ошибка: Неизвестная операция");
                            continue;
                    }

                    out.println("Результат: " + result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
