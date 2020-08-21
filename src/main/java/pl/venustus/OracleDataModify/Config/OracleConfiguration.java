package pl.venustus.OracleDataModify.Config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;


@Configuration
public class OracleConfiguration {

    private final Boolean isPropertiesWasImportetFromFile = false;

    //@Value("${spring.datasource.username}")
    private String username;


    //@Value("${spring.datasource.password}")
    private String password;

    //@Value("${spring.datasource.url}")
    private String url;


    public void setDataSourceProperties() {
        try {
            System.out.println("File searching...");
            File myObj = new File("bin/settings.txt");
            Scanner myReader = new Scanner(myObj);

            setUrl(myReader.nextLine());
            setUsername(myReader.nextLine());
            setPassword(myReader.nextLine());
            System.out.println(url + username + password);

            //FileWriter fileWriter = new FileWriter(myObj);
            //fileWriter.append(String.valueOf(LocalDateTime.now()));
            //fileWriter.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

//        if (!isPropertiesWasImportetFromFile) {
//
//        } else {
//
//        }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    @Bean
    DataSource dataSource() throws SQLException {
        try {
            System.out.println("File searching...");
            File myObj = new File("bin/settings.txt");
            Scanner myReader = new Scanner(myObj);

            setUrl(myReader.nextLine());
            setUsername(myReader.nextLine());
            setPassword(myReader.nextLine());
            System.out.println(url + username + password);

            //FileWriter fileWriter = new FileWriter(myObj);
            //fileWriter.append(String.valueOf(LocalDateTime.now()));
            //fileWriter.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("Data source: " + url + "|" + username + "|" + password);
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);

        return dataSource;
    }
}