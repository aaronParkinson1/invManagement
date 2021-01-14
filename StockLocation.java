package EmailGen;

import java.util.ArrayList;

public class StockLocation {

    // Stock locations will have a name and a list of products
    private final String name;
    private ArrayList<Product> products = new ArrayList<>();

    // constructor
    public StockLocation(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    // Add new product to stock location
    public void addProduct (Product newProd,int quantity) {

        boolean alreadyExists = false;

        for (Product p : this.products) {
            if (newProd.getProdID() == p.getProdID()) {
                alreadyExists = true;
                break;
            }
        } if (!alreadyExists) {
            this.products.add(newProd);
            System.out.printf("new product %s added to %s\n", newProd.getName(), this.name);
            newProd.recordTransaction("New product", quantity);
        } else System.out.println("Product ID already taken, please try again");
    }
    // process sale
    public void processSale (int prodID,int quantity) {
        boolean canOrder = false;
        for (Product p : this.products) {
            if (p.getProdID() == prodID && quantity <= p.getStockLevel()) {
                p.sellStock(quantity);
                System.out.println("Order placed");
                canOrder = true;
                break;
            }
        } if (!canOrder) {
            System.out.println("Unable to process order");
        }
    }
    // update stock count on product
    public void stockCount(int prodID, int quantity) {
        boolean foundIt = false;
        for (Product p : this.products) {
            if (prodID == p.getProdID()) {
                int stockMovement;
                stockMovement = quantity - p.getStockLevel();
                p.setStock(quantity);
                p.recordTransaction("Stock count", stockMovement);
                System.out.println("Stock count successful");
                foundIt = true;
                break;
            }
        } if (!foundIt) { System.out.println("Product not found"); }
    }
    // transaction log
    public void printTransactionLog (int prodID) {
        boolean foundIt = false;
        for (Product p : this.products) {
            if(p.getProdID() == prodID) {
                p.printTrans();
                foundIt = true;
                break;
            }
        } if(!foundIt) {System.out.println("Product not found"); }
    }


}
