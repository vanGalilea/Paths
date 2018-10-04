package nl.dikkeTim;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
//        Path path = FileSystems.getDefault().getPath("workingdir.txt");
//        printFile(path);
////        path = FileSystems.getDefault().getPath("files", "subdir.txt");
//        path = Paths.get(".", "files", "subdir.txt");
//        printFile(path);
////        path = Paths.get("/home/vangalilea/Aiden/JavaCourse/outsidedir.txt");
////        path = Paths.get("/home/vangalilea/Aiden", "/JavaCourse", "outsidedir.txt");
//        path = FileSystems.getDefault().getPath("/home/vangalilea/Aiden", "/JavaCourse", "outsidedir.txt");
//        System.out.println("absolute path: " + path.normalize().toAbsolutePath());
//        printFile(path.normalize());
//
//        Path nonExistingFile = FileSystems.getDefault().getPath("nonexisting.txt");
//        System.out.println(nonExistingFile.toAbsolutePath());
        try {
            Path fileToDelete = FileSystems.getDefault().getPath("files", "workingdirCopy.txt");
            Files.deleteIfExists(fileToDelete);
// Path fileToMove = FileSystems.getDefault().getPath("workingdir.txt");
//            Path destination = FileSystems.getDefault().getPath("files", "movedWorkingdir.txt");
//            Files.move(fileToMove, destination);
//            Path sourceFile = FileSystems.getDefault().getPath("workingdir.txt");
//            Path copyFile = FileSystems.getDefault().getPath("workingdirCopy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            Path copyFile2 = FileSystems.getDefault().getPath("files", "workingdirCopy.txt");
//            Files.copy(sourceFile, copyFile2, StandardCopyOption.REPLACE_EXISTING);

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
