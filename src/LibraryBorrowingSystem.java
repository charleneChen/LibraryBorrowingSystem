import controller.LibraryController;
import model.BorrowingInventory;
import view.LibraryView;

/**
 *
 * @author xlian/charlene
 */
public class LibraryBorrowingSystem {
    public static void main(String[] args) {
        LibraryView view = new LibraryView();
        BorrowingInventory model = new BorrowingInventory();
        LibraryController controller = new LibraryController(model, view);

        controller.run();
    }
}
