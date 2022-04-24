package Library;

import java.util.ArrayList;

public class Library implements ILibrary{
    private final ArrayList<Book> library;

    // наполняем библиотеку книгами
    public Library() {
        library = new ArrayList<>();
    }

    // добавляем книгу в библиотеку
    @Override
    public void addBook(Book book) {
        library.add(book);
    }

    // удаляем книгу из библиотеки
    @Override
    public void removeBook(Book book) {
        library.remove(book);
    }

    // получаем библиотеку с книгами
    public ArrayList<Book> getLibrary() {
        return library;
    }
}
