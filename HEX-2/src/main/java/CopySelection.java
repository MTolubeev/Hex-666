import java.util.ArrayList;

public class CopySelection {
    public static void copySelection() {
        int[] selectedRows = MyFrame.table.getSelectedRows();
        int[] selectedColumns = MyFrame.table.getSelectedColumns();
        MyFrame.clipboardData.clear();
        for (int row : selectedRows) {
            ArrayList<Object> rowData = new ArrayList<>();
            for (int col : selectedColumns) {
                rowData.add(MyFrame.table.getValueAt(row, col));
            }
            MyFrame.clipboardData.add(rowData);
        }
    }
}
