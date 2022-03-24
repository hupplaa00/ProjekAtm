package projek;

public class User {
    private String username;
    private int pin;

    public User(String username, int pin){
        this.username = username;
        this.pin = pin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public int getPin() {
        return pin;
    }

}
