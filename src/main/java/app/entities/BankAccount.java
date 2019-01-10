package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double currency;
    private double amount;
    private double amountOfCredit;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public BankAccount() {
    }

    public BankAccount(double currency, double amount, double amountOfCredit, Client client) {
        this.currency = currency;
        this.amount = amount;
        this.amountOfCredit = amountOfCredit;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(double amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
