import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class dice_sim {
    static int dice,i,j,numDice,numRoll,sum = 0;
    static int freq[] = new int [6];
    static int sumFreq[] = new int [31];
    static int rolls[] = new int [5];
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
        int total=0;
        int choice;
        while(true) {
			choice = getMenuOption();
			// Switch case is used to choose the proper method to call in order to perform the correct operation
			switch(choice) {
				// Case 1 will roll 1 die
			case 1:
            dice=(int)(Math.random()*6+1);
                System.out.printf("You rolled a(n) %d\n", dice);
				break;
				// Case 2 will roll 2 dice
			case 2: i=0;
            total=0;
            do {
                dice = (int)(Math.random()*6+1);
                total+=dice;
                rolls[i]=dice;
                i++;
            }while (i<choice);
                System.out.printf("You rolled a(n) %d and %d totaling %d\n", rolls[0], rolls[1], total); 
				break;
				// Case 3 will roll 3 dice
			case 3: i=0;
            total=0;
            do {
                dice = (int)(Math.random()*6+1);
                total+=dice;
                rolls[i]=dice;
                i++;
            }while (i<choice);
                System.out.printf("You rolled a(n) %d, %d, and %d totaling %d\n", rolls[0], rolls[1], rolls[2], total);
				break;
				// Case 4 will roll 4 dice
			case 4: i=0;
            total=0;
            do {
                dice = (int)(Math.random()*6+1);
                total+=dice;
                rolls[i]=dice;
                i++;
            }while (i<choice);
                System.out.printf("You rolled a(n) %d, %d, %d, and %d totaling %d\n", rolls[0], rolls[1], rolls[2], rolls[3], total);
				break;
				// Case 5 will roll 5 dice
			case 5: i=0;
            total=0;
            do {
                dice = (int)(Math.random()*6+1);
                total+=dice;
                rolls[i]=dice;
                i++;
            }while (i<choice);
                System.out.printf("You rolled a(n) %d, %d, %d, %d, and %d totaling %d\n", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], total); 
				break;
				// Case 6 will simply exit the program
			case 6: System.out.println("Goodbye!");
			    return;
            case 7: System.out.print("How many dice do you want to roll?");  
            numRoll = theScanner2.nextInt();
            
            do {
                dice = (int)(Math.random()*6+1);
                if (dice == 1){
                    ++freq[0];
                }
                else if(dice == 2){
                    ++freq[1];
                }
                else if(dice == 3){
                    ++freq[2];
                }
                else if(dice == 4){
                    ++freq[3];
                }
                else if(dice == 5){
                    ++freq[4];
                }
                else if(dice == 6){
                    ++freq[5];
                }
    
                i++;
            }while (i<numRoll);

            int dev = numRoll/6;
            int dif1 = freq[0]-dev;
            int dif2 = freq[1]-dev;
            int dif3 = freq[2]-dev;
            int dif4 = freq[3]-dev;
            int dif5 = freq[4]-dev;
            int dif6 = freq[5]-dev;

            double perc1 = 100 * dif1/(double)dev;
            double perc2 = 100 * dif2/(double)dev;
            double perc3 = 100 * dif3/(double)dev;
            double perc4 = 100 * dif4/(double)dev;
            double perc5 = 100 * dif5/(double)dev;
            double perc6 = 100 * dif6/(double)dev;

    
            System.out.printf("\n1s Rolled: %d  ("+(dif1 > 0 ? "+" : "")+"%d)  [%.2f%%]\n2s Rolled: %d  ("+(dif2> 0 ? "+" : "")+"%d)  [%.2f%%]\n3s Rolled: %d  ("+(dif3 > 0 ? "+" : "")+"%d)  [%.2f%%]"
                + "\n4s Rolled: %d  ("+(dif4 > 0 ? "+" : "")+"%d)  [%.2f%%]\n5s Rolled: %d  ("+(dif5 > 0 ? "+" : "")+"%d)  [%.2f%%]\n6s Rolled: %d  ("+(dif6 > 0 ? "+" : "")+"%d)  [%.2f%%]\n"
                ,freq[0],dif1,perc1,freq[1],dif2,perc2,freq[2],dif3,perc3,freq[3],dif4,perc4,freq[4],dif5,perc5,freq[5],dif6,perc6);

            dice = 0;
            i = 0;
            numRoll = 0;

            theScanner2 = new Scanner(System.in);
            System.out.print("How many dice do you want to roll?");
            numRoll = theScanner2.nextInt();
            System.out.print("How many dice do you want to roll at once?");
            numDice = theScanner2.nextInt();

            do {
                while (j<numDice){
                    dice = (int)(Math.random()*6+1);
                    sum+=dice;
                    j++;
                    if (j == numDice){
                        ++sumFreq[sum];
                        sum = 0;
                    }
                }
                ++i;
                j = 0;
            }while (i<numRoll);

            if(numDice == 2){
                for (int k = 2; k <= 12; k++){
                    System.out.println("Sums of "+k+" rolled -> "+sumFreq[k]);
                }
            } else if (numDice == 3){
                for (int k = 3; k <= 18; k++){
                    System.out.println("Sums of "+k+" rolled -> "+sumFreq[k]);
                }
            } else if (numDice == 4){
                for (int k = 4; k <= 24; k++){
                    System.out.println("Sums of "+i+" rolled -> "+sumFreq[k]);
                }
            } else if (numDice == 5){
                for (int k = 5; k <= 30; k++){
                    System.out.println("Sums of "+k+" rolled -> "+sumFreq[k]);
                }

            }
            
                break;
			}
        }
    }
}  
