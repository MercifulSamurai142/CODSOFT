package sms;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementSystemDriver {

    public static void main(String[] args) throws SQLException {
        System.out.println("!! STUDENT MANAGEMENT SYSTEM !!");
        StudentManagementSystem sms=new StudentManagementSystem();
        int ch;
        Scanner sc=new Scanner(System.in);

        do {
            System.out.println("\nPress 1 to add");
            System.out.println("Press 2 to edit");
            System.out.println("Press 3 to remove");
            System.out.println("Press 4 to search");
            System.out.println("Press 5 to display");
            System.out.println("Press 6 to exit");
            System.out.print("Enter choice : ");
            ch=sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> sms.add();
                case 2 -> sms.edit();
                case 3 -> sms.remove();
                case 4 -> sms.search();
                case 5 -> sms.display();
                case 6 -> System.exit(0);
                default -> System.out.println("!!Wrong choice!!");
            }
        }while (true);
    }
}
