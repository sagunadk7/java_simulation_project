import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        store.productList = new ArrayList<>(); 

        String[] sampleNames = {
            "Laptop", "Mouse", "Keyboard", "Monitor", "USB Cable",
            "Webcam", "Headset", "Speaker", "Hard Drive", "Printer"
        };

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int id = i + 1;
            String name = sampleNames[i];
            double price = 50 + rand.nextInt(450); 
            int stock = 1 + rand.nextInt(20);      
            Product p = new Product(id, name, price, stock);
            store.productList.add(p);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerName);
        store.customerList.add(customer);

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== STORE MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Place Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. Restock Product");
            System.out.println("5. Show Low Stock Products");
            System.out.println("6. Show Store Statistics");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : store.productList) {
                        System.out.println("Product ID: " + p.getId() + ". " + p.getName() +
                                " - $" + p.getPrice() +
                                " | Stock: " + p.getQuantityInStock());
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to order: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    if (store.placeOrder(customer, pid, qty)) {
                        System.out.println("Order placed successfully!");
                    } else {
                        System.out.println("Order failed. Not enough stock or invalid product.");
                    }
                    break;

                case 3:
                    System.out.print("Enter order ID to cancel: ");
                    int oid = sc.nextInt();

                    if (store.cancelOrder(oid)) {
                        System.out.println("Order canceled successfully!");
                    } else {
                        System.out.println("Cancel failed. Order ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter product ID to restock: ");
                    int rid = sc.nextInt();
                    System.out.print("Enter quantity to add: ");
                    int rqty = sc.nextInt();

                    if (store.restockProduct(rid, rqty)) {
                        System.out.println("Product restocked successfully!");
                    } else {
                        System.out.println("Restock failed. Product ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("\nLow Stock Products:");
                    store.showLowStockProducts();
                    break;

                case 6:
                    System.out.println("\nStore Statistics:");
                    store.showStatistcs();
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}

