import java.sql.*;

public class conn {
    
    public Connection c;
    public Statement s;
 
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  //help to connect to sql
            //ps is the database user name
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ps","root","Wil518340");  //ps is the database user name
            s = c.createStatement();

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
 
