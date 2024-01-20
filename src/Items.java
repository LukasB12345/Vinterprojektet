import java.util.ArrayList;

public class Items {

    //Skapar produkter här
    //Produkterna är static final för att deras värden inte ska ändras. Det finns bestämda priser för produkterna. Och kvantiteten är 1 för produkter utan vikt. Sedan får man lägga till produkten fler gånger för att köpa fler

    public static final Item milk = new Item("milk", 13, 1);
    public static final Item cream = new Item("cream", 26.90, 1);
    public static final Item meat = new Item("meat", 399.90, 1);

    public static final WeightedItem candy = new WeightedItem("candy", 99.99);
    public static final WeightedItem tomato = new WeightedItem("tomato", 24.90);
    public static final WeightedItem carrot = new WeightedItem("carrot", 11.50);

    public static final Item[] itemList = {milk, cream, meat};
    public static final WeightedItem[] weightedItemList = {candy, tomato, carrot};

    public static void showAvailableItems() {
        for (Item item : itemList) {
            System.out.println(item.name + " Price: " + item.cost + " SEK");
        }
        for (WeightedItem item : weightedItemList) {
            System.out.println(item.name + " Price: " + item.price + " SEK/KG");
        }
    }


}

