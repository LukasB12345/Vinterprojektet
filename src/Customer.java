public class Customer extends Cart {
    //Attributes
    int accountNumber;
    String name;

    //Constructor
    public Customer(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

}

//Ska antagligen bort, eventuellt utvecklas i ett senare projekt där olika kunder kan ha en egen varukorg