import java.io.*;
import java.util.ArrayList;

public class FileLoader {

    private ArrayList<CreditCards> creditCards = new ArrayList<CreditCards>(); // Dilwsi arraylist gia ta creditcards
    private ArrayList<Loan> loans = new ArrayList<Loan>();// Dilwsi arraylist gia ta loans
    private ArrayList<Sellers> sellers = new ArrayList<Sellers>();// Dilwsi arraylist gia tous sellers
    private ArrayList<Sales> sales = new ArrayList<Sales>();// Dilwsi arraylist gia ta sales
    private ArrayList<CreditCardMovement> creditCardMovements = new ArrayList<CreditCardMovement>();// Dilwsi arraylist
                                                                                                    // gia ta
                                                                                                    // creditcards
                                                                                                    // movements

    public void loadFileBankProducts(String data) {
        BufferedReader reader = null; // ta thetoume null
        CreditCards creditCard = null;
        Loan loan = null;
        try {
            reader = new BufferedReader(new FileReader(data));
            String line;
            while ((line = reader.readLine()) != null) { // diavazei kathe line tou text
                if (line.toUpperCase().contains("BANKITEM_LIST".toUpperCase()) || (line.contains("{"))
                        || (line.toUpperCase().contains("BANKITEM".toUpperCase()))
                        || (line.contains("}"))) { // an to line periexei ena apo afta tote pigainei sto epomeno
                    continue;

                } else {
                    if (line.toUpperCase().contains("Card".toUpperCase())) { // an line periexei to Card tote ftiaxnei
                                                                             // object
                        creditCard = new CreditCards(); // credit card kai topothetei
                        line = reader.readLine(); // ta stoixeia pou diavazei an line
                        ((CreditCards) creditCard).setCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                        line = reader.readLine();
                        ((CreditCards) creditCard).setDescribe(line.trim().split(" ", 2)[1]);
                        line = reader.readLine();
                        ((CreditCards) creditCard).setAfm(Integer.parseInt(line.trim().split(" ", 2)[1]));
                        line = reader.readLine();
                        ((CreditCards) creditCard).setNumber(Integer.parseInt(line.trim().split(" ", 2)[1]));
                        line = reader.readLine();
                        ((CreditCards) creditCard)
                                .setCommissionRate(Double.parseDouble(line.trim().split(" ", 2)[1]));
                        line = reader.readLine();
                        ((CreditCards) creditCard)
                                .setMaxAmountOfMovement(Double.parseDouble(line.trim().split(" ", 2)[1]));
                        line = reader.readLine();
                        ((CreditCards) creditCard)
                                .setMaxAnnualAmmount(Double.parseDouble(line.trim().split(" ", 2)[1]));
                    } else if (line.toUpperCase().contains("Loan".toUpperCase())) { // an line periexei to Loan tote
                                                                                    // ftiaxnei object
                        loan = new Loan(); // loan kai topothetei
                        line = reader.readLine(); // ta stoixeia pou diavazei an line
                        ((Loan) loan).setCode(Integer.parseInt((line.trim().split(" ", 2)[1])));
                        line = reader.readLine();
                        ((Loan) loan).setDescribe(((line.trim().split(" ", 2)[1])));
                        line = reader.readLine();
                        ((Loan) loan).setAfm(Integer.parseInt(((line.trim().split(" ", 2)[1]))));
                        line = reader.readLine();
                        ((Loan) loan).setNumber(Integer.parseInt(((line.trim().split(" ", 2)[1]))));
                        line = reader.readLine();
                        ((Loan) loan).setAmountOfLoan(Integer.parseInt(((line.trim().split(" ", 2)[1]))));
                        line = reader.readLine();
                        ((Loan) loan).setAnnualInterestRate(Integer.parseInt(((line.trim().split(" ", 2)[1]))));
                    }
                    if (creditCards.size() < 4) {
                        creditCards.add(creditCard);
                    }
                    if (loan != null) {
                        loans.add(loan);
                    }
                    line = reader.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    // reader.close();

    public void loadFileSellers(String data) {
        BufferedReader reader = null;
        Sellers seller = null;

        try {

            reader = new BufferedReader(new FileReader(data));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("SALESMAN_LIST") || (line.contains("{")) || (line.trim().contains("SALESMAN"))
                        || (line.contains("}"))) { // do nothing go to the next line
                    continue;
                } else {
                    seller = new Sellers();
                    ((Sellers) seller).setCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((Sellers) seller).setLastName(line.trim().split(" ", 2)[1]);
                    line = reader.readLine();
                    ((Sellers) seller).setFirstName(line.trim().split(" ", 2)[1]);
                    line = reader.readLine();
                    ((Sellers) seller).setAfm(Integer.parseInt(line.trim().split(" ", 2)[1]));

                    sellers.add(seller);
                    line = reader.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    // reader.close();

    public void loadFileSales(String data) {
        BufferedReader reader = null;
        Sales sale = null;

        try {

            reader = new BufferedReader(new FileReader(data));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("SALES_LIST") || (line.contains("{")) || (line.trim().equals("SALES"))
                        || (line.contains("}"))) { // do nothing go to the next line
                    continue;
                } else {
                    sale = new Sales();
                    ((Sales) sale).setCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((Sales) sale).setBankItemType(line.trim().split(" ", 2)[1]);
                    line = reader.readLine();
                    ((Sales) sale).setBankProductCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((Sales) sale).setReason(line.trim().split(" ", 2)[1]);

                    sales.add(sale);
                    line = reader.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public void loadFileCreditCardMovements(String data) {
        BufferedReader reader = null;
        CreditCardMovement creditCardMovement = null;

        try {

            reader = new BufferedReader(new FileReader(data));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("TRN_LIST") || (line.contains("{")) || (line.trim().equals("TRN"))
                        || (line.contains("}"))) { // do nothing go to the next line
                    continue;
                } else {
                    creditCardMovement = new CreditCardMovement();
                    ((CreditCardMovement) creditCardMovement)
                            .setEmplCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((CreditCardMovement) creditCardMovement).setCode(Integer.parseInt(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((CreditCardMovement) creditCardMovement)
                            .setMovementWorth(Double.parseDouble(line.trim().split(" ", 2)[1]));
                    line = reader.readLine();
                    ((CreditCardMovement) creditCardMovement).setReason(line.trim().split(" ", 2)[1]);

                    creditCardMovements.add(creditCardMovement);
                    line = reader.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public void WriteFilesCreditCardMovements(String data, int bankCode, int emplCode, double val, String reason) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(data));
            String line;
            writer = new BufferedWriter(new FileWriter(data, true));
            // while ((line = reader.readLine()).equals("}")) {
            // continue;
            // }
            writer.write("\t\tTRN\n\t{\n\t\tEMPLOYEE_CODE " + emplCode + "\n\t\tΒΑΝΚΙΤΕΜ_CODE " + bankCode
                    + "\n\t\tVAL " + val + "\n\t\tJUSTIFICATION " + reason + "\n\t}\n}");

            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void WriteFilesSales(String data, int salesmanCode, String bankItemType, int bankItemCode, String reason) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(data, true));

            writer.write("\t\tSALES\n\t{\n\t\tSALESMAN_CODE " + salesmanCode + "\n\t\tBANKITEM_TYPE " + bankItemType
                    + "\n\t\tBANKITEM_CODE " + bankItemCode + "\n\t\tJUSTIFICATION " + reason + "\n\t}\n}"); // writes
                                                                                                             // data

            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<CreditCards> getCreditCards() {
        return creditCards;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<CreditCardMovement> getCreditCardMovements() {
        return creditCardMovements;
    }

    public ArrayList<Sales> getSales() {
        return sales;
    }

    public ArrayList<Sellers> getSellers() {
        return sellers;
    }

    public boolean isFileExists(File file) {
        return file.exists();
    }

}

