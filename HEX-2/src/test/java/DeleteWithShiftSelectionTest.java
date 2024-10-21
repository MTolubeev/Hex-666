import org.junit.jupiter.api.*;

import javax.swing.*;

import java.sql.SQLOutput;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class DeleteWithShiftSelectionTest {
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
    void deleteWithShiftSelection() {
        MyFrame.table.setRowSelectionInterval(1, 1);
        MyFrame.table.setColumnSelectionInterval(0, 1);

        assertNotNull(MyFrame.model.getValueAt(1, 0));
        assertNotNull(MyFrame.model.getValueAt(1, 1));


        String tst1 = (String) MyFrame.model.getValueAt(1, 2);
        String tst2 = (String) MyFrame.model.getValueAt(1, 3);


        DeleteWithShiftSelection.deleteWithShiftSelection();

        assertEquals(MyFrame.model.getValueAt(1, 0), tst1);
        assertEquals(MyFrame.model.getValueAt(1, 1), tst2);

    }
}