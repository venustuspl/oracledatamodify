package pl.venustus.OracleDataModify.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.venustus.OracleDataModify.Config.OracleConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class OracleServices {

    @Autowired
    OracleConnection oracleConnection;

    //test function
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

    //functions for my work
    public String executeSetStatus() throws SQLException {

        Statement statement = oracleConnection.makeConnection().createStatement();
        Integer rs = statement.executeUpdate("UPDATE ETATY SET PLACA_MIN = 1150 WHERE NAZWA LIKE '%Mechan%'");
        //String result = "";
        //   while (rs.next()) {
        //      System.out.println(rs.getString(1));
        //       result = result + rs.getString(1) + "\n";
        //  }
        return String.valueOf(rs);
    }
}
