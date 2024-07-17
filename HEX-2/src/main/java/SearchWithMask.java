import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchWithMask {
    public static void searchWithMask(String searchText) {

        ClearArrList.clearArrList();

        String[] parts = searchText.split("\\.");
        Pattern patWithMaskNorm = Pattern.compile(parts[0] + "\\S+" + parts[1]);
        Matcher matWithMaskNorm = patWithMaskNorm.matcher(( MyFrame.stringLineValue));
        while (matWithMaskNorm.find()) {
            int row = 0, col = matWithMaskNorm.start();
            while (col > 15) {
                row++;
                col -= 16;
            }
            MyFrame.rows.add(row);
            MyFrame.cols.add(col);
            MyFrame.index = 1;
        }
        if ( MyFrame.rows.isEmpty()) SearchHexWithMask.searchHexWithMask(searchText);
        else {
            MyFrame.table.setRowSelectionInterval( MyFrame.rows.get(0),  MyFrame.rows.get(0));
            MyFrame.table.setColumnSelectionInterval( MyFrame.cols.get(0),  MyFrame.cols.get(0));

        }
    }
}
