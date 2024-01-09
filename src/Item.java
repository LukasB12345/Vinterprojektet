/* This is a SUPER-class */
public class Item {

    //Attributes
    protected String name;
    protected int quantity;
    protected double price;
    protected double cost;

    //Default constructor
    public Item() {
    }

    //Constructor
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cost = CalculateCost(price, quantity);
    }

    public double CalculateCost(double price, int quantity) {
        double cost = quantity * price;
        return cost;
    }

}
