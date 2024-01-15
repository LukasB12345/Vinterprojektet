/* This is a SUB-class */
public class WeightedItem extends Item {

    //Attributes
    private double weight; //Bara variabeln/attributet weight behöver läggas till: name och p.rice finns redan

    //Constructor
    public WeightedItem(String name, double price, double weight) { //skapar en WeightedItem
        this.name = name; //anger produktens namn
        this.price = price; //anger produktens pris
        this.weight = weight; //anger produktens vikt
    }


    public double CalculateCost(double price, double weight) { //Klass för att beräkna priset av en produkt där priset beror på vikt.
        return weight * price; //Returnerar priset på produkten/produkterna. Detta beror på hur många man har köpt och vad varje produkt kostar.
    }
}

