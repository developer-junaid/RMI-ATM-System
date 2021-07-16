import java.io.Serializable;

// For Creating Users
public class User implements Serializable {
    private String username;
    private String password;
    private int amount;

    public User(String usernameInput, String passwordInput, int amountInput) {
        username = usernameInput;
        password = passwordInput;
        amount = amountInput;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAmount() {
        return amount;
    }

}
