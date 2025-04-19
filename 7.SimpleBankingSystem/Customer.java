public class Customer {
    private String name;
    private BankAcc account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAcc(accountNumber);
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }
}