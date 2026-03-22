import java.sql.*;
import java.util.*;


public class Grades {
    public static void grade(int lim){
        try{
            Connection con = dbConnection.jdbcConnection();
            String sql = "Insert into grades(Id,Name,Telugu,Hindi,English,Maths,Science,Social,Total)";
            PreparedStatement ps = con.prepareStatement(sql);

        }
    }
}
