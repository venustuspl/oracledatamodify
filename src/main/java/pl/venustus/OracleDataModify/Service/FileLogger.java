package pl.venustus.OracleDataModify.Service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileLogger {
    private final String filePath = "C:/Temp/file.txt";

    public void addToLogFile(String sql) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.append(String.valueOf(localDateTime));
            fileWriter.append(sql);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
