import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class InsertTextAtIndexTest {
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
    }
    @Test
    public void testInsertTextAtIndex() {
        // Подготовка данных для буфера обмена
        ArrayList<ArrayList<Object>> clipboardData = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("66");
        row1.add("67");
        clipboardData.add(row1);

        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("68");
        row2.add("69");
        clipboardData.add(row2);

        MyFrame.clipboardData = clipboardData;

        // Вставка данных в таблицу на индекс 0,0
        InsertTextAtIndex.insertTextAtIndex(0, 0);

        // Проверка, что данные корректно вставлены в таблицу
        assertEquals("66", MyFrame.table.getValueAt(0, 0));
        assertEquals("67", MyFrame.table.getValueAt(0, 1));
        assertEquals("68", MyFrame.table.getValueAt(1, 0));
        assertEquals("69", MyFrame.table.getValueAt(1, 1));
    }
}