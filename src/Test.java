import java.util.*;

public class Test {
    /*
       *******************************
       ***     Name: Hien Nguyen   ***
       ***     CS 216              ***
       ***     Assignment 1        ***
       *******************************
     */
    public static void main(String[] args) {
        // ----------------------SECTION 1: Declare variables,
        // objects-------------------------------
        // Create an instance/ object of Repository class
        Repository[] repository = new Repository[5];

        repository[0] = new Repository("Oranges", 10, 2.99, 500);

        repository[1] = new Repository("Eggs", 12, 1.69, 1000);

        repository[2] = new Repository("Apples", 3, 1.0, 600);

        repository[3] = new Repository("Watermelons", 1, 4.39, 100);

        repository[4] = new Repository("Bagels", 6, 2.99, 150);

        // Update the price of oranges and bagels
        repository[0].setGroupPrice(3.99);
        repository[4].setGroupPrice(3.00);

        // create an instance/object of the Shopping class - it is used to store item
        // numbers and purchased quanity from user input
        Shopping customer1 = new Shopping();

        // use Scanner class to create sc object - allow user to enter an item number
        // and the purchased quantity
        Scanner sc = new Scanner(System.in);

        //
        int itemNum = 0;
        int purchasedQuantity = 0;
        boolean vaildNum = true;
        int count = 1;

        String itemName = null;
        double itemPrice = 0;
        double totalCost = 0;

        // show the available stock in the repository for a user
        displayRepository(repository);

        // ----------------------SECTION 2: Get user input and store it in customer1
        // object-------------------------------
     
        do {
            System.out.println("Enter the item number followed by purchased quanity. Enter 6 to exit");
            itemNum = sc.nextInt();

            if (itemNum < 6) {
                count++;
                if (count == 2) {
                    purchasedQuantity = sc.nextInt();

                    customer1.addItem(itemNum - 1, purchasedQuantity);
                    count = 1;

                    itemNum = purchasedQuantity;
                }
            } else if (itemNum == 6) {
                System.out.println("GoodBye!...");
                break;
            } else {
                System.out.println("Invalid number");
                vaildNum = false;
            }
        } while (vaildNum);

        // ----------------------SECTION 3: Generate and display the bill for a
        // user-------------------------------
        System.out.println("Your shopping reciept");
        System.out.println("----------------------");
        System.out.printf("%-15s %-15s %-15s\n", "Item name", "Quantity", "Cost");

        for (int i = 0; i < customer1.getShopping().length; i++) {
            if (customer1.getShopping()[i] != 0) {
                switch (i) {
                    case 0:
                        itemName = "Orange";
                        itemPrice = ((customer1.getShopping()[i] * repository[i].getGroupPrice())
                                / repository[i].getGroupCount());
                        // update available stock in the repository:
                        repository[i].setNumAvailable(repository[i].getNumAvailable() - customer1.getShopping()[i]);
                        break;
                    case 1:
                        itemName = "Eggs";
                        itemPrice = ((customer1.getShopping()[i] * repository[i].getGroupPrice())
                                / repository[i].getGroupCount());
                        // update available stock in the repository:
                        repository[i].setNumAvailable(repository[i].getNumAvailable() - customer1.getShopping()[i]);
                        break;
                    case 2:
                        itemName = "Apples";
                        itemPrice = ((customer1.getShopping()[i] * repository[i].getGroupPrice())
                                / repository[i].getGroupCount());
                        // update available stock in the repository:
                        repository[i].setNumAvailable(repository[i].getNumAvailable() - customer1.getShopping()[i]);
                        break;
                    case 3:
                        itemName = "Watermelons";
                        itemPrice = ((customer1.getShopping()[i] * repository[i].getGroupPrice())
                                / repository[i].getGroupCount());
                        // update available stock in the repository:
                        repository[i].setNumAvailable(repository[i].getNumAvailable() - customer1.getShopping()[i]);
                        break;
                    case 4:
                        itemName = "Bagels";
                        itemPrice = ((customer1.getShopping()[i] * repository[i].getGroupPrice())
                                / repository[i].getGroupCount());
                        // update available stock in the repository:
                        repository[i].setNumAvailable(repository[i].getNumAvailable() - customer1.getShopping()[i]);
                        break;
                }
                itemPrice = (int) (itemPrice * 100) / 100.00;
                totalCost += itemPrice;
                System.out.printf("%-15s %-15s %-15s\n", itemName, customer1.getShopping()[i], itemPrice);
            }
        }
        System.out.println("Total shopping cost: $" + totalCost);

        // print the updated stock after a user bought some items
        System.out.println("----------------------");
        System.out.println("Our updated repository: ");
        displayRepository(repository);
    }

    // method is used to display the stock items in the repository
    public static void displayRepository(Repository repository[]) {
        System.out.println("Welcome to the store! List of items in the repository: ");

        for (int i = 0; i < repository.length; i++) {

            System.out.printf("%-10s %-30s %s\n", (i + 1),
                    (repository[i].getItemName() + ": " + repository[i].getGroupCount() + " for $"
                            + repository[i].getGroupPrice() + "."),
                    ("The store has " + repository[i].getNumAvailable() + " in stock."));
        }

        System.out.printf("%-10s %s\n", "6", "Exit");
        System.out.println();
    }
}
