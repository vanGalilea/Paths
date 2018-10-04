package nl.dikkeTim;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
//        DirectoryStream.Filter<Path> filter =
//            new DirectoryStream.Filter<Path>() {
//                public boolean accept(Path path) throws IOException {
//                    return (Files.isRegularFile(path));
//                }
//            };
        DirectoryStream.Filter<Path> filter = p-> Files.isRegularFile(p); //lambda expression shorthand, I LIKE ;)

//        Path someFolderPath = FileSystems.getDefault().getPath("filetree/someFolder");
        Path someFolderPath = FileSystems.getDefault().getPath("filetree" + File.separator + "someFolder"); // to support all operating systems
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(someFolderPath, filter)) {
            for(Path file : contents) {
                System.out.println(file.getFileName());
            }


        } catch(IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        try {
           Path tempFile = Files.createTempFile("StevesTempFile", ".someSuffix");
            System.out.println("Temp file created in path: " + tempFile.toAbsolutePath());
        } catch(IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
        printFileStores();
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

    private static void printFileAttributes(Path path) throws IOException {
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Size: " + attrs.size());
        System.out.println("Last modified: " + attrs.lastModifiedTime());
        System.out.println("Created: " + attrs.creationTime());
        System.out.println("Is directory: " + attrs.isDirectory());
        System.out.println("Is regular: " + attrs.isRegularFile());
    }


    private static void printFileStores() {
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores) {
            System.out.println(store.name());
        }
    }
}
