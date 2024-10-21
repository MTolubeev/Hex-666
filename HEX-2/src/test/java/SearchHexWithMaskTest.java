import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SearchHexWithMaskTest {

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
        System.out.println(MyFrame.hexStr);
    }

    @Test
    public void testSearchHexWithMaskFound() {
        String searchText = "66.79";

        MyFrame.rows = new ArrayList<>();
        MyFrame.cols = new ArrayList<>();

        SearchHexWithMask.searchHexWithMask(searchText);

        assertFalse(MyFrame.rows.isEmpty(), "Ряд должен содержать результаты поиска");
        assertFalse(MyFrame.cols.isEmpty(), "Колонка должна содержать результаты поиска");

        assertEquals(0, MyFrame.rows.get(0), "Неверная строка для результата поиска");
        assertEquals(1, MyFrame.cols.get(0), "Неверная колонка для результата поиска");
    }

    @Test
    public void testSearchHexWithMaskNotFound() {
        String searchText = "ZZ.ZZ";

        MyFrame.rows = new ArrayList<>();
        MyFrame.cols = new ArrayList<>();

        SearchHexWithMask.searchHexWithMask(searchText);
        assertTrue(MyFrame.rows.isEmpty(), "Результаты поиска должны быть пустыми");
        assertTrue(MyFrame.cols.isEmpty(), "Результаты поиска должны быть пустыми");
    }
}
