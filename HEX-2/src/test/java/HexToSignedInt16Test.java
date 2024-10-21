import org.junit.jupiter.api.*;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class HexToSignedInt16Test {
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
    Rectangle cellRect = MyFrame.table.getCellRect(0, 0, true);  // Получаем прямоугольник ячейки
    MyFrame.point = new Point();
    MyFrame.point.setLocation(cellRect.x, cellRect.y);

}
    @Test
    void hexToSignedInt16() {
    HexToSignedInt16.hexToSignedInt16();
    assertEquals("26215", MyFrame.third.getText());
    }
}