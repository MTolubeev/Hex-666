import org.junit.jupiter.api.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CopySelectionTest {
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
    public void testCopySelection() throws InterruptedException {
        MyFrame.table.setRowSelectionInterval(1, 2);
        MyFrame.table.setColumnSelectionInterval(0, 1);

        CopySelection.copySelection();
        ArrayList<ArrayList<Object>> clipboardData = MyFrame.clipboardData;
        assertNotNull(clipboardData, "Clipboard data should not be null");
        assertEquals(2, clipboardData.size(), "There should be two rows copied");

        for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
            ArrayList<Object> row = clipboardData.get(rowIndex);
            assertEquals(2, row.size(), "Each row should have 2 columns copied");
            for (int colIndex = 0; colIndex < 2; colIndex++) {

                String expectedValue = String.valueOf(clipboardData.get(rowIndex).get(colIndex));
                Object actualValue = row.get(colIndex);
                assertEquals(expectedValue, actualValue, "Value at row " + rowIndex + ", col " + colIndex + " is incorrect");
            }
        }
    }

}