import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("** Welcom to bank system **\n\n");
        System.out.println("enter your name: ");
        String name1 = scanner.next();
        System.out.println("enter your id: ");
        String numb = scanner.next();
        Customer customer = new Customer(name1, numb);
        BankAccount bankAccount = new BankAccount(numb);

        while (loop) {


            System.out.println("\n\nenter num:");
            System.out.println("1.deposit money");
            System.out.println("2.withdraw money");
            System.out.println("3.balance");
            System.out.println("4.exit");
            int input = scanner.nextInt();


            switch (input) {
                case 1: {
                    System.out.println("enter money you want deposit: ");
                    double money = scanner.nextDouble();
                    bankAccount.deposit(money);
                    break;
                }
                case 2: {
                    System.out.println("enter money you want withdraw: ");
                    double money = scanner.nextDouble();
                    bankAccount.withdraw(money);
                    break;
                }
                case 3: {
                    System.out.println(bankAccount.getBalance());
                    break;
                }

                case 4: {
                    loop = false;
                    break;
                }

                default:
                    System.out.println("enter correct num!");
            }
        }
    }
}
