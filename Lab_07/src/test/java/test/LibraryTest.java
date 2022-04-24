package test;

import Library.Book;
import Library.Library;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public class LibraryTest extends Assert {
    Book book1 = new Book("Java", "John", 2002);
    Book book2 = new Book("C++", "John", 2003);


    // TODO TestNG является более гибким благодаря своим аннотациям

    // @Before method - аннотированный метод будет выполняться перед каждым тестовым методом
    @BeforeMethod
    public void setUp() {
        System.out.println("-------@Before method-------");
    }

    // @After method - аннотированный метод будет выполняться после каждого тестового метода
    @AfterMethod
    public void tearDown() {
        System.out.println("-------@After method-------");
    }

    // @Before test - аннотированный метод будет выполняться перед любым тестовым методом
    @BeforeTest
    public void beforeTest() {
        System.out.println("-------@Before test-------");
    }

    // @After test - аннотированный метод будет выполняться после всех тестовых методов
    @AfterTest
    public void afterTest() {
        System.out.println("-------@After test-------");
    }

    // @Before groups - аннотированный метод будет выполняться перед каждым групповым тестом
    @BeforeGroups
    public void beforeGroups() {
        System.out.println("-------@Before groups-------");
    }

    // @After groups - аннотированный метод будет выполняться после каждого группового теста
    @AfterGroups
    public void afterGroups() {
        System.out.println("-------@After groups-------");
    }

    // @Before class - аннотированный метод будет выполняться перед каждым классом тестов
    @BeforeClass
    public void beforeClass() {
        System.out.println("-------@Before class-------");
    }

    // @After class - аннотированный метод будет выполняться после каждого класса тестов
    @AfterClass
    public void afterClass() {
        System.out.println("-------@After class-------");
    }

    // @Before suite - аннотированный метод будет выполняться перед запуском всех тестов
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("-------@Before suite-------");
    }

    // @After suite - аннотированный метод будет выполняться после завершения всех тестов
    @AfterSuite
    public void afterSuite() {
        System.out.println("-------@After suite-------");
    }


    //TODO ГРУППОВЫЕ ТЕСТЫ (чтобы тестовые методы выполнялись по очереди группами)

    @Test(groups = {"unit"})
    public void testAddBooks() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);

        Assert.assertNotNull(books);
    }

    // запуска метода тестирования в отдельном потоке. Если тест длится дольше отведенного времени ожидания,
    // тест завершится неудачей, и модуль прервет поток, выполняющий тест
    @Test(timeOut = 1000)
    public void testCompareBooks() {
        ArrayList<Book> books = Book.getBooks();
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        Assert.assertEquals(books, library.getLibrary());
        //Thread.sleep(2000);
    }

    // если нужно прогнать тесты группами, например, чтобы тестовые методы выполнялись по очереди группами
    @Test(groups = {"unit"})
    public void testRemoveBook() throws NullPointerException {
        Library library = new Library();
        library.addBook(book1);
        library.removeBook(book2);

        Assert.assertNotNull(library.getLibrary());
    }

    @Test(groups = {"unit"})
    public void testRemoveBook2() throws NullPointerException {
        Library library = new Library();
        library.addBook(book1);
        library.removeBook(book1);

        Assert.assertNotNull(library.getLibrary());
    }

    // чтобы проигнорировать тестовый метод, вам достаточно указать в параментре false
    @Test(enabled = false)
    public void testAddBooksIgnore() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);

        Assert.assertNotNull(books);
    }

    // методы, от которых зависит, сначала будут выполнены они, а затем данный метод
    @Test(dependsOnMethods = {"testAddBooks"})
    public void testAddBooksDependsOn() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);

        Assert.assertNotNull(books);
    }
}


