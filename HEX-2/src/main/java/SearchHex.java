import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchHex {
    public static void searchHex(String searchText) {
        ClearArrList.clearArrList();

        Pattern patternForHex = Pattern.compile(searchText.replaceAll(" ", "").toUpperCase());
        Matcher matcherForHex = patternForHex.matcher( MyFrame.hexStr.replaceAll(" ", ""));
        while (matcherForHex.find()) {
            int row = 0, col = matcherForHex.start() / 2;
            while (col > 15) {
                row++;
                col -= 16;
            }
            MyFrame.rows.add(row);
            MyFrame.cols.add(col);
            MyFrame.index = 1;
            if (! MyFrame.rows.isEmpty()) {
                MyFrame.table.setRowSelectionInterval( MyFrame.rows.getFirst(),  MyFrame.rows.getFirst());
                MyFrame.table.setColumnSelectionInterval( MyFrame.cols.getFirst(),  MyFrame.cols.getFirst());
            } else
                JOptionPane.showMessageDialog(null, "No matches in file ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
