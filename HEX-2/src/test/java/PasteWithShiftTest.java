import org.junit.jupiter.api.*;
import javax.swing.*;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
public class PasteWithShiftTest {

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
        MyFrame.hexStr = "";

        for (int j = 0; j < MyFrame.model.getRowCount(); j++) {
            for (int i = 0; i < MyFrame.model.getColumnCount(); i++) {
                if (MyFrame.model.getValueAt(j, i) != null) {
                    MyFrame.hexStr = MyFrame.hexStr + (String) MyFrame.model.getValueAt(j, i) + " ";
                }
            }
        }
        MyFrame.lineValue = new byte[MyFrame.model.getRowCount() * 16];
    }

    @Test
    public void testPasteWithShift() throws InterruptedException {
        MyFrame.clipboardData = new ArrayList<>();
        ArrayList<Object> row = new ArrayList<>();
        row.add("66");
        row.add("67");
        MyFrame.clipboardData.add(row);

        MyFrame.table.setRowSelectionInterval(0, 0);
        MyFrame.table.setColumnSelectionInterval(0, 0);

        String tst1 = (String) MyFrame.model.getValueAt(0, 0);
        String tst2 = (String) MyFrame.model.getValueAt(0, 1);

        int initialRowCount = MyFrame.table.getRowCount();

        PasteWithShift.pasteWithShift();

        assertTrue(MyFrame.table.getRowCount() >= initialRowCount, "Количество строк должно увеличиться при необходимости");

        assertEquals("66", MyFrame.table.getValueAt(0, 0), "Первое значение должно быть вставлено");
        assertEquals("67", MyFrame.table.getValueAt(0, 1), "Второе значение должно быть вставлено");


        assertEquals(MyFrame.model.getValueAt(0, 2), tst1);
        assertEquals(MyFrame.model.getValueAt(0, 3), tst2);
    }
}
