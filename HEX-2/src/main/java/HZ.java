import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HZ {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Таблица с выделением и редактированием");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[][]{{"Ячейка 1", "Ячейка 2"},
                            {"Ячейка 3", "Ячейка 4"},},
                    new Object[]{"Колонка 1", "Колонка 2"});
            JTable table = new JTable(model);



            table.addMouseListener(   new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    int col = table.columnAtPoint(e.getPoint());
                    if (e.getClickCount() == 1) {                        // Выделяем ячейку при одиночном нажатии
                        table.changeSelection(row, col, false, false);
                    } else if (e.getClickCount() == 2 && !table.isEditing()) {
                        // Начинаем редактирование при двойном нажатии
                        System.out.println(" mi yuy");
                        table.editCellAt(row, col);
                    }
                }
            });

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}