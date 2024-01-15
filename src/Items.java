public class Items {

    //Skapar produkter här
    //Produkterna är static final för att deras värden inte ska ändras. Det finns bestämda priser för produkterna. Och man väljer direkt hur många produkter (quantity) man vill köpa.

    public static final Item milk = new Item("milk", 13, 2);
    public static final Item cream = new Item("cream", 26.90, 4);
    public static final Item meat = new Item("meat", 399.90, 1);

    public static final Item candy = new WeightedItem("candy", 99.99, 0.5);
    public static final Item tomato = new WeightedItem("tomato", 24.90, 2.5);
    public static final Item carrot = new WeightedItem("carrot", 11.50, 1);

}

