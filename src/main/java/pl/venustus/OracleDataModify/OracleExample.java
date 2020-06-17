package pl.venustus.OracleDataModify;
 /* Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.*/
/*
   DESCRIPTION
   The code sample shows how to use the DataSource API to establish a connection
   to the Database. You can specify properties with "setConnectionProperties".
   This is the recommended way to create connections to the Database.
   Note that an instance of oracle.jdbc.pool.OracleDataSource doesn't provide
   any connection pooling. It's just a connection factory. A connection pool,
   such as Universal Connection Pool (UCP), can be configured to use an
   instance of oracle.jdbc.pool.OracleDataSource to create connections and
   then cache them.

    Step 1: Enter the Database details in this file.
            DB_USER, DB_PASSWORD and DB_URL are required
    Step 2: Run the sample with "ant DataSourceSample"

   NOTES
    Use JDK 1.7 and above
   MODIFIED    (MM/DD/YY)
    nbsundar    02/17/15 - Creation
 */

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Properties;

    public class OracleExample {
        // The recommended format of a connection URL is the long format with the
        // connection descriptor.
        final static String DB_URL= "jdbc:oracle:thin:@myhost:1521/myorcldbservicename";
        // For ATP and ADW - use the TNS Alias name along with the TNS_ADMIN when using 18.3 JDBC driver
        // final static String DB_URL="jdbc:oracle:thin:@wallet_dbname?TNS_ADMIN=/Users/test/wallet_dbname";
        // In case of windows, use the following URL
        // final static String DB_URL="jdbc:oracle:thin:@wallet_dbname?TNS_ADMIN=C:\\Users\\test\\wallet_dbname";
        final static String DB_USER = "hr";
        final static String DB_PASSWORD = "hr";

        /*
         * The method gets a database connection using
         * oracle.jdbc.pool.OracleDataSource. It also sets some connection
         * level properties, such as,
         * OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH,
         * OracleConnection.CONNECTION_PROPERTY_THIN_NET_CHECKSUM_TYPES, etc.,
         * There are many other connection related properties. Refer to
         * the OracleConnection interface to find more.
         */
        public static void main(String args[]) throws SQLException {
            Properties info = new Properties();
            info.put(OracleConnection.PROXY_USER_NAME, DB_USER);
            info.put(OracleConnection.PROXY_USER_PASSWORD, DB_PASSWORD);
            info.put(OracleConnection.CONNECTION_PROPERTY_CREATE_DESCRIPTOR_USE_CURRENT_SCHEMA_FOR_SCHEMA_NAME, "20");


            OracleDataSource ods = new OracleDataSource();
            ods.setURL(DB_URL);
            ods.setConnectionProperties(info);

            // With AutoCloseable, the connection is closed automatically.
            try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
                // Get the JDBC driver name and version
                DatabaseMetaData dbmd = connection.getMetaData();
                System.out.println("Driver Name: " + dbmd.getDriverName());
                System.out.println("Driver Version: " + dbmd.getDriverVersion());
                // Print some connection properties
                System.out.println("Default Row Prefetch Value is: " +
                        connection.getDefaultRowPrefetch());
                System.out.println("Database Username is: " + connection.getUserName());
                System.out.println();
                // Perform a database operation
                printEmployees(connection);
            }
        }
        /*
         * Displays first_name and last_name from the employees table.
         */
        public static void printEmployees(Connection connection) throws SQLException {
            // Statement and ResultSet are AutoCloseable and closed automatically.
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement
                        .executeQuery("select first_name, last_name from employees")) {
                    System.out.println("FIRST_NAME" + "  " + "LAST_NAME");
                    System.out.println("---------------------");
                    while (resultSet.next())
                        System.out.println(resultSet.getString(1) + " "
                                + resultSet.getString(2) + " ");
                }
            }
        }


}
