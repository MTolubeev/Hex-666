//import javax.swing.*;

import javax.swing.*;

public class PasteWithShift {
    public static void pasteWithShift() {
        int selectedRow = MyFrame.table.getSelectedRow();
        int selectedColumn = MyFrame.table.getSelectedColumn();
        int insertLength = 0;
        if (selectedRow == -1 || selectedColumn == -1) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите ячейку для вставки.");
        }
        if (MyFrame.clipboardData.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Буфер обмена пуст.");
        }
        for (int s = 0; s < MyFrame.clipboardData.size(); s++) {
            for (int k = 0; k < MyFrame.clipboardData.get(s).size(); k++) {
                insertLength++;
            }
        }
        int insertIndex = selectedRow * 16 + selectedColumn;
        int totalCells = MyFrame.table.getRowCount() * 16;
        while (MyFrame.lineValue.length + insertLength > totalCells) {
            MyFrame.model.addRow(new Object[16]);
            totalCells = MyFrame.table.getRowCount() * 16;
        }

        ShiftRight.shiftRight(insertIndex, MyFrame.clipboardData.get(0).size());
        InsertTextAtIndex.insertTextAtIndex(selectedRow, selectedColumn);

    }
}
