package model;

public class StudentAccount extends DigitalAccount {

    private String password;

    public StudentAccount(String accountId, String displayName, String password) {
        super(accountId, displayName);
        this.password = password;
    }

    @Override
    public boolean authenticate(String credential) {
        return password.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 3;
    }
}