package EmailGen;

import java.util.Scanner;

public class WarehouseTerminal {

    public static void main(String[] args) {

        // variables to control menu
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean exit = false;

        // Create a warehouse on launch
        StockLocation warehouse = new StockLocation("Warehouse");

        // menu loop until exit
        do {

            System.out.println("Stock management System. Please select an option:");
            System.out.println("1. Add product");
            System.out.println("2. Process sale");
            System.out.println("3. Stock count");
            System.out.println("4. Print transaction log");
            System.out.println("4. Exit");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Sorry, couldn't understand you!");
            }

            if (choice > 0 && choice< 6){
                switch (choice) {
                    case 1:
                        String name;
                        int prodID;
                        int quantity;
                        double price;

                        System.out.println("Enter new product name:");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Enter product ID:");
                        prodID = sc.nextInt();
                        System.out.println("Enter opening stock:");
                        quantity = sc.nextInt();
                        System.out.println("Enter price per unit:");
                        price = sc.nextDouble();
                        Product newProd = new Product(name, prodID, quantity, price);
                        warehouse.addProduct(newProd, quantity);
                        break;
                    case 2:
                        System.out.println("Enter product ID:");
                        prodID = sc.nextInt();
                        System.out.println("Enter sale quantity:");
                        quantity = sc.nextInt();
                        warehouse.processSale(prodID, quantity);
                        break;
                    case 3:
                        System.out.println("Enter product ID:");
                        prodID = sc.nextInt();
                        System.out.println("Enter count:");
                        quantity = sc.nextInt();
                        warehouse.stockCount(prodID, quantity);
                        break;
                    case 4:
                        System.out.println("Enter product ID:");
                        prodID = sc.nextInt();
                        warehouse.printTransactionLog(prodID);
                        break;

                    case 5:
                        exit = true;
                        break;

                }
            } else System.out.println("Invalid selection");
        } while (!exit);
    }
}
