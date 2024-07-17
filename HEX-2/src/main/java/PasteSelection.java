public class PasteSelection {
    public static void pasteSelection() {
        int startRow = MyFrame.table.getSelectedRow();
        int startCol = MyFrame.table.getSelectedColumn();
        if (startRow == -1 || startCol == -1) {
            startRow = 0;
            startCol = 0;
        }

        int rowsToAdd = MyFrame.clipboardData.size();
        int colsToAdd = MyFrame.clipboardData.isEmpty() ? 0 : MyFrame.clipboardData.get(0).size();

        int endRow = startRow + rowsToAdd - 1;
        int endCol = startCol + colsToAdd - 1;

        if (endRow >= MyFrame.table.getRowCount()) {
            MyFrame.model.setRowCount(endRow + 1);
        }
        if (endCol >= MyFrame.table.getColumnCount()) {
            MyFrame.model.setColumnCount(endCol + 1);
        }
        for (int i = 0; i < MyFrame.clipboardData.size(); i++) {
            for (int j = 0; j < MyFrame.clipboardData.get(i).size(); j++) {
                int row = startRow + i;
                int col = startCol + j;
                if (row < MyFrame.table.getRowCount() && col < MyFrame.table.getColumnCount()) {
                    MyFrame.table.setValueAt(MyFrame.clipboardData.get(i).get(j), row, col);
                } else {
                    MyFrame.model.addRow(new Object[]{MyFrame.clipboardData.get(i).get(j)});
                }
            }
        }
    }
}
