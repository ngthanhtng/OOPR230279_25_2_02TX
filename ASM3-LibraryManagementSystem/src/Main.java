import service.Librarian;
import service.Library;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian();

        Menu menu = new Menu(library, librarian);
        menu.start();
    }
}
