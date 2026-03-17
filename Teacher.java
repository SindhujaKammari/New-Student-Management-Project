import java.util.*;
import java.sql.*;
import java.sql.Date;


public class Teacher {
    /*
    1- New Database ni create cheddam 
    2-student data ni store cheyyali 
        a- new class ayithe motham new data ni crete cheyyali Done
        b- new student ayithe existing Data lo add cheyyali aa student ni 
       [# details : name , roll number, gender, DOB , address , Course , Contact ]
    3- Grades name 
        a- whole class ki grades update cheyyali 
        b- partivualr student ki grades update cheyyali 
    4-Attandance
        a-whole class 
        b-particular student
    5-Fees
        a- upgrade whole class fees and tell whether he has balance to pay or not 

    6-Overview
        a-name, roll , course, cgpa, attandance, fees paid or not
    */
   private static Connection con;
   static Scanner sc = new Scanner(System.in);
   public static void DataBase(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","Sindhu@#$08");
            System.out.println("Working Fine!!");
            System.out.print("Enter Strength of the class: ");
            int strength = sc.nextInt();sc.nextLine();
            String command = "Insert into Students(stdSec, id,name,course,contact,gender,DateOfBirth,address) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(command);
            while(strength>=1){
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
                ps.setDate(7,Date.valueOf(dob));
                ps.setString(8,addr);
                int rowAffected = ps.executeUpdate();
                System.out.println("Rows Affected: "+rowAffected+"\nSuccesfully completed");
                strength--;
            }
            ps.close();
            con.close();
            Connection cn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","Sindhu@#$08");
            PreparedStatement ps1 = cn2.prepareStatement("Select * from students");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                System.out.println("ID: "+rs1.getString("id"));
                System.out.println("Name: "+rs1.getString("name"));
                System.out.println("Course: "+rs1.getString("course"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }      
    }
   public static void options(){
    
    System.out.println("****************************\n \tWelcome to ABC college");
    System.out.println("1-Create a new database for new academic year all sections \n2-Create a new database for just a class\n3root -p-Store student Data into the existing database\n4-update Grades of whole class\5-Update grade of particular student\6-Update attandance of whole class\7-Update attadnance of particular student\n8-Fees of All students\n9-Overview of Particular Student\n10-EXIT");
    System.out.print("Enter the choice: ");
    int option = sc.nextInt();
    sc.nextLine();
    if(option == 1){
        System.out.println("We'll Implement this feature in future!!");
    }
    else if(option ==2){
        DataBase();
    }
    else if(option==9){
    }
   }
}
