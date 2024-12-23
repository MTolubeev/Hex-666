import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasteSelectionTest {

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
                    MyFrame.hexStr += (String) MyFrame.model.getValueAt(j, i) + " ";
                }
            }
        }
    }

    @Test
    public void testPasteSelection() {
        ArrayList<ArrayList<Object>> clipboardData = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("80");
        row1.add("81");
        clipboardData.add(row1);

        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("82");
        row2.add("83");
        clipboardData.add(row2);

        MyFrame.clipboardData = clipboardData;

        // Выбор начальной ячейки для вставки данных (например, 1, 1)
        MyFrame.table.setRowSelectionInterval(1, 1);
        MyFrame.table.setColumnSelectionInterval(1, 1);

        // Вызов метода вставки
        PasteSelection.pasteSelection();

        // Проверка, что данные корректно вставлены в таблицу
        assertEquals("80", MyFrame.table.getValueAt(1, 1));
        assertEquals("81", MyFrame.table.getValueAt(1, 2));
        assertEquals("82", MyFrame.table.getValueAt(2, 1));
        assertEquals("83", MyFrame.table.getValueAt(2, 2));
    }
    
}
