public class InsertTextAtIndex {
    public static void insertTextAtIndex(int selectedRow, int selectedColumn) {
        for (int i = 0; i < MyFrame.clipboardData.size(); i++) {
            for (int j = 0; j < MyFrame.clipboardData.get(i).size(); j++) {
                int row = selectedRow + i;
                int col = selectedColumn + j;
                if (row < MyFrame.table.getRowCount() && col < MyFrame.table.getColumnCount()) {
                    MyFrame.table.setValueAt(MyFrame.clipboardData.get(i).get(j), row, col);
                } else {
                    MyFrame.model.addRow(new Object[]{MyFrame.clipboardData.get(i).get(j)});
                }
            }
        }
    }
}