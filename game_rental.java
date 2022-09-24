import java.util.Scanner;
import java.lang.NumberFormatException;

public class game_rental {
    static String checkDate, dob, gameRate;
    static int dayCInt, monthCInt, yearCInt, dayDInt, monthDInt, yearDInt;
    static Scanner theScanner = new Scanner(System.in);
    static boolean validDate = false;
    static String ratings[] = new String [6];
    static String checkParts[], dobParts[] = new String [3];
    static int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static int[] calcAge (int dayCInt, int monthCInt, int yearCInt, int dayDInt, int monthDInt, int yearDInt) {
        if (dayDInt > dayCInt) {
            dayCInt = dayCInt + month[dayDInt - 1];
            monthCInt = monthCInt - 1;
        }
        if (monthDInt > monthCInt) {
            yearCInt = yearCInt - 1;
            monthCInt = monthCInt + 12;
        }
        int calcDay = dayCInt - dayDInt;
        int calcMonth= monthCInt - monthDInt;
        int calcYear = yearCInt - yearDInt;
        int[] ageArray = {calcDay, calcMonth, calcYear};
        return ageArray;
    }

    public static void main (String args[]){
        do{
            System.out.print("Please enter checkout date (MM/DD/YYYY): ");
            checkDate = theScanner.nextLine();
            System.out.print("Please enter date of birth (MM/DD/YYYY): ");
            dob = theScanner.nextLine();
            System.out.print("Please enter game rating (EC,E,E10,T,M,AO): ");
            gameRate = theScanner.nextLine();

            // This try catch make sure that only integers are entered into the date requests
            try{
                String [] checkParts = checkDate.split("/");
                int dayCInt = Integer.parseInt(checkParts[1]);
                int monthCInt = Integer.parseInt(checkParts[0]);
                int yearCInt = Integer.parseInt(checkParts[2]);

                String [] dobParts = dob.split("/");
                int dayDInt = Integer.parseInt(dobParts[1]);
                int monthDInt = Integer.parseInt(dobParts[0]);
                int yearDInt = Integer.parseInt(dobParts[2]);
                System.out.printf("\nCheckout: %d,%d,%d (day,month,year)\nDOB: %d,%d,%d (day,month,year)\nGame Rating: %s",dayCInt,monthCInt,yearCInt,dayDInt,monthDInt,yearDInt,gameRate);

            } catch (NumberFormatException e1){
                System.out.print("\nPlease enter dates with the proper format (MM/DD/YYYY)");
                theScanner = new Scanner(System.in);
            }

            // This section checks the game rating that was entered to be sure it is valid
            String ratings[] = {"EC", "E", "E10", "T", "M", "AO"};
            if (!gameRate.equals(ratings[0]) && !gameRate.equals(ratings[1]) && !gameRate.equals(ratings[2]) && !gameRate.equals(ratings[3]) && !gameRate.equals(ratings[4]) && !gameRate.equals(ratings[5])) {
                System.out.print("\nPlease enter valid game rating (EC,E,E10,T,M,AO)\n");

            } else if ( monthDInt == 4 || monthDInt == 6 || monthDInt == 9 || monthDInt == 11 || monthCInt == 4 || monthCInt == 6 || monthCInt == 9 || monthCInt == 11 && dayCInt > 30 || dayDInt > 30) {
                System.out.print("\nPlease enter a valid day for the month entered\n");

            } else if (monthDInt == 1 || monthDInt == 3 || monthDInt == 5 || monthDInt == 7 || monthDInt == 8 || monthDInt == 10 || monthDInt == 12 || monthCInt == 1 || monthCInt == 3 || monthCInt == 5 ||
            monthCInt == 7 || monthCInt == 8 || monthCInt == 10 || monthCInt == 12 && dayDInt > 31 || dayCInt > 31) {
                System.out.print("\nPlease enter a valid day for the month entered\n");

            } else if (monthDInt == 2 || monthCInt == 2 && dayDInt > 29 || dayCInt > 29) {
                System.out.print("\nPlease enter a valid day for the month entered\n");

            } else if (yearDInt > yearCInt) {
                System.out.print("\nPlease enter a valid year\n");

            } else if (yearDInt == yearCInt && monthDInt > monthCInt) {
                System.out.print("\nPlease enter a valid month for the year entered\n");

            } else if (yearDInt == yearCInt && monthDInt == monthCInt && dayDInt > dayCInt) {
                System.out.print("\nPlease enter a valid day for the month and year entered\n");

            } else if (monthDInt > 12 || monthCInt > 12) {
                System.out.print("\nPlease enter a valid month\n");

            } else if (yearDInt > 9999 || yearCInt > 9999) {
                System.out.print("\nPlease enter a valid year\n");

            } else {
                validDate = true;
            }
        } while(validDate == false);

        int ageFinal[] = calcAge(dayCInt, monthCInt, yearCInt, dayDInt, monthDInt, yearDInt);

        if (gameRate.equals(ratings[0])) {
            System.out.print("\nRental Allowed");

        } else if (gameRate.equals(ratings[1]) && ageFinal[0] >= 8 && ageFinal[1] >= 6 && ageFinal[2] >= 15){
            System.out.print("\nRental Allowed");

        } else if (gameRate.equals(ratings[2]) && ageFinal[0] >= 10) {
            System.out.print("\nRental Allowed");

        } else if (gameRate.equals(ratings[3]) && ageFinal[0] >= 13) {
            System.out.print("\nRental Allowed");

        } else if (gameRate.equals(ratings[4]) && ageFinal[0] >= 17) {
            System.out.print("\nRental Allowed");

        } else if (gameRate.equals(ratings[5]) && ageFinal[0] >= 18) {
            System.out.print("\nRental Allowed");

        } else {
            System.out.print("\nRental Denied");

        }
    }
}
