import org.junit.jupiter.api.*;

import javax.swing.*;

import java.sql.SQLOutput;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class DeleteSelectionTest {
    @BeforeEach
    public void setUp() throws InterruptedException {
        MyFrame.myFrame();
        if (MyFrame.table == null) {
            MyFrame.table = new JTable();
        }
        CreateTableModelFromFile loader = new CreateTableModelFromFile("C:\\Users\\lecto\\OneDrive\\Desktop\\для hexa\\Hex-666\\HEX-2\\src\\test\\TestFile");
        sleep(5);
        MyFrame.model = loader.getModel();
        MyFrame.table.setModel(MyFrame.model);

    }

    @Test
    public void testDeleteSelection() {
        MyFrame.table.setRowSelectionInterval(1, 2);
        MyFrame.table.setColumnSelectionInterval(0, 1);

        assertNotNull(MyFrame.model.getValueAt(1, 0));
        assertNotNull(MyFrame.model.getValueAt(1, 1));
        assertNotNull(MyFrame.model.getValueAt(2, 0));
        assertNotNull(MyFrame.model.getValueAt(2, 1));

        DeleteSelection.deleteSelection();

        assertNull(MyFrame.model.getValueAt(1, 0), "Value at row 1, col 0 should be deleted");
        assertNull(MyFrame.model.getValueAt(1, 1), "Value at row 1, col 1 should be deleted");
        assertNull(MyFrame.model.getValueAt(2, 0), "Value at row 2, col 0 should be deleted");
        assertNull(MyFrame.model.getValueAt(2, 1), "Value at row 2, col 1 should be deleted");

    }
}