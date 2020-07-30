package pl.venustus.OracleDataModify.Service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileLogger {
    private final String filePath = "C:/Temp/file.txt";


    public void addToLogFile(String sql) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();

        boolean success = false;

        String dir = "C:/Temp/";

        File directory = new File(dir);
        if (directory.exists()) {
            System.out.println("Directory already exists ...");

        } else {
            System.out.println("Directory not exists, creating now");

            success = directory.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%n", dir);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dir);
            }
        }

        // Creating new file in Java, only if not exists
        String filename = "file.txt";

        File f = new File(filename);
        if (f.exists()) {
            System.out.println("File already exists");

        } else {
            System.out.println("No such file exists, creating now");
            success = f.createNewFile();
            if (success) {
                System.out.printf("Successfully created new file: %s%n", f);
            } else {
                System.out.printf("Failed to create new file: %s%n", f);
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append(localDateTime + sql);
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
