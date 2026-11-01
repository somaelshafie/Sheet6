import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Simple_Bank {
    public static void main(String[] args){

        ArrayList<BankAccount> accounts = new ArrayList<>();

        SavingsAccount s1 = new SavingsAccount(1000, 0.10);
        SavingsAccount s2 = new SavingsAccount(2000, 0.05);

        CheckingAccount c1 = new CheckingAccount(3000);
        CheckingAccount c2 = new CheckingAccount(4000);

        accounts.add(s1);
        accounts.add(s2);
        accounts.add(c1);
        accounts.add(c2);

        s1.deposit(500);
        s1.withdraw(200);

        s2.deposit(300);
        s2.withdraw(100);

        s1.addInterest();
        s2.addInterest();

        c1.transfer(s1, 500);
        c1.transfer(c2, 300);

        c1.deductFees();
        c2.deductFees();

        System.out.println("Balances after operations:");

        for(int i=0; i<accounts.size(); i++){
            System.out.println(accounts.get(i).getBalance());
        }

        Collections.sort(accounts, new Comparator<BankAccount>(){
            @Override
            public int compare(BankAccount a, BankAccount b){
                return Double.compare(b.getBalance(), a.getBalance());
            }
        });

        System.out.println("Descending order:");

        for(int i=0; i<accounts.size(); i++){
            System.out.println(accounts.get(i).getBalance());
        }
    }
}

class BankAccount{
    private double balance;

    BankAccount(double balance){
        this.balance=balance;
    }

    void setBalance(double balance){
        this.balance=balance;
    }

    double getBalance(){
        return balance;
    }

    void deposit(double amount){
        balance=balance+amount;
    }

    void withdraw(double amount){
        if(amount <= balance){
            balance=balance-amount;
        }
    }

    void transfer(BankAccount account, double amount){
        if(amount <= balance){
            balance=balance-amount;
            account.deposit(amount);
        }
    }
}

class SavingsAccount extends BankAccount{
    private double interestRate;

    SavingsAccount(double balance, double interestRate){
        super(balance);
        this.interestRate=interestRate;
    }

    void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }

    double getInterestRate(){
        return interestRate;
    }

    void addInterest(){
        double interest=getBalance()*interestRate;
        deposit(interest);
    }
}

class CheckingAccount extends BankAccount{
    private int transactionCount;

    static int noOfFreeTransaction=3;
    static double transactionFees=10;

    CheckingAccount(double balance){
        super(balance);
        transactionCount=0;
    }

    @Override
    void deposit(double amount){
        super.deposit(amount);
        transactionCount++;
    }

    @Override
    void withdraw(double amount){
        super.withdraw(amount);
        transactionCount++;
    }

    @Override
    void transfer(BankAccount account, double amount){
        super.transfer(account, amount);
        transactionCount++;
    }

    void deductFees(){
        int extraTransactions=transactionCount-noOfFreeTransaction;

        if(extraTransactions > 0){
            double fees=extraTransactions*transactionFees;
            withdraw(fees);
        }

        transactionCount=0;
    }
}
