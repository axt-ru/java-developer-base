package ru.otus.java.basic.homeworks.pw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File dir = new File(".");
        Scanner in = new Scanner(System.in);
        String[] files = dir.list();
        boolean fileExist = false;
        String selectFile;

        while (true) {
            System.out.println("Выберите файл, с которым хотите работать");
            for (String fileName : files) {
                System.out.print(fileName + " | ");
            }
            selectFile = in.next();
            for (String fileName : files) {
                if (fileName.equals(selectFile)) {
                    fileExist = true;
                }
            }

            if (fileExist) {
                break;
            } else {
                System.out.println("Неправильное имя файла. Попробуйте снова");
            }

        }
        System.out.println(selectFile);

        System.out.println("Вы выбрали файл - " + selectFile + "\n" + "Введите текст для записи в выбранный файл");
        Scanner scanner = new Scanner(System.in);
        String text = in.next();
        byte[] buffer = text.getBytes(StandardCharsets.UTF_8);

        try (FileOutputStream out = new FileOutputStream(selectFile, true)) {
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(selectFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        InputStreamReader inFile = new InputStreamReader(bis))
        {
            int n = inFile.read();
            while (n != -1) {
                System.out.print((char) n);
                n = inFile.read();
        }
        } catch ( IOException e) {
            e.printStackTrace();
        }

    }

}
