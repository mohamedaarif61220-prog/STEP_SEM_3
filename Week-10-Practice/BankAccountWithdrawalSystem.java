import java.util.HashMap;
import java.util.Map;

abstract class BankAccount {
    String id;
    protected int balance;

    BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract boolean withdraw(int amount);
    abstract String getRejectionReason();

    int getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (amount <= 0 || balance - amount < 1000) {
            return false;
        }
        balance -= amount;
        return true;
    }

    String getRejectionReason() {
        return "minimum balance 1000";
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (amount <= 0 || balance - amount < -5000) {
            return false;
        }
        balance -= amount;
        return true;
    }

    String getRejectionReason() {
        return "overdraft limit 5000";
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();

        accounts.put("S1", new SavingsAccount("S1", 5000));
        accounts.put("C1", new CurrentAccount("C1", 2000));

        withdraw(accounts, "S1", 4500);
        withdraw(accounts, "C1", 6000);
        withdraw(accounts, "S1", 3000);
        withdraw(accounts, "C1", 2000);
        withdraw(accounts, "X1", 100);
    }

    static void withdraw(Map<String, BankAccount> accounts,
                         String id, int amount) {
        BankAccount account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println(id + " balance " + account.getBalance());
        } else {
            System.out.println(id + " rejected: "
                + account.getRejectionReason());
        }
    }
}