package pl.venustus.OracleDataModify.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class OracleConnection {

    @Autowired
    OracleConfiguration oracleConfiguration;

    public Connection makeConnection() throws SQLException {
        oracleConfiguration.setDataSourceProperties();
        Connection connection = oracleConfiguration.dataSource().getConnection();
        return connection;
    }

}
