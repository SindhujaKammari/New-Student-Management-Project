import java.util.*;
import java.sql.*;

public class Attendance {
    public static void attendanceOfWholeClass(int lim){
        try{
            Scanner sc = new Scanner(System.in);
            Connection con = dbConnection.jdbcConnection();
            String sql = "Insert into attandance(Id,Name,Jan,Feb,Mar,Apr,total) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            while(lim>0){
                System.out.print("Enter Id: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter No.of days present in January: ");
                float jan = sc.nextFloat();sc.nextLine();
                System.out.print("Enter No.of days present in February: ");
                float feb = sc.nextFloat();sc.nextLine();
                System.out.print("Enter No.of days present in March: ");
                float mar = sc.nextFloat();sc.nextLine();
                System.out.print("Enter No.of days present in April: ");
                float apr = sc.nextFloat();sc.nextLine();
                float jan1 = 26.0f, feb1 = 23.0f, mar1=25.0f, apr1=24.0f ;
                float total = ((jan+feb+mar+apr)/(jan1+feb1+mar1+apr1))*100;
                ps.setString(1,id);
                ps.setString(2,name);
                ps.setFloat(3, jan);
                ps.setFloat(4, feb);
                ps.setFloat(5, mar);
                ps.setFloat(6, apr);
                ps.setFloat(7, total);
                ps.executeUpdate();
                lim--;
            }
        }catch(Exception e){
            System.out.println("Went Wrong!!");
            e.printStackTrace();
        }
    }
    public static void attandanceOfParticularStudent(String id){

    }
    public static void fees(String id){

    }
}
