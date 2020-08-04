package pl.venustus.OracleDataModify.Config;

import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {

    @Value("${spring.datasource.username}")
    private String username;


    @Value("${spring.datasource.password}")
    private String password;


    @Value("spring.datasource.url")
    private String url;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    HikariDataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1522/orcl1");

        HikariDataSource hikariDs = new HikariDataSource();
        hikariDs.setDataSource(dataSource);
        hikariDs.setConnectionInitSql("ALTER SESSION SET CURRENT_SCHEMA = MY_SCHEMA");
        return hikariDs;
    }
}