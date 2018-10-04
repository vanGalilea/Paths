package nl.dikkeTim;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        System.out.println("walking tree for someFolder-->");
        Path folderPath = FileSystems.getDefault().getPath("filetree" + File.separator + "someFolder");
        try {
            Files.walkFileTree(folderPath, new PrintNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDirsFiles(Path dirPath) throws IOException, DirectoryIteratorException {
        DirectoryStream.Filter<Path> filter = p-> Files.isRegularFile(p);
        DirectoryStream<Path> contents = Files.newDirectoryStream(dirPath, filter);
        for(Path file : contents) {
            System.out.println(file.getFileName());
        }
    }

        private static void createTempFile(String prefix, String suffix) throws IOException {
        Path tempFile = Files.createTempFile(prefix, suffix);
        System.out.println("Temp file created in path: " + tempFile.toAbsolutePath());
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
