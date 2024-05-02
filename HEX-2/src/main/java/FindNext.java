public class FindNext {
    public static void findNext() {
        MyFrame.index = (MyFrame.index == MyFrame.cols.size()) ? 0 : MyFrame.index;
        MyFrame.table.setRowSelectionInterval(MyFrame.rows.get(MyFrame.index), MyFrame.rows.get(MyFrame.index));
        MyFrame.table.setColumnSelectionInterval(MyFrame.cols.get(MyFrame.index), MyFrame.cols.get(MyFrame.index));
        MyFrame.index++;
    }

}
