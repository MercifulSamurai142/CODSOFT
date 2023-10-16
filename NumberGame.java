import java.io.IOException;
import java.util.Scanner;
public class NumberGame {
    int difficulty;
    Scanner sc=new Scanner(System.in);
    void rules(){
        System.out.println("""


                You get 5 choices to guess the number and earn points if you guess correctly
                There are 3 difficulties : EASY (10 points) MEDIUM (100 points) and HARD(1000 points)
                EASY gives a range of 10 numbers
                MEDIUM gives a range of 100 numbers
                HARD gives a range of 1000 numbers
                You also get bonus points on how quickly you can guess (Half the points of the difficulty for every remaining tries)

                """);
    }
    void menu(){//menu for the user
        int choice;
        do {//start or see rules
            System.out.println(
                    "Enter 1 to play the game\n" +
                    "Enter 2 to view the rules"
            );
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            if(choice==2)rules();
            else if (choice!=1) {
                System.out.println("!!!Wrong Input!!");
            }
        }while(choice!=1);

        do{//set difficulty
            System.out.println(
                    """
                            \nSelect Difficulty
                            Easy   : 1
                            Medium : 2
                            Hard   : 3
                            """

            );
            System.out.print("Enter choice : ");
            difficulty=sc.nextInt();
            if (difficulty<1 || difficulty>3) {
                System.out.println("!!!Wrong Input!!");
            }
        }while(difficulty<1 || difficulty>3);
    }

    int game(){
        difficulty=(int)Math.pow(10,difficulty);
        int low=(int)(Math.random()*101);
        int oe=(int)(Math.random()*2);
        if(oe==0)low+=(int)(Math.random()*101);
        int high=low+difficulty;
        int number=(int)(low+Math.random()*difficulty);
        int guess;
        for (int i = 4; i >= 0; i--) {
            System.out.println("\nThe range of your number is "+low+" to "+high);
            System.out.print("Guess the number : ");
            guess=sc.nextInt();
            if(guess==number){
                System.out.println("\nYou guessed correct!");
                return difficulty+i*(difficulty/2);
            } else if (guess<number) {
                System.out.println("\nYou guessed lower than the number");
                low=guess<low?low:guess;
            } else if (guess>number) {
                System.out.println("\nYou guessed higher than the number");
                high=guess>high?high:guess;
            }
        }
        System.out.println("!!GAME OVER!!\nThe number was "+number);
        return 0;
    }



    boolean choice(){//asks for more rounds

        do{
            System.out.print("Do you want to play again?(y/n):");
            char ch=sc.next().charAt(0);
            if(ch=='y' || ch=='Y')return true;
            else if (ch=='n' || ch=='N')return false;
            else System.out.println("Wrong Input");
        }while (true);
    }
    public static void main(String[] args)  {
        boolean flag=true;
        NumberGame ob =new NumberGame();
        int round=0,score=0,scored;
        do{
            round++;
            System.out.println("\nWelcome to round "+round+" of the Number Guessing Game\n");
            ob.menu();
            scored=ob.game();
            score=score+scored;
            System.out.println("You scored "+scored+" points");
            System.out.println("Your current score is "+score+" points");

            flag=ob.choice();

        }while(flag);
        System.out.println("\nYour final score is "+score);
        System.out.println("Thank you for Playing !!!");

    }
}
