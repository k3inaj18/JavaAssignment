import java.util.Scanner;

public class TransportationCostCalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            
            while (running) {
                System.out.println("\n--- Transportation Cost Calculator ---");
                System.out.println("1. Calculate Daily Transport Cost");
                System.out.println("2. Calculate Weekly Transport Cost");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        calculateDailyCost(scanner);
                        break;
                    case 2:
                        calculateWeeklyCost(scanner);
                        break;
                    case 3:
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static void calculateDailyCost(Scanner scanner) {
        System.out.println("\n--- Calculate Daily Transport Cost ---");
        System.out.print("Enter the distance traveled (in km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter the transport type (1 = Public Transport, 2 = Private Car): ");
        int transportType = scanner.nextInt();

        double cost = 0;

        if (transportType == 1) {
            System.out.print("Enter fare per kilometer: ");
            double farePerKm = scanner.nextDouble();
            cost = distance * farePerKm;

        } else if (transportType == 2) {
            System.out.print("Enter fuel price per liter: ");
            double fuelPrice = scanner.nextDouble();
            System.out.print("Enter fuel efficiency (km per liter): ");
            double fuelEfficiency = scanner.nextDouble();
            cost = distance * (fuelPrice / fuelEfficiency);

        } else {
            System.out.println("Invalid transport type!");
            return;
        }

        System.out.printf("Daily Transport Cost: $%.2f\n", cost);
    }

    public static void calculateWeeklyCost(Scanner scanner) {
        System.out.print("\nEnter the number of days you commute in a week: ");
        int days = scanner.nextInt();
        calculateDailyCost(scanner);
        System.out.println("Multiply the daily cost by " + days + " for the total weekly cost.");
    }
}
