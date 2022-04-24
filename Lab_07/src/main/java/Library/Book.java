package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Book {
    private String title;
    private String author;
    private int year;
    private static Map<Integer, Book> books;
    private static int count = 0;
    private int id;

    public Book(String title, String author, String genre, int year, int pages, int borrowed, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book(String title, String author, int year) {
        if (books == null) {
            books = new HashMap<>();
        }
        this.title = title;
        this.author = author;
        this.year = year;

        // проверяем есть ли такая книга
        if (!hasBook()) {
            count++;
            this.id = count;
            books.put(this.id, this);
        }
    }

    // возвращаем книгу по id
    public static ArrayList<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    // проверяем есть ли такая книга
    private boolean hasBook() {
        return books.containsValue(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
