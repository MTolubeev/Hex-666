public class DeleteSelection {
    public static void deleteSelection() {
        int[] selectedRows = MyFrame.table.getSelectedRows();
        int[] selectedColumns = MyFrame.table.getSelectedColumns();

        for (int row : selectedRows) {
            for (int col : selectedColumns) {
                MyFrame.model.setValueAt(null, row, col);
            }
        }
    }
}
