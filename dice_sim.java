import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class dice_sim {
    static int count1,count2,count3,count4,count5,count6,i,numDice,dice = 0;
    static Scanner theScanner = new Scanner(System.in);
    static Scanner theScanner2 = new Scanner(System.in);
    public static int getMenuOption() {
		int choice = 0;
		// While statement will repeat until it receives a valid selection
		do {
			System.out.print("\nPlease enter an integer to choose how many dice you would like to roll (1-5) or choose 6 to end the program. Choice 7 is for testing.\n");
			try{
            choice = theScanner.nextInt();
            } catch (InputMismatchException e1) {
                theScanner = new Scanner(System.in);
            }

			// If statement to break the loop if a valid selection is made
                if (choice >= 1 && choice <= 7) {
				break;
			    } else if (choice < 1 || choice > 7) {
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
                System.out.printf("You rolled a(n) %d, %d, %d, %d, and %d totaling %d\n", dice1, dice2, dice3, dice4, dice5, total); 
				break;
				// Case 6 will simply exit the program
			case 6: System.out.println("Goodbye!");
			    return;
            case 7: System.out.print("How many dice do you want to roll?");  
            numDice = theScanner2.nextInt();
    
            do {
                dice = (int)(Math.random()*6+1);
                if (dice == 1){
                    ++count1;
                }
                else if(dice == 2){
                    ++count2;
                }
                else if(dice == 3){
                    ++count3;
                }
                else if(dice == 4){
                    ++count4;
                }
                else if(dice == 5){
                    ++count5;
                }
                else if(dice == 6){
                    ++count6;
                }
    
                i++;
            }while (i<numDice);

            int dev = numDice/6;
            int dif1 = count1-dev;
            int dif2 = count2-dev;
            int dif3 = count3-dev;
            int dif4 = count4-dev;
            int dif5 = count5-dev;
            int dif6 = count6-dev;

            double perc1 = 100 * dif1/(double)dev;
            double perc2 = 100 * dif2/(double)dev;
            double perc3 = 100 * dif3/(double)dev;
            double perc4 = 100 * dif4/(double)dev;
            double perc5 = 100 * dif5/(double)dev;
            double perc6 = 100 * dif6/(double)dev;

    
            System.out.printf("\n1s Rolled: %d  ("+(dif1 > 0 ? "+" : "")+"%d)  [%.2f%%]\n2s Rolled: %d  ("+(dif2> 0 ? "+" : "")+"%d)  [%.2f%%]\n3s Rolled: %d  ("+(dif3 > 0 ? "+" : "")+"%d)  [%.2f%%]"
                + "\n4s Rolled: %d  ("+(dif4 > 0 ? "+" : "")+"%d)  [%.2f%%]\n5s Rolled: %d  ("+(dif5 > 0 ? "+" : "")+"%d)  [%.2f%%]\n6s Rolled: %d  ("+(dif6 > 0 ? "+" : "")+"%d)  [%.2f%%]\n"
                ,count1,dif1,perc1,count2,dif2,perc2,count3,dif3,perc3,count4,dif4,perc4,count5,dif5,perc5,count6,dif6,perc6);

                break;
			}
        }
    }
}  
