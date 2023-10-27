package atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// uid name phone_no balance pin
public class Database {
    void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter uid : ");
        uid=sc.nextInt();
        System.out.print("Enter pin : ");
        pin=sc.nextInt();
    }
    private int uid,pin;
    Credentials checkUser() throws SQLException {
        Connection conn=new ConnectDB().connect();
        input();
        String sql_login ="select * from credentials where uid = ? and pin = ?";
        PreparedStatement ps = conn.prepareStatement(sql_login);
        ps.setInt(1, uid);
        ps.setInt(2, pin);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Credentials crds = new Credentials();
            crds.setUid(rs.getInt("uid"));
            crds.setName(rs.getString("name"));
            crds.setPhone_no(rs.getString("phone_no"));
            crds.setBalance(rs.getDouble("balance"));
            crds.setPin(rs.getInt("pin"));
            return crds;
        }
        return null;
    }
    void updateUser(Credentials crds) throws SQLException {
        Connection conn=new ConnectDB().connect();
        String sql_update ="UPDATE credentials SET balance = ? where uid = ?";
        PreparedStatement ps = conn.prepareStatement(sql_update);
        ps.setDouble(1,crds.getBalance());
        ps.setInt(2, crds.getUid());
        ps.execute();
    }

}
