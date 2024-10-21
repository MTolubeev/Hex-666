public class ShiftLeft {

    public static void shiftLeft(int startIndex, int shiftAmount) {
        int totalCells = MyFrame.table.getRowCount() * 16;  // Общее количество ячеек в таблице

        // Сдвигаем содержимое ячеек влево, начиная с позиции startIndex
        for (int index = startIndex; index < totalCells - shiftAmount; index++) {
            int row = index / 16;
            int col = index % 16;
            int srcIndex = index + shiftAmount;
            int srcRow = srcIndex / 16;
            int srcCol = srcIndex % 16;

            // Копируем значения из ячейки srcRow, srcCol в ячейку row, col
            MyFrame.model.setValueAt(MyFrame.model.getValueAt(srcRow, srcCol), row, col);
        }

        // Очищаем последние сдвинутые ячейки
        for (int i = totalCells - shiftAmount; i < totalCells; i++) {
            int row = i / 16;
            int col = i % 16;
            MyFrame.model.setValueAt(null, row, col);
        }
    }
}
