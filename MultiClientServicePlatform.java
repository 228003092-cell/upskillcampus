//MULTICLIENT SERVICE PLATFORM

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Merchant class
class Merchant {
    String merchantName;
    String category;
    String serviceName;
    double price;

    Merchant(String merchantName, String category, String serviceName, double price) {
        this.merchantName = merchantName;
        this.category = category;
        this.serviceName = serviceName;
        this.price = price;
    }

    void displayService() {
        System.out.println("Merchant Name : " + merchantName);
        System.out.println("Category      : " + category);
        System.out.println("Service       : " + serviceName);
        System.out.println("Price         : Rs. " + price);
        System.out.println("--------------------------------");
    }
}

// Customer class
class Customer {
    String customerName;

    Customer(String customerName) {
        this.customerName = customerName;
    }

    void buyService(Merchant merchant) {
        System.out.println("\n Order Successful!");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Merchant      : " + merchant.merchantName);
        System.out.println("Service       : " + merchant.serviceName);
        System.out.println("Amount Paid   : Rs. " + merchant.price);
        System.out.println("Payment Status: SUCCESS");
        System.out.println("Email receipt sent to customer and merchant.");
    }
}

// Main class
public class MultiClientServicePlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating merchants
        Merchant m1 = new Merchant("HomeFix", "Home Services", "Plumbing", 500);
        Merchant m2 = new Merchant("GlowBeauty", "Beauty", "Facial", 1200);
        Merchant m3 = new Merchant("PetCare", "Pet Services", "Pet Grooming", 800);

        List<Merchant> merchants = new ArrayList<>();
        merchants.add(m1);
        merchants.add(m2);
        merchants.add(m3);

        System.out.println("WELCOME TO MULTI-CLIENT SERVICE PLATFORM");
        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();

        Customer customer = new Customer(cname);

        System.out.println("\nAvailable Services:");
        for (int i = 0; i < merchants.size(); i++) {
            System.out.println((i + 1) + ".");
            merchants.get(i).displayService();
        }

        System.out.print("Select service number to purchase: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= merchants.size()) {
            customer.buyService(merchants.get(choice - 1));
        } else {
            System.out.println("Invalid choice!");
        }

        System.out.println("\n Thank you for using the platform.");
        sc.close();
    }
}