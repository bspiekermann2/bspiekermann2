import java.util.Scanner;

public class vend_mach {
    static Scanner inputScan = new Scanner(System.in);
    static Scanner ynScan = new Scanner(System.in);
    static Scanner configScan = new Scanner(System.in);
    static boolean cancel, done=false;
    static double finalPrice, depositDbl, fpDbl, change, maxPrice;
    static int fp, itemIndex, deposit, i, j=0;
    static String input, code, temp, answer;
    static String coinage = "";
    static String tempCode[] = new String [3];
    // Element 0-3 are $1 coins, quarters, dimes, and nickels respectively
    static int coins[] = { 99, 99, 99, 99 };
    static double price[] = {1.50, 2.00, 1.25, 0.75, 0.50, 2.25, 2.50, 1.25, 1.25, 1.25, 
                            1.25, 1.10, 1.10, 0.00, 1.10, 1.10, 0.00, 1.10, 1.10, 1.10,
                            1.10, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00,
                            2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00, 2.00,
                            1.25, 1.50, 1.25, 1.50, 1.25, 1.50, 1.25, 1.50, 1.25, 1.50};
    static String itemCode[] = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"
                            , "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"
                            , "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"
                            , "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"
                            , "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9"};

    public static double calcChange (double finalPrice, double depositDbl, double change) {
        double diff=0;
        change=0;
        finalPrice=price[itemIndex];
        fpDbl=finalPrice*100;
        fp=(int)fpDbl;
        diff=deposit-fp;
            if(cancel==false){
                do{
                    if (diff>=100&&coins[0]>0){
                        do{
                        diff = diff-100;
                        change=change+100;
                        coinage= coinage+"dollar coin ";
                        } while(diff>=100);
                    } else if(diff>=25&&coins[1]>=3){
                        do{
                        diff = diff-25;
                        change=change+25;
                        coinage= coinage+"quarter ";
                        } while(diff>=25);
                    } else if(diff>=10&&coins[2]>0){
                        do{
                        diff = diff-10;
                        change=change+10;
                        coinage= coinage+"dime ";
                        } while(diff>=10);
                    } else if(diff>=5&&coins[3]>=4){
                        do{
                        diff = diff-5;
                        change=change+5;
                        coinage= coinage+"nickel ";
                        } while(diff>=5);
                    } 
                } while(diff!=0); 
            } else if(cancel==true){
                do{
                    if (depositDbl>=100&&coins[0]>=0){
                        do{
                        depositDbl = depositDbl-100;
                        change=change+100;
                        coinage= coinage+"dollar coin ";
                        } while(depositDbl>=100);
                    } else if(depositDbl>=25&&coins[1]>=3){
                        do{
                        depositDbl = depositDbl-25;
                        change=change+25;
                        coinage= coinage+"quarter ";
                        } while(depositDbl>=25);
                    } else if(depositDbl>=10&&coins[2]>0){
                        do{
                        depositDbl = depositDbl-10;
                        change=change+10;
                        coinage= coinage+"dime ";
                        } while(depositDbl>=10);
                    } else if(depositDbl>=5&&coins[3]>=4){
                        do{
                        depositDbl = depositDbl-5;
                        change=change+5;
                        coinage= coinage+"nickel ";
                        } while(depositDbl>=5);
                    }
                } while(depositDbl!=0); 
            }
            change=change/100;
            System.out.printf("%.2f ( %s)",change, coinage);
        return change;
    }
    public static double[] setPrice (double[] price){
        for(int j = 0; j < price.length; j++) {
            price[i]=configScan.nextDouble();
            
        }
        return price;
    }
    public static int[] setCoin (int[] coins){
        for(int j = 0; j < coins.length; j++) {
            coins[i]=configScan.nextInt();
            
        }
        return coins;
    }                             
    public static void main (String args[]){
        System.out.print("Change prices? (y/n): ");
        answer=ynScan.nextLine();
        if(answer=="y"){
            System.out.print("\nSet price to 0.00 to signify the right crank of a two crank item\n");
            setPrice(price);
            setCoin(coins);
        } else if(answer=="n"){
        }

        for (i = 0; i < price.length; i++){
            if (price[i] > maxPrice){
            maxPrice = price[i];
            }
        }

        do{
            input = inputScan.nextLine();
            if(input.startsWith("d")==true){
                input = input.startsWith("d") ? input.substring(1) : input;
                if(Integer.parseInt(input)==5||Integer.parseInt(input)==10||Integer.parseInt(input)==25||Integer.parseInt(input)==100){
                    if(depositDbl<maxPrice){
                        deposit += Integer.parseInt(input);
                        depositDbl=deposit/100;
                    }
                } else {
                    System.out.print("INVALID CURRENCY\n");
                }
            } else if (input.startsWith("p")==true){
                for (i = 0; i < tempCode.length-1; i++){
                    temp = input.startsWith("p") ? input.substring(1) : input;
                            tempCode[i]= temp;
                    if(i<1){        
                        input = inputScan.nextLine();
                    }
                }
                tempCode[2]=tempCode[0]+tempCode[1];
                if(tempCode[0].matches("[A-E]")!= true || tempCode[1].matches("[0-9]")!= true){
                    System.out.print("INVALID CODE\n");
                } else if(tempCode[0].matches("[A-E]")== true || tempCode[1].matches("[0-9]")== true){
                    for(int j = 0; j < itemCode.length; j++) {
                        if(itemCode[j].matches(tempCode[2])) {
                               itemIndex = j;
                               break;
                        }
                    }
                    finalPrice=price[itemIndex];
                    if(depositDbl<finalPrice&&finalPrice>0){
                        System.out.printf("%.2f\n",finalPrice);
                    } else if(finalPrice==0) {
                        System.out.print("INVALID CODE\n");
                    } else if (depositDbl>=finalPrice&&finalPrice>0){
                        calcChange(change,depositDbl,finalPrice);
                        done=true;
                    }
                }
            } else if(input=="cancel"){
                cancel=true;
                calcChange(change,depositDbl,finalPrice);
                done=true;
            }
        } while (done==false);
    }
}
