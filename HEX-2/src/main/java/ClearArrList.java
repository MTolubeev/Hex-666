public class ClearArrList {
    public static void clearArrList() {
        if (!MyFrame.rows.isEmpty()) {
            MyFrame.rows.clear();
            MyFrame.cols.clear();
            MyFrame.table.clearSelection();
        }
    }

}
