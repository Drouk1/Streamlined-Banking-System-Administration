import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        FileLoader bankStore = new FileLoader();
        FileLoader sellersStore = new FileLoader();
        FileLoader salesStore = new FileLoader();
        FileLoader creditCardMovementStore = new FileLoader();

        if (bankStore.isFileExists(new File("BankProducts.txt")) && //checking if files are writed well 
                sellersStore.isFileExists(new File("Sellers.txt"))
                && salesStore.isFileExists(new File("Sales.txt"))
                && creditCardMovementStore.isFileExists(new File("CreditCardMovement.txt"))) {
            bankStore.loadFileBankProducts("BankProducts.txt");
            sellersStore.loadFileSellers("Sellers.txt");
            salesStore.loadFileSales("Sales.txt");
            creditCardMovementStore.loadFileCreditCardMovements("CreditCardMovement.txt");
        } else {
            System.out.println("File doesnt exist..");
            System.exit(0);
        }

        ArrayList<Double> creditCardTotalWorthMovements = new ArrayList<Double>(); // declare arraylists that
                                                                                   // are used for
                                                                                   //  commit etc calculation
        ArrayList<Double> totalAmountOfLoans_perSeller = new ArrayList<Double>();
        ArrayList<Double> comisionsOfSellers = new ArrayList<Double>();
        double sumComision = 0;

        System.out.println( // MENU
                "Choose:\n\t1.new seller\n\t2.new bank product\n\t3.new sale\n\t4.new credit card movement\n\t5.show loans\n\t6.calculating a seller's commission\n\t7.Display of credit card transactions related to a seller\n\t8.Calculation of the commission of all the sellers of the bank\n\t9.Display the final commission amount of all sellers\n\n\tOr 0 to end the programm!");
        int choice = scan.nextInt();

        

        while (choice < 0 || choice > 9) { //if answer is not between 0-9 it asks again till it gets the right answer
            System.out.println("Please type a number between 1 - 9 or 0 to end the programm!");
            choice = scan.nextInt();
        }

        while (choice != 0) {

            if (choice == 1) { // input from user
                scan.nextLine();
                System.out.print("First name: ");
                String firstName = scan.nextLine();

                System.out.print("Last name: ");
                String lastName = scan.nextLine();

                System.out.print("Code: ");
                int code = scan.nextInt();

                System.out.print("AFM: ");
                int afm = scan.nextInt();

                Sellers seller = new Sellers(firstName, lastName, afm, code); // makes new seller object with the users input
                                                                              
                //sellersStore.getSellers().add(seller);

                System.out.println("SELLER ADDED");

            } else if (choice == 2) { // input from user
                System.out.print("Select 1 for credit cards,\nOr 2 for loans:");
                int answer = scan.nextInt();
                if (answer == 1) {
                    System.out.print("Write the code: ");
                    int codeP = scan.nextInt();

                    System.out.print("Write the number: ");
                    int number = scan.nextInt();

                    System.out.print("Write the AFM: ");
                    int afm = scan.nextInt();

                    System.out.print("Write the commision rate: ");
                    double commissionRate = scan.nextDouble();

                    System.out.print("Write the max amount of movement: ");
                    double maxAmountOfMovement = scan.nextDouble();

                    System.out.print("Write the max annual amount: ");
                    double maxAnnualAmmount = scan.nextDouble();

                    CreditCards creditCardx = new CreditCards(codeP, number, afm, null, null, commissionRate,
                            maxAmountOfMovement,
                            maxAnnualAmmount); //makes credit card object card and and put the users input

                    bankStore.getCreditCards().add(creditCardx);

                    System.out.println("CREDIT CARD ADDED");
                } else if (answer == 2) {
                    System.out.print("Write the code: ");
                    int codeP = scan.nextInt();

                    System.out.print("Write the number: ");
                    int number = scan.nextInt();

                    System.out.print("Write the AFM: ");
                    int afm = scan.nextInt();

                    System.out.println("Write the amount of Loan: ");
                    int amountOfLoan = scan.nextInt();

                    System.out.println("Write the Max annual interest rate: ");
                    int annualInterestRate = scan.nextInt();

                    Loan loanx = new Loan(codeP, number, afm, null, null, amountOfLoan, annualInterestRate);

                    bankStore.getLoans().add(loanx); ///makes loan object card and and put the users input

                    System.out.println("LOAN ADDED");

                }
            } else if (choice == 3) {
                System.out.print("Choose the seller by his code: \n\n");
                for (int i = 0; i < sellersStore.getSellers().size(); i++) { // prints seller so
                                                                             // the user can see them and choose
                                                                             // the code 
                    System.out.println(sellersStore.getSellers().get(i));
                }
                int mparigkasCode = scan.nextInt();
                int j = 0;
                while (true) { //loop that checks if the user gives correct value
                    for (int i = 0; i < sellersStore.getSellers().size(); i++) {
                        if (mparigkasCode == sellersStore.getSellers().get(i).getCode()) {
                            j = 1;
                            break;
                        }
                    }
                    if (j == 1) {
                        break;
                    } else {
                        System.out.print("Doesnt exist! Write again: ");
                        mparigkasCode = scan.nextInt();
                    }
                }
                System.out.print("What's the sale code: ");
                int saleCode = scan.nextInt();
                System.out.print("Whats the Bank Product you want to choose(1 for credit card and 2 for loan)? ");
                int bankProduct = scan.nextInt();

                System.out.print("Tell us the reasoning: ");
                scan.nextLine();
                String reason = scan.nextLine();
                Sales salere = new Sales(saleCode, bankProduct, reason, null); //makes new sales object
                                                                               // and put the values of the user

                salesStore.getSales().add(salere);

                String bankItemType;
                if (bankProduct == 1) { //checks what value was given to translate it like card or loan
                    bankItemType = "Card";
                } else {
                    bankItemType = "Loan";
                }

                System.out.print("Do you want to store this sale?");
                String storeSale = scan.nextLine();

                if (storeSale.equalsIgnoreCase("yes")) { //calls WriteFilesSales and write the elements to
                                                         // Sales.txt
                    salesStore.WriteFilesSales("Sales.txt", saleCode, bankItemType, bankProduct, reason);
                }

                System.out.println("SALE ADDED");
            } else if (choice == 4) {

                System.out.println("Write the code of the credit card you want to choose to do this movement: ");

                for (int i = 0; i < bankStore.getCreditCards().size(); i++) { //displays credit cards
                    System.out.println(bankStore.getCreditCards().get(i));
                }
                int CCcode = scan.nextInt();
                int j = 0;
                int position = 0;
                while (true) { // loop for the correctness check of the values
                    for (int i = 0; i < bankStore.getCreditCards().size(); i++) {
                        if (CCcode == bankStore.getCreditCards().get(i).getCode()) {
                            j = 1;
                            position = i; // stores i
                            break;
                        }
                    }
                    if (j == 1) {
                        break;
                    } else {
                        System.out.print("Doesnt exist! Write again: ");
                        CCcode = scan.nextInt();
                    }
                }
                double s2 = creditCardTotalWorthMovements.get(position);
                if (s2 >= bankStore.getCreditCards().get(position).getmaxAnnualAmmount()) { // check if the 
                                                                                            // specific movement
                                                                                            // is bigger than
                                                                                            // the maxmannual and print 
                                                                                            // the appropriate message
                    System.out.println("YOU HAVE REACHED THE LIMIT!");

                } else {
                    System.out.print("Write the worth: ");
                    double worth = scan.nextDouble();

                    boolean ok1 = false;
                    boolean ok2 = false;
                    double s = creditCardTotalWorthMovements.get(position) + worth;
                    while (true) { //  check if the max amount of transactions has been exceeded
                        if (worth > bankStore.getCreditCards().get(position).getmaxAmountOfMovement()) {
                            System.out.println(
                                    "You have surpassed the max amount of transaction.Type another amount of money: ");
                            s = creditCardTotalWorthMovements.get(position) - worth;
                            worth = scan.nextDouble();
                        } else {
                            ok1 = true;
                            s = worth + creditCardTotalWorthMovements.get(position);
                        }

                        if (s > bankStore.getCreditCards().get(position).getmaxAnnualAmmount()) {
                            System.out.println( // checking if the max annual transaction amount has been exceeded
                                    "You have surpassed the max annual transaction amount.Type another amount of money: ");
                            worth = scan.nextDouble();
                        } else {
                            ok2 = true;
                        }
                        if (ok1 && ok2) {
                            break;
                        }
                    }

                    creditCardTotalWorthMovements.set(position, s); // stores in the list
                    if (ok1 && ok2) {
                        scan.nextLine();
                        System.out.print("Write the reasoning: ");
                        String reason = scan.nextLine();
                        creditCardMovementStore.getCreditCardMovements()
                                .add(new CreditCardMovement(CCcode, worth, reason, CCcode));
                        s2 = s;

                        System.out.print("Do you want to store this sale?");
                        String storeSale = scan.nextLine();

                        if (storeSale.equalsIgnoreCase("yes")) { // calls OriteFilesCreditSardMoments which writes
                                                                 // the information provided by the user to
                                                                 // CreditCardMovements.txt
                            creditCardMovementStore.WriteFilesCreditCardMovements("CreditCardMovement.txt", CCcode,
                                    CCcode, worth, reason);
                        } else if (choice == 5) {
                            System.out.println(bankStore.getLoans()); //displays all the loans
                        } else if (choice == 6) {
                            for (int i = 0; i < sellersStore.getSellers().size(); i++) { // displays sellers
                                System.out.println(i + ". " + sellersStore.getSellers().get(i));
                            }
                            System.out.println(
                                    "These are the sellers.Choose the one you want to calculate the commision(number) from his list number: ");
            
                            int commisionCode = scan.nextInt();
                            int j = 0;
                            while (true) { //  correctness check of the values
                                for (int i = 0; i < sellersStore.getSellers().size(); i++) {
                                    if (commisionCode == i) {
                                        j = 1;
                                        break;
                                    }
                                }
                                if (j == 1) {
                                    break;
                                } else {
                                    System.out.print("Doesnt exist! Write again: ");
                                    commisionCode = scan.nextInt();
                                }
                            }
                            System.out.println( //displays commisions of each one
                                    "Commission of seller num." + commisionCode + " = " + comisionsOfSellers.get(commisionCode));
                        }else if (choice == 7) {
                            System.out.print("Choose the seller by his code: \n\n");
                            for (int i = 0; i < sellersStore.getSellers().size(); i++) { //displays sellers
                                System.out.println(sellersStore.getSellers().get(i));
                            }
                            int chooseSeller = scan.nextInt();
                            int j = 0;
                            while (true) {
                                for (int i = 0; i < sellersStore.getSellers().size(); i++) {
                                    if (chooseSeller == sellersStore.getSellers().get(i).getCode()) {
                                        j = 1;
                                        break;
                                    }
                                }
                                if (j == 1) {
                                    break;
                                } else {
                                    System.out.print("Doesnt exist! Write again: ");
                                    chooseSeller = scan.nextInt();
                                }
                            }
                            System.out.println("Credit cards Movements of seller with code " + chooseSeller + ":\n");
                            for (int i = 0; i < creditCardMovementStore.getCreditCardMovements().size(); i++) { // displays
                                                                                                                // movement value
                                if (chooseSeller == creditCardMovementStore.getCreditCardMovements().get(i).getCode()) {
                                    System.out.println("Movement value:"
                                            + creditCardMovementStore.getCreditCardMovements().get(i).getMovementWorth());
                                }
                            }
                        } else if (choice == 8) { // calculating all sellers commision!
                            for (int i = 0; i < sellersStore.getSellers().size(); i++) {
                                sumComision += comisionsOfSellers.get(i);
                            }
                            System.out.println("CALCULATION COMPLETED!");
                        }
                    }
                    System.out.println("CREDIT CARD MOVEMENT ADDED..");
                }

            } 
        }

        scan.close();
        System.out.println("Thank you for visiting Java Bank!");

    }    
}
