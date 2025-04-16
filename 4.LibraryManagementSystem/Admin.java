import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Book> books;

    public Admin() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("book added--> " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("book remove--> " + book.getTitle());
    }

    public void showAll() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}

