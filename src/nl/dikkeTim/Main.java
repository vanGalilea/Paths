package nl.dikkeTim;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {
//            Path fileToCreate = FileSystems.getDefault().getPath("files", "newFile.txt");
//            Files.createFile(fileToCreate);
//            Path dirToCreate = FileSystems.getDefault().getPath("newFolder");
//            Files.createDirectory(dirToCreate);
//            Path dirToCreate = FileSystems.getDefault().getPath("newFolder", "new1/new2/new3");
//            Files.createDirectories(dirToCreate);
            Path filePath = FileSystems.getDefault().getPath("files", "subdir.txt");
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size: " + attrs.size());
            System.out.println("Last modified: " + attrs.lastModifiedTime());
            System.out.println("Created: " + attrs.creationTime());
            System.out.println("Is directory: " + attrs.isDirectory());
            System.out.println("Is regular: " + attrs.isRegularFile());

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
