package model;

public class LibraryCard extends DigitalAccount {

    private String rfidCode;

    public LibraryCard(String accountId, String displayName, String rfidCode) {
        super(accountId, displayName);
        this.rfidCode = rfidCode;
    }

    @Override
    public boolean authenticate(String credential) {
        return rfidCode.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 2;
    }
}