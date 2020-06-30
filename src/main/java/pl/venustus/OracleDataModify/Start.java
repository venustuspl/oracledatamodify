package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Start {

    @Autowired
    OracleConfiguration oracleConfiguration;

    public void makeConnection() throws SQLException {

        DataSource dataSource = oracleConfiguration.dataSource();

        Connection dataConnection = dataSource.getConnection();

        System.out.println(dataConnection.getClientInfo());

        dataConnection.close();
    }
}
