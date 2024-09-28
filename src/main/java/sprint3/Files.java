package sprint3;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Files {

    public static void main(String[] args) {
        File folder = new File("/Users/farrukhabdullaev/PROJECTS/Algos");
        String file_to_find = "version4222.zip";
        String result = find_file(folder, file_to_find);
        if (result == null) {
            System.out.println("File not found");
        } else {
            System.out.printf("File found at %s\n", result);
        }
    }

    private static String find_file(File folder, String fileToFind) {
        File[] directoryFileList = folder.listFiles();
        if (directoryFileList != null) {
            for (File fileName : directoryFileList) {
                if (fileName.isDirectory()) {
                    String filePath = find_file(fileName, fileToFind);
                    if (filePath != null) {
                        // если файл нашёлся, передать его вверх по цепочке рекурсивных вызовов
                        return filePath;
                    }
                } else {
                    if (fileName.getName().equals(fileToFind)) {
                        return fileName.getAbsolutePath();
                    }
                }
            }
        }
        return null;
    }


    public static String findFile(File folder, String fileToFind) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                // рекурсивно запустить поиск в подпапке
                String filePath = findFile(file, fileToFind);
                if (filePath != null) {
                    // если файл нашёлся, передать его вверх по цепочке рекурсивных вызовов
                    return filePath;
                }
            } else { // file - обычный файл
                if (file.getName().equals(fileToFind)) {
                    // если нашли нужный файл, то вернуть результат
                    return file.getAbsolutePath();
                }
            }
        }
        return null;
    }

}