package pl.venustus.OracleDataModify.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.venustus.OracleDataModify.Config.OracleConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OracleService {

    @Autowired
    private OracleConnection oracleConnection;

    //@Value("${spring.datasource.username}")
    private final String username = "skome";

//    @Autowired
//    private FileLogger fileLogger;

    @Autowired
    private DynamicRollingLogFile dynamicRollingLogFile;

    @Autowired
    private DynamicRollingLogFile2 dynamicRollingLogFile2;

    public List<String> executeSelectStatusByVariable(String surname, String data0, String data1) throws SQLException {
        System.out.println(surname);
        String sql = "SElECT * FROM I_BILLING_MEASURE_REGISTER WHERE I_BMR_PPE LIKE '%" + surname + "%' ";
        if (data0.length() > 0) {
            sql = sql + "AND I_BMR_DTFROM >= TO_DATE('" + data0 + "', 'yyyy/mm/dd') ";
        }
        if (data1.length() > 0) {
            sql = sql + "AND I_BMR_DTTO <= TO_DATE('" + data1 + "', 'yyyy/mm/dd') ";
        }
        sql = sql + "AND I_BMR_BILLINGREADFLAG = 0";
        //dynamicRollingLogFile.makeLogger("info", sql);
        System.out.println(sql);

        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //System.out.println(rs.getString(2));
                dynamicRollingLogFile.makeLogger("info", rs.getString(2));
                result = result + rs.getString(2) + "\n";
                resultList.add(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(73) + " | " + rs.getString(77));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            dynamicRollingLogFile.makeLogger("error", result);
            System.out.println(result);
        }

        return resultList;
    }

    //functions for my work
    public String executeSetStatusByVariable(String surname, String data0, String data1, Boolean iscorrection) throws SQLException {

        System.out.println(surname);
        String sql = "UPDATE I_BILLING_MEASURE_REGISTER SET I_BMR_BILLINGREADFLAG = 1, I_BMR_STATUS_DESC = 'OR zafakturowany' WHERE I_BMR_PPE LIKE '%" + surname + "%' ";
        if (data0.length() > 0) {
            sql = sql + "AND I_BMR_DTFROM >= TO_DATE('" + data0 + "', 'yyyy/mm/dd') ";
        }
        if (data1.length() > 0) {
            sql = sql + "AND I_BMR_DTTO <= TO_DATE('" + data1 + "', 'yyyy/mm/dd') ";
        }
        if (iscorrection) {
            sql = sql + "AND I_BMR_CORRECTION = 1 ";
        } else {
            sql = sql + "AND I_BMR_CORRECTION = 0 ";
        }
        // sql = sql + "; commit";
        dynamicRollingLogFile.makeLogger("info", sql);
        String result = "";
        try {
            System.out.println(sql);
            Statement statement = oracleConnection.makeConnection().createStatement();
            Integer rs = statement.executeUpdate(sql);
            result = String.valueOf(rs);
            System.out.println(rs);
            dynamicRollingLogFile.makeLogger("info", result);
        } catch (
                Exception e) {
            result = e.getMessage();
            dynamicRollingLogFile.makeLogger("error", result);

        }
        return result;
    }

    public List<String> selectAllUserTables() throws SQLException, IOException {

        String sql = "SELECT * FROM ALL_TABLES WHERE OWNER LIKE '%" + username.toUpperCase() + "%'";
        System.out.println(sql);
        //dynamicRollingLogFile2.makeLogger("info", sql);
        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //System.out.println(rs.getString(2));
                //  dynamicRollingLogFile2.makeLogger("info", rs.getString(2));
                result = result + rs.getString(2) + "\n";
                resultList.add(rs.getString(2));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            dynamicRollingLogFile2.makeLogger("error", result);
            System.out.println(result);
        }

        return resultList;
    }

    public List<String> selectAllColumsFromTable(String tableName) throws SQLException {

        String sql = "SELECT COLUMN_NAME FROM ALL_TAB_COLS WHERE TABLE_NAME LIKE '%" + tableName.toUpperCase() +
                "%' AND OWNER LIKE '%" + username.toUpperCase() + "%'";
        System.out.println(sql);
        //dynamicRollingLogFile2.makeLogger("info", sql);
        String result = "";
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                //      dynamicRollingLogFile2.makeLogger("info", rs.getString(1));
                result = result + rs.getString(1) + "\n";
                resultList.add(rs.getString(1));
                rowCount++;
            }
        } catch (Exception e) {
            result = e.getMessage();
            dynamicRollingLogFile2.makeLogger("error", result);
            System.out.println(result);
        }

        return resultList;
    }

    public List<String> getDataFromUserSelect(String tableName, String columnName, String columnValue) throws SQLException {

        String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE '%" + columnValue + "%'";
        //dynamicRollingLogFile.makeLogger("info", sql);
        System.out.println(sql);
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //ystem.out.println(rs.getString(1));
                dynamicRollingLogFile.makeLogger("info", rs.getString(1));
                resultList.add(rs.getString(1));
            }
        } catch (Exception e) {
            resultList.add(e.getMessage());
            dynamicRollingLogFile.makeLogger("error", e.getMessage());
        }

        return resultList;
    }

    public String updateDataFromUserSelect(String tablename, String column,
                                           String oldcolumnvalue, String newcolumnvalue
    ) throws SQLException {

        String sql = "UPDATE " + tablename + " SET " + column + " = '" + newcolumnvalue + "' WHERE " +
                column + " LIKE '%" + oldcolumnvalue + "%' ";
        dynamicRollingLogFile.makeLogger("info", sql);
        System.out.println(sql);
        String result = "";
        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            Integer rs = statement.executeUpdate(sql);
            result = String.valueOf(rs);
            dynamicRollingLogFile.makeLogger("info", result);
        } catch (Exception e) {
            result = e.getMessage();
            dynamicRollingLogFile.makeLogger("error", result);
            System.out.println(e.getMessage());

        }
        return result;
    }

    public String getConnectionInfo() {
        return oracleConnection.getConnectionInfo();
    }


    public String getCountedDataFromUserSelect(String tableName, String columnName, String columnValue) throws SQLException {

        String sql = "SELECT count(*) FROM " + tableName + " WHERE " + columnName + " LIKE '%" + columnValue + "%'";
        //dynamicRollingLogFile.makeLogger("info", sql);
        System.out.println(sql);
        Integer rowCount = 0;
        List<String> resultList = new ArrayList<>();
        String result = "";

        try {
            Statement statement = oracleConnection.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //ystem.out.println(rs.getString(1));
                dynamicRollingLogFile.makeLogger("info", rs.getString(1));
                resultList.add(rs.getString(1));
            }
        } catch (Exception e) {
            resultList.add(e.getMessage());
            dynamicRollingLogFile.makeLogger("error", e.getMessage());
        }

        return String.valueOf(resultList.get(0));
    }
}