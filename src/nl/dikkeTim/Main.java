package nl.dikkeTim;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("workingdir.txt");
        printFile(path);
        path = FileSystems.getDefault().getPath("files", "subdir.txt");
        printFile(path);
        path = Paths.get("/home/vangalilea/Aiden/JavaCourse/outsidedir.txt");
        printFile(path);
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
