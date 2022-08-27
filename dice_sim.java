import java.util.InputMismatchException;
import java.util.Scanner;

public class dice_sim {
    static Scanner theScanner = new Scanner(System.in);
    public static int getMenuOption() {
		int choice = 0;
		// While statement will repeat until it receives a valid selection
		do {
			System.out.print("\nPlease enter an integer to choose how many dice you would like to roll (1-5) or choose 6 to end the program.\n");
			try{
            choice = theScanner.nextInt();
            } catch (InputMismatchException e1) {
                theScanner = new Scanner(System.in);
            
            }

			// If statement to break the loop if a valid selection is made
                if (choice >= 1 && choice <= 5) {
				break;
			    } else if (choice < 1 || choice > 6) {
				// Prints if a invalid selection is made
				System.out.print("\nSorry, please make a valid selection.\n");
			    }
		} while (choice != 6);
		return choice;
	}

    public static void main(String[] args) {
        int dice1;
        int dice2;
        int dice3;
        int dice4;
        int dice5;
        int total;

        int choice;
        while(true) {
			choice = getMenuOption();
			// Switch case is used to choose the proper method to call in order to perform the correct operation
			switch(choice) {
				// Case 1 will roll 1 die
			case 1:
            dice1=(int)(Math.random()*6+1);
                System.out.printf("You rolled a(n) %d\n", dice1);
				break;
				// Case 2 will roll 2 dice
			case 2:
            dice1=(int)(Math.random()*6+1);
            dice2=(int)(Math.random()*6+1);
            total = dice1 + dice2;
                System.out.printf("You rolled a(n) %d and %d totaling %d\n", dice1, dice2, total); 
				break;
				// Case 3 will roll 3 dice
			case 3: 
            dice1=(int)(Math.random()*6+1);
            dice2=(int)(Math.random()*6+1);
            dice3=(int)(Math.random()*6+1);
            total = dice1 + dice2 + dice3;
                System.out.printf("You rolled a(n) %d, %d, and %d totaling %d\n", dice1, dice2, dice3, total);
				break;
				// Case 4 will roll 4 dice
			case 4:
            dice1=(int)(Math.random()*6+1);
            dice2=(int)(Math.random()*6+1);
            dice3=(int)(Math.random()*6+1);
            dice4=(int)(Math.random()*6+1);
            total = dice1 + dice2 + dice3 + dice4;
                System.out.printf("You rolled a(n) %d, %d, %d, and %d totaling %d\n", dice1, dice2, dice3, dice4, total);
				break;
				// Case 5 will roll 5 dice
			case 5:
            dice1=(int)(Math.random()*6+1);
            dice2=(int)(Math.random()*6+1);
            dice3=(int)(Math.random()*6+1);
            dice4=(int)(Math.random()*6+1);
            dice5=(int)(Math.random()*6+1);
            total = dice1 + dice2 + dice3 + dice4 + dice5;
                System.out.printf("You rolled a(n) %d, %d, %d, %d, and %d\n", dice1, dice2, dice3, dice4, dice5, total); 
				break;
				// Case 6 will simply exit the program
			case 6: System.out.println("Goodbye!");
			return;
			}
        }
    }
}  
