package pl.venustus.OracleDataModify;

import com.sun.istack.NotNull;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {

    @NotNull
    @Value("${spring.datasource.username}")
    private String username;

    @NotNull
    @Value("${spring.datasource.password}")
    private String password;

    @NotNull
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
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1522/orcl1");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        System.out.println("polaczenie");
        return dataSource;
    }
}