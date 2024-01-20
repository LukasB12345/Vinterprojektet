/* This is a SUB-class */
public class WeightedItem extends Item {

    //Attributes
    protected double weight; //Bara variabeln/attributet weight behöver läggas till: name och price finns redan

    //Constructor
    public WeightedItem(String name, double price) { //skapar en WeightedItem
        this.name = name; //anger produktens namn
        this.price = price; //anger produktens pris
        this.cost = CalculateCost();
    }

    public void setWeight(double weight) {
        this.weight = weight; //anger produktens vikt
    }

    public double CalculateCost() { //Klass för att beräkna priset av en produkt där priset beror på vikt.
        return weight * price; //Returnerar priset på produkten/produkterna. Detta beror på hur många man har köpt och vad varje produkt kostar.
    }
}


