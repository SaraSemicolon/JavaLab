package Lab6;

class BankAccount extends CheckingAccount
{
    protected double balance;

    BankAccount(double balance)
    {
        setBalance(balance);
    }

    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}

    public void deposit (double amount)
    {
        balance += amount;
        transactionCount++;
    }

    public void withdraw(double amount)
    {
        if(amount> balance)
            return;
        balance -= amount;
        transactionCount++;
    }

    public void transfer (BankAccount account, double amount)
    {
        if(amount> balance)
            return;
        account.setBalance(getBalance() + amount);
        transactionCount++;
    }
}

class SavingsAccount extends BankAccount
{
    protected double interestRate;

    public SavingsAccount(double balance, double interestRate)
    {
        super(balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {return interestRate;}
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    public void addInterst ()
    {
        setBalance(balance + interestRate);
    }
}

class CheckingAccount
{
    protected int transactionCount;
    static protected int noOfFreeTransaction;
    static protected double transactionFees;

    protected BankAccount account;
    public CheckingAccount()
    {

    }
}

public class BankSystemApp
{
    public static void main(String[] args)
    {
        BankAccount [] accounts = new BankAccount[3];
        accounts[0] = new SavingsAccount(5000,1.3);
        accounts[1] = new CheckingAccount()

    }
}
