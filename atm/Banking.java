package atm;

import java.util.Scanner;

public class Banking {
    Credentials crds=null;

    public void setCrds(Credentials crds) {
        this.crds = crds;
    }
    void withdraw(double amount){
        if(amount < 0){
            System.out.println("!!!!NEGATIVE AMOUNT CANNOT BE USED!!!!");
            return;
        }
        if(amount > crds.getBalance()){
            System.out.println("!!!!BALANCE TOO LOW WITH WITHDRAW!!!!");
            return;
        }
        amount=crds.getBalance()-amount;
        crds.setBalance(amount);
    }
    void deposit(double amount){
        if(amount < 0){
            System.out.println("!!!!NEGATIVE AMOUNT CANNOT BE USED!!!!");
            return;
        }
        amount=crds.getBalance()+amount;
        crds.setBalance(amount);
    }
    double checkBalance(){return crds.getBalance();}

     void transact(){
         Scanner sc= new Scanner(System.in);
         System.out.println("\nPress 1 to withdraw\nPress 2 to deposit\nPress 3 to checkBalance\n");
         int ch;
         System.out.print("Enter choice : ");
         ch=sc.nextInt();
         double amount;
         switch (ch) {
             case 1 -> {
                 System.out.print("Enter amount to withdraw : ");
                 amount = sc.nextDouble();
                 withdraw(amount);
             }
             case 2 -> {
                 System.out.print("Enter amount to deposit : ");
                 amount = sc.nextDouble();
                 deposit(amount);
             }
             case 3 -> {
                 System.out.println(checkBalance());
                 System.exit(0);
             }
             default -> {
                 System.out.println("!!WRONG CHOICE!!");
                 System.exit(0);
             }
         }

     }

}
