package ru.otus.java.basic.homeworks.project;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileManager {
    private Path currentPath = Paths.get("").toAbsolutePath();

    public Path getCurrentPath() {
        return currentPath;
    }

    public void listFiles(String[] partsConsoleCommand) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentPath)) {
            for (Path entry : stream) {
                if (partsConsoleCommand.length > 1 && partsConsoleCommand[1].equals("-i")) {
                    BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                    String fileSize = attrs.isDirectory() ? "<Каталог>" : String.valueOf(attrs.size());
                    String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Files.getLastModifiedTime(entry).toMillis());
                    System.out.printf("%s\t%s\t%s\n", entry.getFileName(), fileSize, lastModified);
                } else {
                    System.out.println(entry.getFileName());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка просмотра текущего каталога: " + e.getMessage());
        }
    }

    public void changeDir(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 2) {
            System.out.println("Синтаксис команды должен быть следующий -  cd [path]");
            return;
        }
        Path targetPath = (partsConsoleCommand[1].equals("..")) ? currentPath.getParent() : currentPath.resolve(partsConsoleCommand[1]);
        if (Files.isDirectory(targetPath)) {
            currentPath = targetPath.toAbsolutePath().normalize();
        } else {
            System.out.println("Не каталог: " + partsConsoleCommand[1]);
        }
    }

    public void makeDir(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 2) {
            System.out.println("Синтаксис команды должен быть следующий -  mkdir [name]");
            return;
        }
        Path dirPath = currentPath.resolve(partsConsoleCommand[1]);
        try {
            Files.createDirectory(dirPath);
            System.out.println("Каталог создан: " + dirPath.getFileName());
        } catch (IOException e) {
            System.out.println("Ошибка создания каталога " + e.getMessage());
        }
    }

    public void copyFileOrDirectory(String[] partsConsoleCommand) throws IOException {
        if (partsConsoleCommand.length < 3) {
            System.out.println("Синтаксис команды должен быть следующий - cp [source] [destination] (-r) (-f)");
            return;
        }
        Path sourcePath = currentPath.resolve(partsConsoleCommand[1]);
        Path destinationPath = currentPath.resolve(partsConsoleCommand[2]);

        boolean recursive = Arrays.asList(partsConsoleCommand).contains("-r");
        boolean force = Arrays.asList(partsConsoleCommand).contains("-f");

        if (Files.isDirectory(sourcePath)) {
            if (!recursive) {
                System.out.println("В папке есть и другие папки и/или файлы. Используйте ключ -r ");
                return;
            }
            copyDirectory(sourcePath, destinationPath, force);
        } else {
            copyFile(sourcePath, destinationPath, force);
        }
    }

    private void copyFile(Path source, Path destination, boolean force) throws IOException {
        if (Files.exists(destination) && !force) {
            System.out.println("Такой файл уже существует. Используйте ключ -f для перезаписи");
            return;
        }
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Файл скопирован в: " + destination.getFileName());
    }

    private void copyDirectory(Path sourceDir, Path destinationDir, boolean force) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetPath = destinationDir.resolve(sourceDir.relativize(dir));
                if (!Files.exists(targetPath)) {
                    Files.createDirectory(targetPath);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetPath = destinationDir.resolve(sourceDir.relativize(file));
                copyFile(file, targetPath, force);
                return FileVisitResult.CONTINUE;
            }
        });
        System.out.println("Папка скопирована в: " + destinationDir.getFileName());
    }


    public void removeFileOrDirectory(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 2) {
            System.out.println("Синтаксис команды должен быть следующий -  rm [filename]");
            return;
        }
        Path filePath = currentPath.resolve(partsConsoleCommand[1]);
        try {
            if (Files.isDirectory(filePath)) {
                Files.walkFileTree(filePath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } else {
                Files.delete(filePath);
            }
            System.out.println("Удалено: " + filePath.getFileName());
        } catch (IOException e) {
            System.out.println("Ошибка удаления файла/каталога: " + e.getMessage());
        }
    }

    public void moveOrRenameFileOrDirectory(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 3) {
            System.out.println("Синтаксис команды должен быть следующий -  mv [source] [destination]");
            return;
        }
        Path sourcePath = currentPath.resolve(partsConsoleCommand[1]);
        Path destinationPath = currentPath.resolve(partsConsoleCommand[2]);
        try {
            if (Files.exists(destinationPath)) {
                if (!(partsConsoleCommand.length > 3 && partsConsoleCommand[3].equals("-f"))) {
                    System.out.println("Такой файл существует. Используйте -f для принудительной перезаписи");
                    return;
                }
            }
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Перемещен/переименован в: " + destinationPath.getFileName());
        } catch (IOException e) {
            System.out.println("Ошибка перемещения/переименования файла: " + e.getMessage());
        }
    }

    public void fileInfo(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 2) {
            System.out.println("Синтаксис команды должен быть следующий -  finfo [filename]");
            return;
        }
        Path filePath = currentPath.resolve(partsConsoleCommand[1]);
        try {
            if (Files.exists(filePath)) {
                BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
                System.out.println("Файл: " + filePath.getFileName());
                System.out.println("Размер: " + attrs.size());
                System.out.println("Последнее изменение: " +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(attrs.lastModifiedTime().toMillis()));
                System.out.println("Это каталог: " + attrs.isDirectory());
                System.out.println("Обычный файл: " + attrs.isRegularFile());
                System.out.println("Символическая ссылка: " + attrs.isSymbolicLink());
            } else {
                System.out.println("Файл не найден: " + filePath.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Ошибка получения информации о файле: " + e.getMessage());
        }
    }

    public void findFile(String[] partsConsoleCommand) {
        if (partsConsoleCommand.length < 2) {
            System.out.println("Синтаксис команды должен быть следующий -  find [filename]");
            return;
        }
        String fileName = partsConsoleCommand[1];
        try {
            Files.walkFileTree(currentPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.getFileName().toString().equals(fileName)) {
                        System.out.println("Найден: " + file.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.out.println("Ошибка поиска файла: " + e.getMessage());
        }
    }

    public void printHelpAboutCommands() {
        System.out.println("Доступные команды");
        System.out.println("ls (-i) - Список файлов в текущем каталоге. Ключ -i, выводит подробную информацию о файлах и каталогах: имя – размер – дата последнего изменения");
        System.out.println("cd [path] - Переход в указанную поддиректорию. cd .. – переход в родительский каталог.");
        System.out.println("mkdir [name] - Создать новый каталог");
        System.out.println("rm [filename] - Удалить файл или каталог (и все его подкаталоги)");
        System.out.println("mv [source] [destination] (-f) - Переместить/переименовать файл или каталог. Ключ -f - в случае принудительного перемещения файла в точке назначения, если такой файл существует");
        System.out.println("cp [source] [destination] (-f) (-r) - Копирование файла или каталога. Ключ -f - в случае принудительного переписывания файла в точке назначения, если такой файл существует. Ключ -r копирует все подкаталоги и все файлы из этих подкаталогов");
        System.out.println("finfo [filename] - Получить подробную информацию о файле");
        System.out.println("find [filename] - Найти файл с указанным именем");
        System.out.println("help - Вывод в консоль всех поддерживаемых команд");
        System.out.println("exit - Завершение работы файлового менеджера");
    }

}
