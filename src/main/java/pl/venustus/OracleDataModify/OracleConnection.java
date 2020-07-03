package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class OracleConnection {

    @Autowired
    OracleConfiguration oracleConfiguration;

    public String makeConnection() throws SQLException {

        DataSource dataSource = oracleConfiguration.dataSource();
        System.out.println("polaczenie1");

        String result = dataSource.getConnection().getSchema().toString();
        dataSource.getConnection().createStatement();
        System.out.println("polaczenie2");
        return result;
    }

    public String executeSelectStatement() throws SQLException {

        DataSource dataSource = oracleConfiguration.dataSource();
        System.out.println("polaczenie1");
        Statement statement = dataSource.getConnection().createStatement();
        String result = String.valueOf(statement.execute("SELECT * FROM ETATY"));
        System.out.println("polaczenie2");
        return result;
    }
}
