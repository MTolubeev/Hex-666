import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.util.ArrayList;

public class SearchHexTest {

    @BeforeEach
    public void setUp() throws InterruptedException {

        MyFrame.myFrame();
        if (MyFrame.table == null) {
            MyFrame.table = new JTable();
        }
        CreateTableModelFromFile loader = new CreateTableModelFromFile("C:\\Users\\lecto\\OneDrive\\Desktop\\для hexa\\Hex-666\\HEX-2\\src\\test\\TestFile");
        Thread.sleep(5);
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
    public void testSearchHexFound() {
        String searchText = "66";

        MyFrame.rows = new ArrayList<>();
        MyFrame.cols = new ArrayList<>();

        SearchHex.searchHex(searchText);

        assertFalse(MyFrame.rows.isEmpty(), "Ряд должен содержать результаты поиска");
        assertFalse(MyFrame.cols.isEmpty(), "Колонка должна содержать результаты поиска");

        assertEquals(0, MyFrame.rows.get(0), "Неверная строка для результата поиска");
        assertEquals(1, MyFrame.cols.get(0), "Неверная колонка для результата поиска");
    }

    @Test
    public void testSearchHexNotFound() {
        String searchText = "ZZ";

        MyFrame.rows = new ArrayList<>();
        MyFrame.cols = new ArrayList<>();

        SearchHex.searchHex(searchText);

        assertTrue(MyFrame.rows.isEmpty(), "Результаты поиска должны быть пустыми");
        assertTrue(MyFrame.cols.isEmpty(), "Результаты поиска должны быть пустыми");
    }
}
