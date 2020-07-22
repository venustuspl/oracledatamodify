package pl.venustus.OracleDataModify.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import pl.venustus.OracleDataModify.Config.OracleConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OracleServices {


    @Value("${spring.datasource.username}")
    private String username;

    @Autowired
    OracleConnection oracleConnection;

    public List<String> executeSelectStatusByVariable(String surname, String data0, String data1) throws SQLException {

        System.out.println(surname);
        String sql = "SELECT * FROM PRACOWNICY WHERE NAZWISKO LIKE '%" + surname + "%' ";
        if (data0.length() > 0) {
            sql = sql + "AND ZATRUDNIONY >= TO_DATE('" + data0 + "', 'yyyy/mm/dd') ";
        }
        if (data1.length() > 0) {
            sql = sql + "AND ZATRUDNIONY <= TO_DATE('" + data1 + "', 'yyyy/mm/dd') ";
        }
        System.out.println(sql);

        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(2));
                result = result + rs.getString(2) + "\n";
                resultList.add(rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            System.out.println(result);
        }

        return resultList;
    }

    //functions for my work
    public String executeSetStatusByVariable(String surname, String data0, String data1) throws SQLException {

        System.out.println(surname);
        String sql = "UPDATE PRACOWNICY SET PLACA_DOD = 1 WHERE NAZWISKO LIKE '%" + surname + "%' ";
        if (data0.length() > 0) {
            sql = sql + "AND ZATRUDNIONY >= TO_DATE('" + data0 + "', 'yyyy/mm/dd') ";
        }
        if (data1.length() > 0) {
            sql = sql + "AND ZATRUDNIONY <= TO_DATE('" + data1 + "', 'yyyy/mm/dd') ";
        }
        System.out.println(sql);
        String result = "";
        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            Integer rs = statement.executeUpdate(sql);
            result = String.valueOf(rs);
        } catch (
                Exception e) {
            result = e.getMessage();

        }
        return result;
    }

    public List<String> selectAllUserTables() throws SQLException {

        String sql = "SELECT * FROM ALL_TABLES WHERE OWNER LIKE '%" + username.toUpperCase() + "%'";
        System.out.println(sql);
        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(2));
                result = result + rs.getString(2) + "\n";
                resultList.add(rs.getString(2));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            System.out.println(result);
        }

        return resultList;
    }

    public List<String> selectAllcolumsFromTable(String tableName) throws SQLException {

        String sql = "SELECT COLUMN_NAME FROM ALL_TAB_COLS WHERE TABLE_NAME LIKE '%" + tableName.toUpperCase() +
                "%' AND OWNER LIKE '%" + username.toUpperCase() + "%'";
        System.out.println(sql);
        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                result = result + rs.getString(1) + "\n";
                resultList.add(rs.getString(1));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            System.out.println(result);
        }

        return resultList;
    }

    public List<String> getDataFromUserSelect(String tableName, String columnName, String columnValue) throws SQLException {

        String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE '%" + columnValue + "%'";
        System.out.println(sql);
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                resultList.add(rs.getString(1));
            }
        } catch (Exception e) {
            resultList.add(e.getMessage());
        }

        return resultList;
    }

    public String updateDataFromUserSelect(String tablename, String column,
                                           String oldcolumnvalue, String newcolumnvalue
    ) throws SQLException {

        String sql = "UPDATE " + tablename + " SET " + column + " = '" + newcolumnvalue + "' WHERE " +
                column + " LIKE '%" + oldcolumnvalue + "%' ";

        System.out.println(sql);
        String result = "";
        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            Integer rs = statement.executeUpdate(sql);
            result = String.valueOf(rs);
        } catch (Exception e) {
            result = e.getMessage();
            System.out.println(e.getMessage());

        }
        return result;
    }
}
