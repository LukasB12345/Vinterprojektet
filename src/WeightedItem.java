/* This is a SUB-class */
public class WeightedItem extends Item {

    //Attributes
    protected double weight;

    //Constructor
    public WeightedItem(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.cost = CalculateCost(price, weight); //Använder CalculateCost redan här för att ge ett värde för att det inte ska bli fel sen.
    }

    @Override
    public double CalculateCost(double price, double weight) {
        double cost = weight * price;
        return cost;
    }
}

