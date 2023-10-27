package atm;

import java.sql.SQLException;

public class Driver {
    void run() throws SQLException {
        Database db=new Database();
        Credentials crds;
        Banking banking=new Banking();
        do{
            crds= db.checkUser();
            if (crds!=null) {
                banking.setCrds(crds);
                banking.transact();
                db.updateUser(crds);
                System.out.println("!!Transaction Successful!!");
                System.exit(0);
            }
            System.out.println("Wrong input!!");
        }while (true);
    }
    public static void main(String[] args) throws SQLException {
        System.out.println("!!ATM IS IN USE!!");
        Driver ob= new Driver();
        ob.run();
    }
}
