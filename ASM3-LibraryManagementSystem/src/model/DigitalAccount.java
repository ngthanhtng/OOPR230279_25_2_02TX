package model;

public abstract class DigitalAccount {

    protected String accountId;
    protected String displayName;

    public DigitalAccount(String accountId,
                          String displayName) {

        this.accountId = accountId;
        this.displayName = displayName;
    }

    public abstract boolean authenticate(
            String credential);

    public abstract int getDownloadLimit();

    public boolean requestDownload(int downloadsToday) {
        int limit = getDownloadLimit();

        if (limit == -1 || downloadsToday <= limit) {
            System.out.println("Download successful: "
                            + (downloadsToday) + "/" + (limit == -1 ? "∞" : limit));
            return true;
        }

        System.out.println("Download limit reached!");
        return false;
    }
}