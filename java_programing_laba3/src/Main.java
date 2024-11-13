class PrintedEdition {
    String title;

    PrintedEdition(String title) {
        this.title = title;
    }
}

// Клас книга похідна від друковане видання
class Book extends PrintedEdition {
    Book(String title) {
        super(title);
    }
}

// Клас журнал похідний від друковане видання
class Magazine extends PrintedEdition {
    Magazine(String title) {
        super(title);
    }
}

// Клас книжковий магазин де підраховуеться кільність книг та журналів
class Bookstore {
    PrintedEdition[] editions;
    int count;

    Bookstore(int capacity) {
        editions = new PrintedEdition[capacity];
        count = 0;
    }

    void addEdition(PrintedEdition edition) {
        if (count < editions.length) {
            editions[count++] = edition;
        }
    }

    int countBooks() {
        int books = 0;
        for (PrintedEdition edition : editions) {
            if (edition instanceof Book) {
                books++;
            }
        }
        return books;
    }

    int countMagazines() {
        int magazines = 0;
        for (PrintedEdition edition : editions) {
            if (edition instanceof Magazine) {
                magazines++;
            }
        }
        return magazines;
    }
}

public class Main {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore(5);

        bookstore.addEdition(new Book("Зеленая миля"));
        bookstore.addEdition(new Magazine("Журнал зроби сам"));
        bookstore.addEdition(new Book("Автостопом по галактике"));
        bookstore.addEdition(new Magazine("Forbs"));

        System.out.println("Кількість книг: " + bookstore.countBooks());
        System.out.println("Кількість журналів: " + bookstore.countMagazines());
    }
}
