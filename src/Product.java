public class Product {

    //Attributes
    protected String name;
    protected int quantity;
    protected int price;
    protected double weight;

    //Default constructor
    public Product() {
    }

    //Constructor
    public Product(String name, int quantity, double weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public void CalculateCost() {


    }
}
