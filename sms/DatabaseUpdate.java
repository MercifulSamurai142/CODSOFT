package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DatabaseUpdate {
    int addUpdate(Student student) throws SQLException {
        Connection conn = new ConnectDB().connect();
        String sql_add_user = "insert into student (roll, name, gender, grade , score, address) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql_add_user);

        ps.setString(1, student.getRoll());
        ps.setString(2, student.getName());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getGrade());
        ps.setInt(5, student.getScore());
        ps.setString(6, student.getAddress());
        return ps.executeUpdate();
    }


    Student search(String roll) throws SQLException {
        Connection conn = new ConnectDB().connect();
        String sql_search="select * from student where roll = ?";
        PreparedStatement sql_search_ps=conn.prepareStatement(sql_search);
        sql_search_ps.setString(1,roll);
        ResultSet rs = sql_search_ps.executeQuery();

        Student student =new Student();
        if(rs.next()){
            student.setRoll(rs.getString("roll"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setGrade(rs.getString("grade"));
            student.setScore(rs.getInt("score"));
            student.setAddress(rs.getString("address"));
            System.out.println("Roll : "+student.getRoll()+"\tName : "+student.getName()+"\t\tGender : "+student.getGender()+"\t\tGrade : "+student.getGrade()+"\t\tScore : "+student.getScore()+"\t\tAddress : "+student.getAddress()+" ");
        }
        else {
            return null;
        }

        return student;

    }


    int editUpdate(Student student) throws SQLException {
        Connection conn = new ConnectDB().connect();
        String sql_update="UPDATE `student` SET  `name` = ?, `gender` = ?, `grade` = ?, `score` = ?, `address` = ? WHERE `student`.`roll` = ?";
        PreparedStatement sql_update_ps=conn.prepareStatement(sql_update);
        sql_update_ps.setString(1, student.getName());
        sql_update_ps.setString(2, student.getGender());
        sql_update_ps.setString(3, student.getGrade());
        sql_update_ps.setString(4, String.valueOf(student.getScore()));
        sql_update_ps.setString(5, student.getAddress());
        sql_update_ps.setString(6, student.getRoll());
        return sql_update_ps.executeUpdate();

    }

    int removeUpdate(Student student) throws SQLException {
        Connection conn = new ConnectDB().connect();
        String sql_remove="DELETE FROM student WHERE `student`.`roll` = ?";
        PreparedStatement sql_remove_ps=conn.prepareStatement(sql_remove);
        sql_remove_ps.setString(1, student.getRoll());
        return sql_remove_ps.executeUpdate();

    }

    List<Student> displayUpdate() throws SQLException {
        Connection conn = new ConnectDB().connect();
        List<Student> displayList=new LinkedList<>();
        String sql_display="SELECT * FROM student";
        PreparedStatement sql_display_ps=conn.prepareStatement(sql_display);
        ResultSet rs = sql_display_ps.executeQuery();
        while (rs.next()){
            Student temp =new Student();
            temp.setRoll(rs.getString("roll"));
            temp.setName(rs.getString("name"));
            temp.setGender(rs.getString("gender"));
            temp.setGrade(rs.getString("grade"));
            temp.setScore(rs.getInt("score"));
            temp.setAddress(rs.getString("address"));
            displayList.add(temp);
        }
        return displayList;
    }

}
