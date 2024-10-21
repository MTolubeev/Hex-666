public class DeleteWithShiftSelection {
    public static void deleteWithShiftSelection() {
        int[] selectedRows = MyFrame.table.getSelectedRows();
        int[] selectedColumns = MyFrame.table.getSelectedColumns();
        int count = 0;
        // Удаляем ячейки построчно, начиная с последней выбранной строки
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            int row = selectedRows[i];
            for (int column : selectedColumns) {
                // Удаляем содержимое ячейки
                MyFrame.model.setValueAt(null, row, column);
                count++;
            }
        }
        int insertIndex = selectedRows[0] * 16 + selectedColumns[0];
        int shiftAmount = selectedRows.length * selectedColumns.length;
        ShiftLeft.shiftLeft(insertIndex, shiftAmount);

    }
}
