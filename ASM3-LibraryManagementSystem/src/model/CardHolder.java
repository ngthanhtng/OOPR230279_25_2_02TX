package model;

public abstract class CardHolder extends Reader {

    public CardHolder(String fullName, String email) {
        super(fullName, email);
    }

    public void renewCard(int months) {
        System.out.println("Renewing card " + months + " months for " + getFullName());
    }
}