import java.util.*;

public class Sales {

    private int code;
    private int BankProductCode;
    private String reason;
    private String bankItemType;
    int sales_num = 0;

    HashMap<Integer, Sales> salesMap = new HashMap<Integer, Sales>();

    void addSales(int seller_code, Sales info) {
        salesMap.put(seller_code, info);
        sales_num++;
    }

    public HashMap<Integer, Sales> getsalesMap() {
        return salesMap;
    }

    // Constructor

    public Sales(int code, int BankProductCode, String reason, String bankItemType) {
        this.code = code;
        this.BankProductCode = BankProductCode;
        this.reason = reason;

    }

    public Sales() {

    }

    // Getters

    public int getCodeS() {
        return this.code;
    }

    public int getBankProductCode() {
        return this.BankProductCode;
    }

    public String getreason() {
        return this.reason;
    }

    // Setters

    public void setCode(int code) {
        this.code = code;
    }

    public void setBankProductCode(int BankProductCode) {
        this.BankProductCode = BankProductCode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setBankItemType(String bankItemType) {
        this.bankItemType = bankItemType;
    }

    // Copy Constructor

    public Sales(Sales source) {
        this.code = source.code;
        this.BankProductCode = source.BankProductCode;
        this.reason = source.reason;
    }

    public String toString() {
        return "Sale Code: " + getCodeS() + "\nBankproduct: " + getBankProductCode() + "\nReason: " + getreason();
    }

    void printSales() {
        System.out.println(salesMap);
    }
}

