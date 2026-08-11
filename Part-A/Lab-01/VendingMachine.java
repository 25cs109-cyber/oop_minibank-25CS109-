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
