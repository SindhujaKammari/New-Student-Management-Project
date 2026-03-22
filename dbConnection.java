import java.sql.*;

public class dbConnection {
    public static  Connection jdbcConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","Sindhu@#$08");
            System.out.println("Connected Successfully");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connection failed ");
        }
        return con;
    }
}
