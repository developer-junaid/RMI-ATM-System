import java.io.Serializable;

// For Creating Users
public class User implements Serializable {
    private String username;
    private String password;
    private int amount;

    public User(String username, String password, int amount) {
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAmount() {
        return this.amount;
    }

    public void depositAmount(int amountToDeposit) {
        this.amount += amountToDeposit;
    }

}
