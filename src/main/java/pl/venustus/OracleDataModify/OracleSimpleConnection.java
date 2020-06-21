package pl.venustus.OracleDataModify;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
    import java.time.LocalDateTime;


public class OracleSimpleConnection {

        static public void OracleSimpleConnection_z_baza()
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                System.out.println("Sterowniki załadowane");

                Connection OracleSimpleConnection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl1","tomek","tomek");

                System.out.println("Połączenie nawiązane");

                Statement a =OracleSimpleConnection.createStatement();
                String myStatement = "insert into etaty(nazwa, placa_min, placa_max) values ('Mechanic" + LocalDateTime.now() + "', '8000','9000')";
                ResultSet res0 = a.executeQuery(myStatement);
                System.out.println("0");
                ResultSet res1 = a.executeQuery("commit");
                System.out.println("1");
                ResultSet res2 = a.executeQuery("select * from etaty");
                System.out.println("2");


                System.out.println("Wyniki zapytania: ");

                while(res2.next()){
                    System.out.print(res2.getString(1) + " ");
                    System.out.print(res2.getString(2));
                    System.out.println(res2.getString(3));
                }
            }
            catch(Exception wyjatek)
            {
                System.out.println("Błąd");
            }


        }
        public static void main(String[] args){
            OracleSimpleConnection oracle =new OracleSimpleConnection();
            oracle.OracleSimpleConnection_z_baza();
        }
    }
