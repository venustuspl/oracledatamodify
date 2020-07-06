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
        Integer rs = statement.executeUpdate("UPDATE PRACOWNICY SET PLACA_DOD = 150 WHERE NAZWISKO LIKE '%JANKOWSKI%' AND ZATRUDNIONY = TO_DATE('2008/10/04', 'yyyy/mm/dd') ");
        //String result = "";
        //   while (rs.next()) {
        //      System.out.println(rs.getString(1));
        //       result = result + rs.getString(1) + "\n";
        //  }
        return String.valueOf(rs);
    }

    //functions for my work
    public String executeSetStatusByVariable() throws SQLException {

        String surname = "JANKOWSKI";
        String data = "2008/10/04";
        Statement statement = oracleConnection.makeConnection().createStatement();
        Integer rs = statement.executeUpdate("UPDATE PRACOWNICY SET PLACA_DOD = 1530 WHERE NAZWISKO LIKE '%" + surname + "%' " +
                "AND ZATRUDNIONY = TO_DATE('" + data + "', 'yyyy/mm/dd') ");

        //String result = "";
        //   while (rs.next()) {
        //      System.out.println(rs.getString(1));
        //       result = result + rs.getString(1) + "\n";
        //  }
        return String.valueOf(rs);
    }
}
