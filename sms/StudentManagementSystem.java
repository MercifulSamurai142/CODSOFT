package sms;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    void add() throws SQLException {
        String roll,name,grade;
        Scanner sc=new Scanner(System.in);
        DatabaseUpdate dbup=new DatabaseUpdate();
        Student student = new Student();

        //roll input
        do{
            System.out.print("Enter roll : ");
            roll=sc.next();
            sc.nextLine();
            if(roll.isEmpty()){
                System.out.println("!!Value cannot be empty!!");
            }
        }while(roll.isEmpty());
        student.setRoll(roll);

        //name input
        do{
            System.out.print("Enter name : ");
            name=sc.nextLine();
            //sc.nextLine();
            if(name.isEmpty()){
                System.out.println("!!Value annot be empty!!");
            } else if (name.length()>16) {
                System.out.println("Name should be 16 characters");
            }
        }while(name.isEmpty());
        student.setName(name);

        //grade input
        do{
            System.out.print("Enter grade : ");
            grade=sc.next();
            sc.nextLine();
            if(grade.isEmpty()){
                System.out.println("!!Value annot be empty!!");
            }
        }while(grade.isEmpty());
        student.setGrade(grade);

        //gender input
        System.out.print("Enter gender : ");
        student.setGender(sc.next());
        sc.nextLine();

        //address input
        System.out.print("Enter address : ");
        student.setAddress(sc.nextLine());

        //score input
        System.out.print("Enter score : ");
        student.setScore(sc.nextInt());
        sc.nextLine();

        int response=dbup.addUpdate(student);
        if (response == 1) {
            System.out.println("! ! Successfully added ! !");
        }
        else {
            System.out.println("! ! Could not add ! !");
        }
    }


    void edit() throws SQLException {
        System.out.print("Enter roll of student : ");
        Scanner sc=new Scanner(System.in);
        DatabaseUpdate dbup=new DatabaseUpdate();
        String roll=sc.next();
        Student student = dbup.search(roll);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Enter value for the field which needs change");

        String input="";
        sc.nextLine();
        //change name
        System.out.print("Name ["+student.getName()+"]:");
        input=sc.nextLine();

        if (!(input.isEmpty())) {
            student.setName(input);
        }

        //change gender
        System.out.print("Gender ["+student.getGender()+"]:");
        input=sc.nextLine();
        if (!(input.isEmpty())) {
            student.setGender(input);
        }



        //change grade
        System.out.print("Grade ["+student.getGrade()+"]:");
        input=sc.nextLine();
        if (!(input.isEmpty())) {
            student.setGrade(input);
        }

        //change score
        System.out.print("Score ["+student.getScore()+"]:");
        input=sc.nextLine();
        if (!(input.isEmpty())) {
            student.setScore(Integer.parseInt(input));
        }

        //change address
        System.out.print("Address ["+student.getAddress()+"]:");
        input=sc.nextLine();
        if (!(input.isEmpty())) {
            student.setAddress(input);
        }

        int response = dbup.editUpdate(student);
        if (response == 1) {
            System.out.println("! ! Successfully edited ! !");
        }
        else {
            System.out.println("! ! Could not edit ! !");
        }
    }
    void remove() throws SQLException {
        Scanner sc=new Scanner(System.in);
        DatabaseUpdate dbup=new DatabaseUpdate();
        System.out.println("Enter roll of student");
        String roll=sc.next();
        Student student = dbup.search(roll);
        int response=dbup.removeUpdate(student);
        if (response == 1) {
            System.out.println("! ! Successfully removed ! !");
        }
        else {
            System.out.println("! ! Could not remove ! !");
        }

    }

    void search() throws SQLException {
        System.out.print("Enter roll of student : ");
        Scanner sc=new Scanner(System.in);
        DatabaseUpdate dbup=new DatabaseUpdate();
        String roll=sc.next();
        Student student = dbup.search(roll);
        if (student == null) {
            System.out.println("Student not found");
        }
    }
    void display() throws SQLException {
        DatabaseUpdate dbup=new DatabaseUpdate();
        List<Student> studentList=dbup.displayUpdate();


        for (Student i:studentList) {
            String namespace=" ";
            namespace=namespace.repeat(16-i.getName().length());
            System.out.println("Roll : "+i.getRoll()+"\tName : "+i.getName()+namespace+"  Gender : "+i.getGender()+"\t\tGrade : "+i.getGrade()+"\t\tScore : "+i.getScore()+"\t\tAddress : "+i.getAddress()+" ");

        }

    }


}
