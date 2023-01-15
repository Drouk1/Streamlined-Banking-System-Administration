import java.util.*;

public class Sellers {
    private int afm;
    private String firstName;
    private String lastName;
    private int code;
    int seller_num = 0;

    HashMap<Integer, Sellers> sellersMap = new HashMap<Integer, Sellers>();

    void addSellers(Sellers info) {
        sellersMap.put(seller_num, info);
        seller_num++;
    }

    public Sellers(String firstName, String lastName, int afm, int code) {
        this.afm = afm;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Sellers() {

    }

    public Sellers(Sellers source) {
        this.afm = source.afm;
        this.code = source.code;
        this.firstName = source.firstName;
        this.lastName = source.lastName;
    }

    public int getAfm() {
        return this.afm;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getCode() {
        return this.code;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nCode: " + this.code + "\nAFM: "
                + this.afm + "\n";
    }

    void printSellers() {
        for (int i : sellersMap.keySet()) {
            System.out.println("Seller ID:" + i + sellersMap.get(i));
        }
    }

}
