package model;

public class GuestAccount extends DigitalAccount {

    public GuestAccount(String accountId, String displayName) {
        super(accountId, displayName);
    }

    @Override
    public boolean authenticate(String credential) {
        return true;
    }

    @Override
    public int getDownloadLimit() {
        return 1;
    }
}