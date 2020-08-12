package pl.venustus.OracleDataModify.Config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
class OracleConnectionTest {

    @InjectMocks
    OracleConfiguration oracleConfiguration;

    OracleConnection oracleConnection = new OracleConnection();

    @Test
    void makeConnection() throws SQLException {

        System.out.println(oracleConnection.makeConnection().getClientInfo());

    }
}