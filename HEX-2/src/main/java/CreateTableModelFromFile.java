import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateTableModelFromFile {
    private static final int CHUNK_SIZE = 30; // Количество строк, загружаемых за один раз
    private RandomAccessFile file;
    private int currentRow = 0;
    public CreateTableModelFromFile(String filename) {
        try {
            file = new RandomAccessFile(new File(filename), "rw");
            MyFrame.model = new DefaultTableModel();
            // Устанавливаем заголовки столбцов
            String[] header = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            MyFrame.model.setColumnIdentifiers(header);
            // Запуск нового потока для загрузки данных
            startLoading();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка чтения файла: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel getModel() {
        return MyFrame.model;
    }

    private void startLoading() {
        new Thread(() -> {
            while (loadMoreRows()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }

            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private boolean loadMoreRows() {

        for (int i = MyFrame.model.getRowCount(); i < currentRow + CHUNK_SIZE; i++) {
            MyFrame.model.addRow(new Object[16]);
        }

        try {
            byte[] buffer = new byte[16];
            int bytesRead;
            int rowsLoaded = 0;
            while (rowsLoaded < CHUNK_SIZE && (bytesRead = file.read(buffer)) != -1) {
                MyFrame.lineValue = buffer.clone();

                for (int i = 0; i < bytesRead; i++) {
                    MyFrame.model.setValueAt(String.format("%02X", buffer[i]), currentRow, i);
                }

                for (int i = bytesRead; i < 16; i++) {
                    MyFrame.model.setValueAt("", currentRow, i);
                }

                currentRow++;
                rowsLoaded++;
            }

            return rowsLoaded > 0;

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка чтения файла: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}