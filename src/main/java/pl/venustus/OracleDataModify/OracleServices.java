package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class OracleServices {

    @Autowired
    OracleConnection oracleConnection;

    public String executeSlectStatement() throws SQLException {

        Statement statement = oracleConnection.makeConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ETATY");
        String result = "";
        while (rs.next()) {
            System.out.println(rs.getString(1));
            result = result + rs.getString(1) + "\n";
        }
        return result;
    }
}
