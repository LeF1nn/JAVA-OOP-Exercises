public class Book {
    private String title;
    private String author;
    private boolean isAvalible;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvalible = true;
    }

    public void borrowBook() {
        if (isAvalible) {
            isAvalible = false;
        }
    }

    public void returnBook() {
        isAvalible = true;
    }

    public boolean isAvailable() {
        return isAvalible;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void showInfo() {
        System.out.println("Book name --> " + getTitle() + "Author--> " + getAuthor() + "isAvailabe--> " + isAvailable());
    }
}

