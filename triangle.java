import java.util.Scanner;
import java.util.Arrays;
public class triangle {
    static Scanner theScanner  = new Scanner(System.in);
    static int input[] = new int[3];

    public static void main (String args[]){
        while (true){
            System.out.print("Please enter three positive integers to make a triangle: ");
                input[0]=theScanner.nextInt();
                input[1]=theScanner.nextInt();
                input[2]=theScanner.nextInt();
        
            if (input[0]<= 0|| input[1]<= 0|| input[2]<= 0) {
                System.out.print("\nInvalid input");
            }
            Arrays.sort(input);
            /*for (int i=0; i<3;i++){
                System.out.print(input[i]);
            }*/
        
            if (input[0]+input[1]<= input[2]) {
                System.out.print("\nInvalid triangle");
            } /*else {
                System.out.print("Valid triangle");
            }*/

            else if (input[0] == input[1] && input[2] == input[0]){
                System.out.print("\nTriangle is equilateral");

            } else if (input[0] == input[1] || input[2] == input[0] || input[2] == input[1]) {
                System.out.print("\nTriangle is isosceles");

            } else { 
                System.out.print("\nTriangle is scalene");

            }
        }
    }
}

