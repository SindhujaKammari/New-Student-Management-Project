import java.util.*;
import java.sql.*;
class StudentData{
    public static void Existing(){
        System.out.println("Enter the Details below: ");
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = dbConnection.jdbcConnection();
            String sql = "Insert into Students(stdSec, id,name,course,contact,gender,DateOfBirth,address) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.print("Enter the Class(1-10): "); String Std =sc.nextLine();
            System.out.print("Enter the id: "); String id =sc.nextLine();
            System.out.print("Enter the name: "); String name =sc.nextLine();
            System.out.print("Enter the course: "); String course =sc.nextLine();
            System.out.print("Enter the contact: "); String contact =sc.nextLine();
            System.out.print("Enter the gender: "); String gender =sc.nextLine();
            System.out.print("Enter the D-O-B (Enter in this format only yyyy-mm-dd): "); String dob =sc.nextLine();
            System.out.print("Enter the address: "); String addr =sc.nextLine();

            ps.setString(1,Std);
            ps.setString(2,id);
            ps.setString(3,name);
            ps.setString(4,course);
            ps.setString(5,contact);
            ps.setString(6,gender);
            ps.setString(7,dob);
            ps.setString(8,addr);

        }catch(Exception e){
            System.out.println("Contact your Official Class Teacher!!");
            e.printStackTrace();
        }
    }

}