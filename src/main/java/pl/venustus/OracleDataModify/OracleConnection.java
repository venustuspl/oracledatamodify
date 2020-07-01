package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class OracleConnection {

    @Autowired
    OracleConfiguration oracleConfiguration;

    public String makeConnection() throws SQLException {

        DataSource dataSource = oracleConfiguration.dataSource();
        System.out.println("polaczenie1");
        String result = dataSource.getConnection().getClientInfo().toString();

        return result;
    }
}
