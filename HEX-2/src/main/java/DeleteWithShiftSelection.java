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

        // Сдвигаем содержимое ячеек влево
        for (int i = 0; i < MyFrame.table.getRowCount(); i++) {
            for (int j = selectedColumns[0]; j < MyFrame.table.getColumnCount(); j++) {
                if (MyFrame.model.getValueAt(i, j) == null && j + count < MyFrame.table.getColumnCount()) {

                    MyFrame.model.setValueAt(MyFrame.model.getValueAt(i, j + count), i, j);
                    // Очищаем текущую ячейку
                    MyFrame.model.setValueAt(null, i, j + count);
                }
            }
        }
    }
}
