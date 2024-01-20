import java.util.ArrayList;

public class Cart {
    public ArrayList<Item> items; //Arraylist där alla varor som lagts till i varukorgen som INTE HAR vikt samlas
    public ArrayList<WeightedItem> itemsWeight; //Arraylist där alla varor som lagts till i varukorgen som HAR vikt samlas

    // Default constructor för cart
    public Cart() {
        items = new ArrayList<>();
        itemsWeight = new ArrayList<>();
    }

    // Metod för att lägga till en produkt utan vikt i varukorgen
    public void AddItem(Item item) {
        items.add(item);
    }

    // Metod för att lägga till en produkt med vikt i varukorgen
    public void AddWeightedItem(WeightedItem item) {
        itemsWeight.add(item);
    }

    // Metod för att ta bort en produkt utan vikt i varukorgen
    public void RemoveItem(Item item) {
        items.remove(item);
    }

    // Metod för att ta bort en produkt med vikt i varukorgen
    public void RemoveWeightedItem(WeightedItem item) {
        itemsWeight.remove(item);
    }

    // Metod för att visa vad/vilka varor som finns i varukorgen, används i slutet när även priset på alla varor skrivs ut m.h.a. calculateTotalCost
    public void DisplayCart() {
        System.out.println("Shopping Cart Contents:");
        for (Item item : items) { //loopar igenom arraylisten där alla produkter (utan vikt) finns.
            System.out.println(item.name + " - Quantity: " + item.quantity + " - Cost: " + item.cost + " SEK"); //och skriver ut dem
        }
        for (WeightedItem item : itemsWeight) { //loopar igenom arraylisten där alla produkter (med vikt) finns.
            System.out.println(item.name + " - Weight: " + item.weight + " - Cost: " + item.CalculateCost() + " SEK"); //och skriver ut de
        }
    }

    // Metod för att beräkna totala kostnaden av produkterna som lagts till i en varukorg
    public double CalculateTotalCost() {
        double totalCost = 0;
        for (Item item : items) { //går igenom alla items i arraylisten för produkter utan vikt och beräknar deras pris vilket läggs till i den totala kostnaden
            totalCost += item.cost;
        }
        for (WeightedItem item : itemsWeight) { //går igenom alla items i arraylisten för produkter med vikt och beräknar deras pris vilket läggs till i den totala kostnaden
            totalCost += item.CalculateCost();
        }
        return totalCost;
    }

    public void getReciept() { //Här skrivs kvittot ut genom for each loopar, först skrivs alla produkter ut sedan alla produkter med vikt
        System.out.println("Thank you for visiting my store! Here is your reciept:");
        for (Item item : items) {
            System.out.println(item.name + " - Quantity: " + item.quantity + " - Cost: " + item.cost + " SEK"); //först för prodkter utan vikt
        }
        for (WeightedItem item : itemsWeight) {
            System.out.println(item.name + " - Weight: " + item.weight + " - Cost: " + item.CalculateCost() + " SEK"); //sedan för produkter med vikt
        }
        System.out.println("Your total cost is: " + CalculateTotalCost() + " SEK"); //här hämtas den totala kostnaden som beräknas med den tidigare skapade metoden
        System.out.println("Please come back soon!");
    }
}



