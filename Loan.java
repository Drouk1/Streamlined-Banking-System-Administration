import java.util.HashMap;

public class Loan extends BankProducts {

    private double amountOfLoan;
    private double annualInterestRate;
    int loan_num = 0;

    public Loan(int code, int number, int afm, String type, String describe, double amountOfLoan,
            double annualInterestRate) {
        super(code, number, afm, type, describe);
        this.amountOfLoan = amountOfLoan;
        this.annualInterestRate = annualInterestRate;
    }

    public Loan() {
    }

    HashMap<Integer, Loan> loanMap = new HashMap<Integer, Loan>();

    void addLoan(Loan info) {
        loanMap.put(getCode(), info);
        loan_num++;
    }

    public String toString() {
        return "Code: " + getCode() + "\nNumber: " + getNumber() + "\nAFM: " + getAfm() + "\namount of loan: "
                + this.amountOfLoan + "\nMax annual interest rate: " + this.annualInterestRate + "\n";
    }

    public void ainTA3() {
        System.out.println(loanMap);
    }

    public double getAmountOfLoan() {
        return this.amountOfLoan;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAmountOfLoan(double amountOfLoan) {
        this.amountOfLoan = amountOfLoan;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
