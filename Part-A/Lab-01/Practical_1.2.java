import java.util.Scanner;

class Vehicle {
    String number;
    String type;

    Vehicle(String number, String type) {

        this.number = number;
        this.type = type;
        
    }

    String getNumber() { 

        return number;

     }
    String getType() { 

        return type;

     }
}

class TollBooth {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0, carCount = 0, truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number (or 'done' to exit): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {

                break;

            }

            System.out.print("Enter vehicle type (bike/car/truck): ");

            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);
            int toll = 0;

            switch (v.getType()) {

                case "bike":
                    toll = 20;
                    bikeCount++;
                    break;

                case "car":
                    toll = 50;
                    carCount++;
                    break;

                case "truck":
                    toll = 150;
                    truckCount++;
                    break;

                default:
                    System.out.println("Unknown vehicle type!");
                    break;
                    
            }

            totalToll += toll;
        }

        sc.close();

        System.out.println("Total toll: " + totalToll);

        if (carCount >= bikeCount && carCount >= truckCount)

            System.out.println("Most frequent: car");

        else if (bikeCount >= carCount && bikeCount >= truckCount)

            System.out.println("Most frequent: bike");
            
        else

            System.out.println("Most frequent: truck");
    }
}
