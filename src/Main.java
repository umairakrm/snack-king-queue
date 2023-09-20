import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /*Creating three arrays containing 2,3,5 elements respectively, to store customer availability in each cashier
    * & they are set as final because they are not to be reassigned later also the amount of pizzas in stock also
    * mentioned. All these are declared as global So all things can be accessed from anywhere*/
    private static final String[] cashier1 = new String[2];
    private static final String[] cashier2 = new String[3];
    private static final String[] cashier3 = new String[5];
    private static int pizzaInStock = 100;

    public static void main(String[] args) {
        /*Checks the Pizzas in stock if min reached pops a warning if not directs to the DisplayMenu */
        if (pizzaInStock <= 20) {
            System.out.println("WARNING: 20 or less Pizzas remain");
        }
        DisplayMenu();
    }

    //Display Menu---------------------------------------------------------
    private static void DisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            /*While the while loop remains true it loops among the menu options that shows to the operator to access to the different actions*/
            System.out.println( );
            System.out.println("Enter your preferred action");
            System.out.println();
            System.out.println("100 or VFQ: View all Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue.");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order.");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data from file.");
            System.out.println("108 or STK: View Remaining burgers Stock.");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println();

            /*Getting a user input to direct to the relevant task that user need to go*/
            System.out.print("Enter Here: ");
            String MenuInput = scanner.next();

            /*According to the menu input through a switch case user is directed to the relevant methods*/
            switch (MenuInput){
                case "100","VFQ":
                    ViewAllQueues();
                    break;

                case "101","VEQ":
                    ViewAllEmptyQueues();
                    break;

                case "102","ACQ":
                    AddCustomerToAQueue();
                    break;

                case "103","RCQ":
                    RemoveACustomerFromAQueue();
                    break;

                case "104","PCQ":
                    RemoveAServedCustomer();
                    break;

                case "105","VCS":
                    ViewCustomersInAlphabeticalOrder(cashier1);
                    ViewCustomersInAlphabeticalOrder(cashier2);
                    ViewCustomersInAlphabeticalOrder(cashier3);
                    sortedNames();
                    break;

                case "106","SPD":
                    StoreProgramDataInToFile();
                    break;

                case "107","LPD":
                    LoadProgramDataFromFile();
                    break;

                case "108","STK":
                    ViewRemainingPizzaStock();
                    break;

                case "109","AFS":
                    AddPizzasToStock();
                    break;

                case "999","EXT"://Exits the program
                    System.out.println("Exiting the program....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter a valid menu option");
                    DisplayMenu();
                    break;
            }
        }
    }


    //View All Queues---------------------------------------------------------

    /*Loops through the cashier queues & checks the status of each slot if the slot is null, it means slot is not occupied So it replace the null with
    "X", if its occupied it replaces with "O" after looping within 3 cashiers it prints the queues in given pattern*/
    private static void ViewAllQueues() {
        //Label
        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");
//        System.out.println("X - Slot Not Occupied\nO - Slot Occupied" );

        //looping through cashier arrays
        for (int i = 0; i < 5; i++) {
            //condition? expressionTrue:expressionFalse(Ternary inside a ternary)
            String QOutput1 = (i < cashier1.length)? ((cashier1[i] == null) ? ("X") : ("O")) : (" ");
            String QOutput2 = (i < cashier2.length)? ((cashier2[i] == null) ? ("X") : ("O")) : (" ");
            /*Here it's not needed to use 2 ternaries as no need to check cashier length*/
            String QOutput3 = (cashier3[i] == null) ? "X" : "O";

            //printing the queue table
            String QueueTable = "  " + QOutput1 + "    " + QOutput2 + "    " + QOutput3 + "   " ;
            System.out.println(QueueTable);
        }
    }


    //View All Empty Queues---------------------------------------------------------

    /*It confirms whether there's an empty slot or not with the help of hasEmptySlot()'s return value.If its true it passes the cashier to printNullSlotIndices()
    * then it prints the relevant empty slots */
    private static void ViewAllEmptyQueues() {
        System.out.println("*** Empty Queues ***");

        //Cashier 1----------
        if (hasEmptySlot(cashier1)){
            /* Breaks a line before Printing the Queue number */

            System.out.print("\nQueue 1: ");
            /*Loops among the relevant cashier elements*/
            printNullSlotIndices(cashier1);
        }

        //Cashier 2----------
        if (hasEmptySlot(cashier2)){
            /* Breaks a line before Printing the Queue number */
            System.out.print("\nQueue 2: ");

            /*Loops among the relevant cashier elements*/
            printNullSlotIndices(cashier2);
        }

        //Cashier 3----------
        if (hasEmptySlot(cashier3)){
            /* Breaks a line before Printing the Queue number */

            System.out.print("\nQueue 3: ");
            /*Loops among the relevant cashier elements*/
            printNullSlotIndices(cashier3);
        }

    }

    /*Helping Method to loop among the cashier elements and print the elements which are with null value as they are the empty slots*/
    private static void printNullSlotIndices(String[] cashier) {
        for (int i = 0; i < cashier.length; i++) {
            /*If the value is null prints it by adding 1 to as index starts from 0*/
            if (cashier[i]==null){
                System.out.print(i+1);

                /*Prints a comma until the last element reach*/
                if (i< cashier.length-1){
                    System.out.print(", ");
                }
            }
        }
    }

    /*Helping method to check whether is there any empty slots in cashier queues*/
    private static boolean hasEmptySlot(String[] cashier){
        /*loops among the Cashier Queues*/
        for (String slot:cashier) {
            /*if there's a null slot it returns true*/
            if (slot == null){
                return true;
            }
        }
        /*if no nulls found return false*/
        return false;
    }


    //Add Customer To A Queue---------------------------------------------------------

    /*Gets customerName() & cashierNumber() to add the customer.Then directs to the entered cashier number & loops through it, if there's a null it
    * replaces it with "O" also reads the position/index and save the name to the index */
    private static void AddCustomerToAQueue() {

        /* Get customer name */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        String customerName = scanner.next();

        /* Get Queue number */
        System.out.println("Enter Cashier number customer needs to attend (1 ,2 or 3): ");
        int cashierNumber = scanner.nextInt();

        String[] chosenCashier ;// Initialize with an empty array
        switch (cashierNumber){
            case 1:
                chosenCashier = cashier1;
                break;
            case 2:
                chosenCashier = cashier2;
                break;
            case 3:
                chosenCashier = cashier3;
                break;
            default:
                System.out.println("Enter a valid Cashier number.");
                AddCustomerToAQueue();
                return;
        }

        /*Already variable is initialized to -1, if no index is initialized after loop, gives the default -1 & prints error msg.
        This variable will store the position of the queue where the customer will be added.*/
        int customerPosition = -1;
        for (int i = 0; i < chosenCashier.length; i++) {
            if (chosenCashier[i] == null) {
                chosenCashier[i] = "O";
                customerPosition=i;
                System.out.println(customerName+" added to Cashier "+cashierNumber+"'s queue.");
                break;
            }
        }
        if (customerPosition == -1){
            /*if there are no nulls then queue full*/
            System.out.println("Cashier "+ cashierNumber + " is Full.Try another Cashier.");
            AddCustomerToAQueue();

        }
        else {
            /*Saves the name to the customer position*/
            chosenCashier[customerPosition]=customerName;
        }
    }


    //Remove A Customer From A Queue---------------------------------------------------------

    /*Get name & cashier number to remove a customer, then finds the position/index of the name first and removes it
    & shifts following customers forward */
    private static void RemoveACustomerFromAQueue() {
        Scanner scanner = new Scanner(System.in);

        /*Get customer name*/
        System.out.println("Enter Customer Name to Remove: ");
        String customerName = scanner.next();

        /*Get cashier number*/
        System.out.println("Enter Cashier number customer needs to remove (1 ,2 or 3): ");
        int cashierNumber = scanner.nextInt();

        String[] chosenCashier ;// Initialize an empty array
        switch (cashierNumber){
            case 1:
                chosenCashier = cashier1;
                break;
            case 2:
                chosenCashier = cashier2;
                break;
            case 3:
                chosenCashier = cashier3;
                break;
            default:
                System.out.println("Invalid Cashier number.");
                RemoveACustomerFromAQueue();
                return;
        }

        int customerPosition = findCustomerPosition(chosenCashier,customerName);

        /*customerPosition == -1 means that there's no such a customer in the entered queue So prints an error message*/
        if (customerPosition == -1){
            System.out.println("Customer "+customerName+" not found in Queue "+cashierNumber);
            RemoveACustomerFromAQueue();
        }

        /*If customer position not equals -1 means a position for the name entered found, So removeCustomer() removes the name in the relevant position
        * & moves following customers forward to fill the gap*/
        removeCustomer(chosenCashier,customerPosition);
        System.out.println("Customer "+customerName+" removed from the Queue "+cashierNumber);
    }

    /*It takes the chosen cashier & customer position related to the name,Then loop among the chosen cashier, loop starts from the position
    of customer who is removed by replacing the next customer for that position at the end, last slot is replaced as null*/
    private static void removeCustomer(String[] chosenCashier, int customerPosition) {
        //Replacing the removed customer by customers following
        for (int i = customerPosition; i < chosenCashier.length - 1; i++) {
            chosenCashier[i] = chosenCashier[i + 1];
        }

        //Assign the last position of the queue as empty
        chosenCashier[chosenCashier.length - 1] = null;

    }

    /*Finding for the Customer Position relevant to the input name.Gets chosen cashier & customer name to remove, and loops through the chosen cashier
    * & look for the customer names equals to the customer name entered.If equal name found returns the index value of the name.If not found returns -1 */
    private static int findCustomerPosition(String[] chosenCashier, String customerName) {
        for (int i = 0; i < chosenCashier.length; i++) {
            /*Ignoring case during the comparison*/
            if (chosenCashier[i].equalsIgnoreCase(customerName)){
                return i;/*customer index*/
            }
        }
        return -1;/*customer not found*/
    }


    //Remove A Served Customer---------------------------------------------------------

    /*Removes a customer just same as removing from a queue & as the customer is served pizza count is reduced by 10*/
    private static void RemoveAServedCustomer() {
        RemoveACustomerFromAQueue();
        pizzaInStock -=10;//deducts pizzas from the stock
    }


    //View Customers In Alphabetical Order---------------------------------------------------------

    private static void ViewCustomersInAlphabeticalOrder(String[] queue){
        /*Implement Bubble Sort - compare elements in the array & swaps them if they are not in the correct order.
        * Process will repeat until entire array is sorted*/
        int n = queue.length;

        /*Outer loop runs upto the one before last element as n-1 comparisons are done*/
        for (int i = 0; i < n-1; i++) {

            /*inner loop runs upto the n-i-1 as the final element is always sorted after a loop done so in the next there's no need to again sort it*/
            for (int j = 0; j < n-i-1; j++) {


                /*check whether current & next elements are not equal to null*/
                if (queue[j] != null && queue[j + 1] != null){

                    /*if the result of comparing current & next element is greater than 0 swap*/
                    if (stringComparision(queue[j],queue[j+1])>0){

                        /*Swap elements*/
                        String temp = queue[j];
                        queue[j] = queue[j+1];
                        queue[j+1]=temp;
                    }
                }
            }
        }
    }

    private static int stringComparision(String firstStr, String secondStr){
        /*finding the minimum length between the 2 strings*/
        int minimumLength = Math.min(firstStr.length(),secondStr.length());

        /*Loop through the characters of the strings upto the minimum length*/
        for (int i = 0; i < minimumLength; i++) {

            /*Get the characters at the current index from both strings*/
            char firstChar = firstStr.charAt(i);
            char secondChar = secondStr.charAt(i);

            if (firstChar < secondChar) {
                /*if the character in firstChar is less than secondChar return -1*/
                return -1;

            } else if (firstChar > secondChar) {
                /*if the character in firstChar is greater than secondChar return 1*/
                return 1;
            }
        }
        /*If the both length are equal the shorter string should come first*/
        return firstStr.length()-secondStr.length();
    }

    /*Helping method to print sorted names in order*/
    private static void sortedNames(){
        /*label firsts,iterates through the elements in cashier array if it's not a null print*/
        System.out.print("Queue 01: ");
        for (String element:cashier1) {
            if (element != null){
                System.out.print(element+" ");
            }
        }

        /*label firsts,iterates through the elements in cashier array if it's not a null print*/
        System.out.print("\nQueue 02: ");
        for (String element:cashier2) {
            if (element != null){
                System.out.print(element+" ");
            }
        }

        /*label firsts,iterates through the elements in cashier array if it's not a null print*/
        System.out.print("\nQueue 03: ");
        for (String element:cashier3) {
            if (element != null){
                System.out.print(element+" ");
            }
        }
        System.out.println();//break line after queue print
    }

    //Store Program Data In To File---------------------------------------------------------

    /*Creates a new file & sequentially write writes the names of customers in each cashier queue to this file,with spaces after writing each cashier closes
    * the file.Also includes a try catch to handle the errors that might be occurred in file operations*/
    private static void StoreProgramDataInToFile() {
        try {
            //Create a new file named Customer Data
            FileWriter writeCustomerFile = new FileWriter("Customer Data.txt");

            /* writing data in cashier1 to the file------ */
            writeCustomerFile.write("Cashier 1 : ");
            for (String customer : cashier1) {
                /*Print the customer only if it is not null, If null don't print*/
                if (customer != null){
                    /*Writing each customer's name followed by a space*/
                    writeCustomerFile.write(customer + " ");
                }
            }
            /*Writing new line characters to separate the data of each cashier*/
            writeCustomerFile.write("\n\n");

            /* writing data in cashier2 to the file ------*/
            writeCustomerFile.write("Cashier 2 : ");
            for (String customer : cashier2) {
                /*Print the customer only if it is not null, If null don't print*/
                if (customer != null){
                    /*Writing each customer's name followed by a space*/
                    writeCustomerFile.write(customer + " ");
                }
            }
            /*Writing new line characters to separate the data of each cashier*/
            writeCustomerFile.write("\n\n");

            /* writing data in cashier3 to the file ------*/
            writeCustomerFile.write("Cashier 3 : ");
            for (String customer : cashier3) {
                /*Print the customer only if it is not null, If null don't print*/
                if (customer != null){
                    /*Writing each customer's name followed by a space*/
                    writeCustomerFile.write(customer + " ");
                }
            }


            //closing the file
            writeCustomerFile.close();

            /*Indicating that the file creation & writing process is successful*/
            System.out.println("Customer data has been Successfully stored in the file.");
        }
        catch (IOException ex){
            /*Handling any exception occur during file operations*/
            System.out.println("An error Occurred "+ex.getMessage());
        }
    }


    //Load Program Data from File---------------------------------------------------------

    /*Code reads the characters of the text file one by one using a loop & printed. The loop continues until the read() returns -1,read() returns -1 at
    * the end of the file.*/
    private static void LoadProgramDataFromFile() {
        try {
            //Creating a new FileReader object to read from the file
            FileReader readTextFile = new FileReader("Customer Data.txt");

            /*Reading the first character of file*/
            int code = readTextFile.read();

            /*looping & reading through the file until the last character is read*/
            while(code!=-1){
                /*Printing the character read from the file as a character*/
                System.out.print((char)code);

                /*Reading the next character*/
                code=readTextFile.read();
            }
            /*Close the file-reader*/
            readTextFile.close();

        } catch (IOException ex){
            /*if there's an error during reading the error will display through the "sout" statement.*/
            System.out.println(ex.getMessage());

        }
    }


    //View Remaining Pizza Stock---------------------------------------------------------

    /*Prints the number of pizzas available*/
    private static void ViewRemainingPizzaStock() {
        System.out.println(pizzaInStock+" Pizza Available.");
    }


    //Add Pizza to Stock---------------------------------------------------------

    /*Increase the pizza stock by adding the given amount to pizzaInStock*/
    private static void AddPizzasToStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Pizzas to add: ");
        int pizzasToAdd = scanner.nextInt();
        if (pizzasToAdd>0){
            pizzaInStock += pizzasToAdd;
            System.out.println(pizzasToAdd + " Pizzas added to Pizza Stock,"+ pizzaInStock +" Total Pizzas available");
        }else {
            System.out.println("Invalid number of Pizzas.");
        }
    }


}