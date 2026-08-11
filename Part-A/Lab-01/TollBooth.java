
/*(a) Define a record Vehicle(String number, String type). 
(b) In main, keep a running toll total and three counters (bike, car, truck). 
(c) Loop until the user types “done” for the number: build a Vehicle, use a switch 
expression on its type for the toll (bike→20, car→50, truck→150), add to the total, 
and increment that type’s counter. 
import java.util.Scanner;*/

public class TollBooth {

    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalToll = 0;
        int bikeCount = 0, carCount = 0, truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number (or 'done' to stop): ");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) break;

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> {
                    System.out.println("Invalid type. Skipped.");
                    yield 0;
                }
            };

            totalToll += toll;
            switch (type) {
                case "bike" -> bikeCount++;
                case "car" -> carCount++;
                case "truck" -> truckCount++;
            }
        }

        System.out.println("Total toll: " + totalToll);

        String mostFrequent = "bike";
        int maxCount = bikeCount;
        if (carCount > maxCount) {
             mostFrequent = "car"; maxCount = carCount; 
            }
        if (truckCount > maxCount) { 
            mostFrequent = "truck"; 
        }

        System.out.println("Most frequent: " + mostFrequent);
        sc.close();
    }
}
