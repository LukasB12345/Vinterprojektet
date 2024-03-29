import java.util.Scanner;

public class Shop {
    private static final Scanner scanner = new Scanner(System.in); //Scanner för att läsa in användarens val
    static Cart cart = new Cart(); //Varukorg som är en egen klass skapas här som sedan används för att lägga varor i varukorgen

    public Shop() {
        Main();
    }


    public void Main() {

        boolean running = true; //Programmet körs så länge användaren inte väljer 6 (Avsluta programmet genom att göra running till false) genom en while-loop

        int choice;
        while (running) { //Programmet körs så länge användaren inte väljer 4 (Avsluta programmet) genom en while-loop
            System.out.println("Welcome to my shop! Choose 1-6 in the menu below:\nChoice 1 = Add product to cart\nChoice 2 = Remove product from cart\nChoice 3 = List all items in cart\nChoice 4 = See total price \nChoice 5 = See all available items in store\nChoice 6 = Exit shop");
            if (scanner.hasNextInt()) { //ser till att användaren skriver en int och inte ett otillåtet värde
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > 6 || choice < 1) {
                    System.out.println("You need to choose an integer between 1-6!!! Try again: "); //säger till ifall användaren skriver ett otillåtet tal och låter användaren försöka igen tills det blir rätt
                }
                switch (choice) {
                    case 1 -> AddItem();//Ifall användaren väljer 1 anropas metoden
                    case 2 -> RemoveItem();//Ifall användaren väljer 2 anropas metoden
                    case 3 -> ListAllItemsInCart(); //Ifall användaren väljer 3 anropas metoden
                    case 4 -> ShowTotalPrice(); //Ifall användaren väljer 4 anropas metoden
                    case 5 -> ListAllAvailableItems(); //Ifall användaren väljer 5 anropas metoden
                    case 6 -> { //Ifall användaren väljer 6 körs koden på de 2 nedre raderna:
                        cart.GetReciept(); //Ifall användaren väljer 5 avslutas programmet då running blir falsk och kvittot hämtas
                        running = false; //Vill man avsluta programmet blir värdet falskt och koden slutar köras/programmet avslutas
                    }
                }
            } else { //om man inte väljer/skriver 1-6:
                System.out.println("You need to choose an integer between 1-6!!! Try again: "); //säger till ifall användaren skriver ett otillåtet tal och låter användaren försöka igen tills det blir rätt
                scanner.next(); //läser in användarens val med en scanner
            }
        }
    }

    private static void AddItem() { //Metod för att lägga till en produkt
        System.out.println("The available items are: "); //berättar vilka produkter som finns att köpa genom en annan metod.
        ListAllAvailableItems(); //metod för att lista produkter som finns i sortimentet
        System.out.println("Please enter the item you want to add to the cart");
        String item = scanner.nextLine();

        Item itemToAdd = null; //Sätter värdet till null först
        WeightedItem weightedItemToAdd = null;

        for (Item i : Items.itemList) { //Kollar igenom fältet med listan av produkter som finns i sortimentet
            if (i.name.equals(item)) { //om produkten som angetts finns i sortimentet:
                itemToAdd = i; //alla i = true och läggs till
                cart.AddItem(itemToAdd); //lägger till produkten i varukorgen
                System.out.println("Item added to cart");
                return;
            }
        }

        for (WeightedItem i : Items.weightedItemList) { //Kollar igenom fältet med listan av produkter som finns i sortimentet
            if (i.name.equals(item)) { //om produkten som angetts finns i sortimentet:
                System.out.println("Please enter the weight of the product as a double (X.X)");
                if (scanner.hasNextDouble()) {
                    double weight = scanner.nextDouble();
                    i.SetWeight(weight);
                    weightedItemToAdd = i; //alla i = true och läggs till
                    cart.AddWeightedItem(weightedItemToAdd); //lägger till produkten(med vikt) i varukorgen
                    System.out.println("Item added to cart");
                    return;
                }
            }
        }

        if (itemToAdd == null && weightedItemToAdd == null) { //säger till ifall produkten som angetts inte finns i sortimentet och ger användaren en ny chans att lägga till en produkt genom att anropa den metoden (addItem)
            System.out.println("The product is not available");
            System.out.println("The available items are: "); //berättar vilka produkter som finns att köpa.
            ListAllAvailableItems();
            AddItem(); //finns inte produkten i sortimentet anropas metoden igen och man får försöka köpa en ny produkt
            return;
        }
    }

    private static void RemoveItem() { //metod för att ta bort en produkt från varukorgen
        System.out.println("Please enter the item you want to remove from the cart");
        System.out.println("The products added to your cart as of now are:"); //skriver ut vilka produkter som hitills har lagts till i varukorgen för att användaren enklare ska vbeta vad som kan tas bort från varukorgen
        ListAllItemsInCart();//med denna metod görs det som skrevs ovan
        String item = scanner.nextLine(); //läser in vilken produkt användaren vill ta bort
        Item itemToRemove = null; //Variabel som letar efter produkten som ska tas bort. Är från början null, eftersom ingen produkt ska tas bort direkt.
        WeightedItem weightedItemToRemove = null; //Variabel som letar efter produkten med vikt som ska tas bort. Är från början null, eftersom ingen produkt ska tas bort direkt.
        for (Item i : cart.items) { //Kollar igenom fältet med listan av produkter som finns i sortimentet
            if (i.name.equals(item)) { //om det finns så blir itemExists true
                itemToRemove = i; //alla i = true och läggs till
                cart.RemoveItem(itemToRemove); //och produkten tas sedan bort
                System.out.println("The product is now removed from the cart");
                return;
            }
        }

        for (WeightedItem i : cart.itemsWeight) { //Kollar igenom fältet med listan av produkter med vikt som finns i sortimentet
            if (i.name.equals(item)) { //om produkten finns så blir itemExists true
                weightedItemToRemove = i; //alla i = true och läggs till
                cart.RemoveWeightedItem(weightedItemToRemove); //och produkten (med vikt) tas sedan bort
                System.out.println("The product is now removed from the cart");
                return;
            }
        }

        if (itemToRemove == null && weightedItemToRemove == null) { //Om produkten som man vill försöka ta bort fortfarande == null betyder det att produkten inte finns i varukorgen/sortimentet
            System.out.println("The product is not available or not added to your cart yet");
        }
    }

    private static void ListAllItemsInCart() { //Metod för att lista upp alla produkter som lagts till i varukorgen
        cart.DisplayCart();
    }

    private static void ShowTotalPrice() { //Metod för att visa/skriva ut det totala priset för de varor som finns i varukorgen
        double totalPrice = cart.CalculateTotalCost(); //totala priset beräknas i metoden CalculateTotalCost
        System.out.println("The total price is:" + totalPrice + "SEK"); //och skriv ut
    }

    private static void ListAllAvailableItems() { //Metod för att lista upp alla items som finns. Det finns en annan metod som redan gör detta och därför anropas den metoden här. Detta kan optimeras genom att ta bort denna metod och byta ut den mot den som redan finns (ShowAvailableItems).
        Items.ShowAvailableItems(); //anropar en annan metod som gör detta (vet att det kan optimeras, men då de finns i olika klasser görs detta på ett enklare sätt via detta sätt)
    }
}

