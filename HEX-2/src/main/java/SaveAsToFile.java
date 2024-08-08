import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsToFile {
    public static void saveAsToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int row = 0; row < MyFrame.model.getRowCount(); row++) {
                    StringBuilder lineBuilder = new StringBuilder();

                    for (int col = 0; col < MyFrame.model.getColumnCount(); col++) {
                        Object value = MyFrame.model.getValueAt(row, col);
                        if (value == null || value.toString().trim().isEmpty()) {
                            continue;
                        }

                        String strValue = value.toString().replaceAll(" ", "");


                        char character = (char) Integer.parseInt(strValue, 16);
                        lineBuilder.append(character);
                    }

                    if (lineBuilder.length() > 0) {
                        writer.write(lineBuilder.toString());
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка сохранения файла: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
