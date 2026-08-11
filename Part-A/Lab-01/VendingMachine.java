
/*(a) Define an enum Coin with constants ONE, TWO, FIVE, TEN. 
(b) In main, set a snack price of 15 and a running total of 0; create a Scanner. 
(c) Loop: read a coin name, use a switch expression to convert the Coin to its value 
(ONE→1, TWO→2, FIVE→5, TEN→10), add it to the total, and print the total so 
far. 
(d) Stop the loop once the total reaches 15 or more. 
(e) Print the change to return (total − 15). */

import java.util.Scanner;

public class VendingMachine {

    enum Coin {

        ONE(1), TWO(2), FIVE(5), TEN(10);

        private final int value;
        Coin(int value) 
            {
             this.value = value; 

            }
        public int getValue() 
        { 
            return value; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int snackPrice = 15;
        int total = 0;

        System.out.println("Snack price: " + snackPrice);
        while (total < snackPrice) {
            System.out.print("Insert coin (ONE, TWO, FIVE, TEN): ");
            String input = sc.next().toUpperCase();

            try {
                Coin coin = Coin.valueOf(input);
                total += coin.getValue();
                System.out.println("Total so far: " + total);

            } 
            
            catch (IllegalArgumentException e) {
                System.out.println("Invalid coin. Try again.");
            }
        }

        int change = total - snackPrice;
        System.out.println("Paid. Change: " + change);
        sc.close();
    }
}
