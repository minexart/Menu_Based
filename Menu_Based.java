import java.util.ArrayList;
import java.util.Scanner;

class Parcel {
    String name;
    double weight;
    double distance;

    Parcel(String name, double weight, double distance) {
        this.name = name;
        this.weight = weight;
        this.distance = distance;
    }

    double calculateCharge() {
        return weight * distance * 0.5;
    }
}

public class Menu_Based {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Parcel> parcels = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== COURIER SYSTEM MENU =====");
            System.out.println("1. Add Parcel");
            System.out.println("2. View Parcels");
            System.out.println("3. Calculate Charges");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter customer name:");
                    String name = sc.nextLine();

                    System.out.print("Enter parcel weight (kg): ");
                    double weight = sc.nextDouble();

                    System.out.print("Enter distance (km): ");
                    double distance = sc.nextDouble();

                    parcels.add(new Parcel(name, weight, distance));
                    System.out.println("Parcel added successfully!");
                    break;

                case 2:
                    if (parcels.isEmpty()) {
                        System.out.println("No parcels found.");
                    } else {
                        System.out.println("\n--- Parcel List ---");
                        for (int i = 0; i < parcels.size(); i++) {
                            Parcel p = parcels.get(i);
                            System.out.println((i + 1) + ". " + p.name +
                                    " | Weight: " + p.weight +
                                    "kg | Distance: " + p.distance + "km");
                        }
                    }
                    break;

                case 3:
                    if (parcels.isEmpty()) {
                        System.out.println("No parcels to calculate.");
                    } else {
                        System.out.println("\n--- Charges ---");
                        for (Parcel p : parcels) {
                            System.out.println(p.name + " : RM " + p.calculateCharge());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }



        }while (choice !=4);
    }

}
