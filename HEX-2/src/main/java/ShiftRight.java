public class ShiftRight {
    public static void shiftRight(int startIndex, int shiftAmount) {
        int totalCells = MyFrame.table.getRowCount() * 16;    for (int index = totalCells - 1; index >= startIndex + shiftAmount; index--) {
            int row = index / 16;        int col = index % 16;
            int srcIndex = index - shiftAmount;        int srcRow = srcIndex / 16;
            int srcCol = srcIndex % 16;
            MyFrame.model.setValueAt(MyFrame.model.getValueAt(srcRow, srcCol), row, col);    }

        for (int i = 0; i < shiftAmount; i++) {        int row = (startIndex + i) / 16;
            int col = (startIndex + i) % 16;        MyFrame.model.setValueAt(null, row, col);
        }}
}
