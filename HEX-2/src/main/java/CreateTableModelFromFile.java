import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateTableModelFromFile {
    public static DefaultTableModel createTableModelFromFile(String filename) {
        MyFrame.model = new DefaultTableModel();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // Создаем первую строку в таблице
            String[] header = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            MyFrame.model.setColumnIdentifiers(header);
            MyFrame.model.addRow(new Object[16]);
            int row = 0;
            int col = 0;
            // Чтение символов из файла и добавление их в таблицу
            while ((MyFrame.line = reader.readLine()) != null) {
                MyFrame.lineValue = MyFrame.line.getBytes();
                for (byte c : MyFrame.lineValue) {
                    MyFrame.model.setValueAt(String.format("%02X ", (int) c), row, col);
                    col++;
                    // Если достигли конца строки, переходим на следующую строку
                    if (col >= 16) {
                        MyFrame.model.addRow(new Object[16]);
                        row++;
                        col = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка чтения файла: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        return MyFrame.model;
    }
}
