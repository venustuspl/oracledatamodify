package pl.venustus.OracleDataModify;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


    public class OracleSimpleConnection {

        static public void OracleSimpleConnection_z_baza()
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                System.out.println("Sterowniki załadowane");

                Connection OracleSimpleConnection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.50:1521:orcl","login","haslo");

                System.out.println("Połączenie nawiązane");

                Statement a =OracleSimpleConnection.createStatement();
                ResultSet res = a.executeQuery("select * from AUTOR");

                System.out.println("Wyniki zapytania: ");

                while(res.next()){
                    System.out.print(res.getString(1) + " ");
                    System.out.print(res.getString(2));
                    System.out.println(res.getString(3));
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
