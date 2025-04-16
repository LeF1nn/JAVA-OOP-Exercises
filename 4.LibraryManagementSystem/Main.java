import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!\nEnter your name; ");
        String name = scanner.nextLine();
        User user = new User(name);
        System.out.println("Welcome " + user.getName());
        boolean def = true;

        while (def) {
            System.out.println("\n\nEnter number: ");
            System.out.println("1.add book");
            System.out.println("2.remove book");
            System.out.println("3.borrow book");
            System.out.println("4.retrun book");
            System.out.println("5.show all book and author");
            System.out.println("6.exit");
            int num = scanner.nextInt();
            scanner.nextLine();

            switch (num){
                case 1:{
                    System.out.println("Enter book name and author name: ");
                    String bookName = scanner.nextLine();
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookName , authorName);
                    admin.addBook(book);
                    break;
                }
                case 2:{
                    System.out.println("Enter book name and author name: ");
                    String bookName = scanner.nextLine();
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookName , authorName);
                    admin.removeBook(book);
                    break;
                }
                case 3:{
                    System.out.println("Enter book name and author name: ");
                    String bookName = scanner.nextLine();
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookName , authorName);
                    user.borrowBook(book);
                    break;
                }
                case 4:{
                    System.out.println("Enter book name and author name: ");
                    String bookName = scanner.nextLine();
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookName , authorName);
                    user.returnBook(book);
                    break;
                }
                case 5:{

                    break;
                }
                case 6:{
                    def = false;
                }
                default:
                    System.out.println("enter correct number");
            }
        }
    }
}
