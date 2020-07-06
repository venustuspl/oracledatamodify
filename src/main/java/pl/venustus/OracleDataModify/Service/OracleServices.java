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

        return String.valueOf(rs);
    }

    //functions for my work
    public String executeSetStatusByVariable(String surname, String data0, String data1) throws SQLException {

        //String surname = "JANKOWSKI";
        //String data0 = "2008/10/04";
        //String data1 = "2008/10/04";
        String sql = "UPDATE PRACOWNICY SET PLACA_DOD = 1 WHERE NAZWISKO LIKE '%" + surname + "%' ";
        if (data0.length() > 0) {
            sql = sql + "AND ZATRUDNIONY >= TO_DATE('" + data0 + "', 'yyyy/mm/dd') ";
        }
        if (data1.length() > 0) {
            sql = sql + "AND ZATRUDNIONY <= TO_DATE('" + data1 + "', 'yyyy/mm/dd') ";
        }
        System.out.println(sql);

        Statement statement = oracleConnection.makeConnection().createStatement();
        Integer rs = statement.executeUpdate(sql);

        //String result = "";
        //   while (rs.next()) {
        //      System.out.println(rs.getString(1));
        //       result = result + rs.getString(1) + "\n";
        //  }
        return String.valueOf(rs);
    }
}
