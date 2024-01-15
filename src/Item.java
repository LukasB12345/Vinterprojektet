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
        this.name = name; //anger produktens namn
        this.price = price; //anger produktens pris
        this.quantity = quantity; //anger antalet (kvantiteten) av produkten man valt att köpa
    }

    public double CalculateCost(double price, int quantity) {
        return quantity * price; //kostnaden bestäms av priset för varje produkt samt hur många produkter man valt att köpa.
    }

}
