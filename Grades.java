import java.sql.*;
import java.util.*;


public class Grades extends Teacher {
    public static void grade(int lim){
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = dbConnection.jdbcConnection();
            String sql = "Insert into grades(Id,Name,Telugu,Hindi,English,Maths,Science,Social,Total)";
            PreparedStatement ps = con.prepareStatement(sql);
            while(lim>=0){
                System.out.print("Enter Id: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Telugu Marks: ");
                float tel = sc.nextFloat();
                System.out.print("Enter Hindi Marks: ");
                float hin = sc.nextFloat();
                System.out.print("Enter English Marks: ");
                float eng = sc.nextFloat();
                System.out.print("Enter Maths Marks: ");
                float mat = sc.nextFloat();
                System.out.print("Enter Science Marks\n(note if bio and phy enter avg of bio and phy): ");
                float sci = sc.nextFloat();
                System.out.print("Enter Social Marks: ");
                float soc = sc.nextFloat();
                float total = (tel+hin+eng+mat+sci+soc);
                ps.setString(1,id);
                ps.setString(2,name);
                ps.setFloat(3, tel);
                ps.setFloat(4, hin);
                ps.setFloat(5, eng);
                ps.setFloat(6, mat);
                ps.setFloat(7, sci);
                ps.setFloat(8, soc);
                ps.setFloat(9, total);
                lim--;
            }
            ps.close();
        }catch(Exception e){
            System.out.println("Went Wrong!!");
            e.printStackTrace();
        }
    }
    public static void updateGradeOfParticularStudent(){
        Scanner sc = new Scanner(System.in);

        try{
            Connection con = dbConnection.jdbcConnection();
            String sql = "Update grades set Telugu=? Telugu=? Telugu=? Telugu=? Telugu=? Telugu=? Telugu=? where id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("enter the id of the student: ");
            String id= sc.nextLine();
            System.out.print("Enter Telugu Marks: ");
                float tel = sc.nextFloat();
                System.out.print("Enter Hindi Marks: ");
                float hin = sc.nextFloat();
                System.out.print("Enter English Marks: ");
                float eng = sc.nextFloat();
                System.out.print("Enter Maths Marks: ");
                float mat = sc.nextFloat();
                System.out.print("Enter Science Marks\n(note if bio and phy enter avg of bio and phy): ");
                float sci = sc.nextFloat();
                System.out.print("Enter Social Marks: ");
                float soc = sc.nextFloat();
                float total = (tel+hin+eng+mat+sci+soc);
                ps.setString(1,id);
                ps.setFloat(3, tel);
                ps.setFloat(4, hin);
                ps.setFloat(5, eng);
                ps.setFloat(6, mat);
                ps.setFloat(7, sci);
                ps.setFloat(8, soc);
                ps.setFloat(9, total);
                ps.close();
        }catch(Exception e){
            System.out.println("Went Wrong!!");
            e.printStackTrace();
        }
        sc.close();
    }
}
