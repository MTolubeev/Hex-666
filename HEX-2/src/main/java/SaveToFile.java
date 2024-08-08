import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    public static void saveToFile(String ourFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ourFile))) {
            for (int row = 0; row < MyFrame.model.getRowCount(); row++) {
                StringBuilder lineBuilder = new StringBuilder();

                for (int col = 0; col < MyFrame.model.getColumnCount(); col++) {
                    Object value = MyFrame.model.getValueAt(row, col);
                    if (value == null || value.toString().trim().isEmpty()) {
                        continue; // Игнорируем null значения
                    }

                    String strValue = value.toString().replaceAll(" ", ""); // Убираем пробелы

                    // Преобразуем шестнадцатеричное значение в байт и затем в символ
                    char character = (char) Integer.parseInt(strValue, 16);
                    lineBuilder.append(character); // Добавляем символ к строке
                }

                if (lineBuilder.length() > 0) {
                    writer.write(lineBuilder.toString()); // Записываем строку в файл
                    writer.newLine(); // Переход на новую строку
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка сохранения файла: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}