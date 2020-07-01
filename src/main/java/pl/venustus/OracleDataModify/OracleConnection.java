package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class OracleConnection {

    @Autowired
    OracleConfiguration oracleConfiguration;

    public String makeConnection() throws SQLException {

        DataSource dataSource = oracleConfiguration.dataSource();

        Connection dataConnection = dataSource.getConnection();

        String result = dataConnection.getClientInfo().toString();

        dataConnection.close();

        return dataConnection.getClientInfo().toString();
    }
}
