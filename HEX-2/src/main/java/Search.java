import java.util.regex.Pattern;

public class Search {
    public static void search(String searchText) {

        ClearArrList.clearArrList();

        Pattern patternForNorm = Pattern.compile(searchText);
        MyFrame.matcherForNorm = patternForNorm.matcher(MyFrame.stringLineValue);
        while (MyFrame.matcherForNorm.find()) {
            int row = 0, col = MyFrame.matcherForNorm.start();
            while (col > 15) {
                row++;
                col -= 16;
            }
            MyFrame.rows.add(row);
            MyFrame.cols.add(col);
            MyFrame.index = 1;
        }

        if (MyFrame.rows.isEmpty()) SearchHex.searchHex(searchText);
        else {
            MyFrame.table.setRowSelectionInterval(MyFrame.rows.get(0), MyFrame.rows.get(0));
            MyFrame.table.setColumnSelectionInterval(MyFrame.cols.get(0), MyFrame.cols.get(0));

        }


    }
}
