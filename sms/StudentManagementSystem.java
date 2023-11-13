package sms;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentManagementSystem {
    void add(){}
    void edit(){}
    void remove(){}
    void search(String roll_id){}
    void display() throws SQLException {
        Connection conn=new ConnectDB().connect();
    }


}
