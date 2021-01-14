package EmailGen;

import java.util.ArrayList;

public class Product {

    // Products have the following attributes
    private final String name;
    private final int prodID;
    private int stockCount;
    private final double retailPrice;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    // Product constructor
    public Product (String name, int prodID,int stockCount,double retailPrice) {
        this.name = name;
        this.prodID = prodID;
        this.stockCount = stockCount;
        this.retailPrice = retailPrice;
        this.transactions = new ArrayList<Transaction>();
    }

    // Getters and setters
    public int getProdID() {
        return this.prodID;
    }
    public String getName() {
        return this.name;
    }
    public int getStockLevel() {
        return this.stockCount;
    }
    public void setStock(int quantity) {
        this.stockCount = quantity;
    }

    // Sell Stock
    public void sellStock(int quantity) {
        this.stockCount -= quantity;
        Transaction newTrans = new Transaction("Sale", -quantity);
        this.transactions.add(newTrans);
    }
    //record Transaction
    public void recordTransaction(String type, int quantity) {
        Transaction newTrans = new Transaction(type,quantity);
        this.transactions.add(newTrans);
    }
    //print Transactions
    public void printTrans() {
        for(Transaction t : this.transactions) {
            System.out.println(t.getType() + " " + t.getQuantity() + " units " + t.getTimestamp());
        }

        }
    }
