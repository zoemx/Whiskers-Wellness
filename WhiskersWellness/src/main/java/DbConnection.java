
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class DbConnection {
public Connection connect_to_db(String dbname, String user, String pass){
    Connection conn = null;
    try{
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
       // if (conn != null){
           // System.out.println("Connection Established");
        //}else{
            //System.out.println("Connection Failed");
        // }
   }catch (Exception e){
      // System.out.println(e);
    }
return conn;
}
public void createTable(Connection conn, String table_name){
    Statement statement;

    try{
        String query ="create table "+table_name+" (id SERIAL, name varchar(200), weight decimal(100, 1));";


        statement=conn.createStatement();
        statement.executeUpdate(query);
       // System.out.println("Table Created");
    }catch(Exception e){
       // System.out.print(e);
    }
}
    public void createWTable(Connection conn, String table_name){
        Statement statement;

        try{
            String query ="create table "+table_name+" ( date DATE DEFAULT CURRENT_TIMESTAMP, weight decimal(100, 1));";


            statement=conn.createStatement();
            statement.executeUpdate(query);
           // System.out.println("Table Created");
        }catch(Exception e){
            //System.out.print(e);
        }
    }
    public void insert_row(Connection conn,String table_name,String name, Double weight){
        Statement statement;
        try {
            String query=String.format("insert into %s(name, weight) values('%s', '%s');",table_name,name, weight);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            // System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void insert_Wrow(Connection conn,String table_name,Double weight){
        Statement statement;
        try {
            String query=String.format("insert into %s(weight) values( '%s');",table_name, weight);
            statement=conn.createStatement();
            statement.executeUpdate(query);
           // System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void read_w(Connection conn, String table_name){
    Statement statement;
    ResultSet result = null;
    try {
        String query = String.format("select * from %s", table_name);
        statement = conn.createStatement();
        result = statement.executeQuery(query);
        System.out.println("Date    Weight (lbs)");
        System.out.println("------------------------");
        while(result.next()){
            System.out.println(result.getString("date")+" | "+ result.getString("weight")+" ");
            System.out.println("------------------------");
        }
    }catch(Exception e){
        System.out.println(e);
    }
    }
}





