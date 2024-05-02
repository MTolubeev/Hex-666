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
                    for (int col = 0; col < MyFrame.model.getColumnCount(); col++) {
                        Object value = MyFrame.model.getValueAt(row, col);
                        if (value == null || value == "null") {
                            writer.write(' ');
                            continue;
                        }
                        String strValue = value.toString().replaceAll(" ", "");

                        writer.write((char) Integer.parseInt(strValue, 16));

                    }
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "File saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
