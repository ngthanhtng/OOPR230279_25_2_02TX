package model;

public class LecturerAccount extends DigitalAccount {

    private String otp;

    public LecturerAccount(String accountId, String displayName, String otp) {
        super(accountId, displayName);
        this.otp = otp;
    }

    @Override
    public boolean authenticate(String credential) {
        return otp.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return -1;
    }
}