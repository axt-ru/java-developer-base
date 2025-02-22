package ru.otus.java.basic.homeworks.project;
import java.io.IOException;
import java.util.Scanner;


public class FileManagerApp {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Файловый менеджер запущен!");
        System.out.println("Введите слово 'help', чтобы посмотреть список поддерживаемых команд для управления файлами и каталогами");
        while (true) {
            System.out.print("[" + fileManager.getCurrentPath() + "]$ ");
            String in = scanner.nextLine();
            if (in.trim().isEmpty()) {
                continue;
            }
            String[] partsConsoleCommand = in.split("\\s+");
            String consoleCommand = partsConsoleCommand[0];
            switch (consoleCommand) {
                case "ls":
                    fileManager.listFiles(partsConsoleCommand);
                    break;
                case "cd":
                    fileManager.changeDir(partsConsoleCommand);
                    break;
                case "mkdir":
                    fileManager.makeDir(partsConsoleCommand);
                    break;
                case "rm":
                    fileManager.removeFileOrDirectory(partsConsoleCommand);
                    break;
                case "mv":
                    fileManager.moveOrRenameFileOrDirectory(partsConsoleCommand);
                    break;
                case "cp":
                    fileManager.copyFileOrDirectory(partsConsoleCommand);
                    break;
                case "finfo":
                    fileManager.fileInfo(partsConsoleCommand);
                    break;
                case "find":
                    fileManager.findFile(partsConsoleCommand);
                    break;
                case "help":
                    fileManager.printHelpAboutCommands();
                    break;
                case "exit":
                    System.out.println("Выходим из файлового менеджера...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите слово 'help', чтобы посмотреть список поддерживаемых команд");
                    break;
            }
        }
    }

}
