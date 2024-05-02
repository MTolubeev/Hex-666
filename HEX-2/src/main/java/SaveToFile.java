import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    public static void saveToFile(String ourFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ourFile))) {

            for (int row = 0; row < MyFrame.model.getRowCount(); row++) {
                for (int col = 0; col < MyFrame.model.getColumnCount(); col++) {
                    Object value = MyFrame.model.getValueAt(row, col);
                    if (value == null || value == "null") {

                        continue;
                    }
                    String strValue = value.toString().replaceAll(" ", "");

                    writer.write((char) Integer.parseInt(strValue, 16));

                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
