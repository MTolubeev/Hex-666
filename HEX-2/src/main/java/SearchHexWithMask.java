import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchHexWithMask {
    public static void searchHexWithMask(String searchText) {

        ClearArrList.clearArrList();

        String[] parts = searchText.split("\\.");
        Pattern patWithMaskHex = Pattern.compile(parts[0] + "\\S{2}" + parts[1]);
        Matcher matWithMaskHex = patWithMaskHex.matcher( MyFrame.hexStr.replaceAll(" ", ""));
        while (matWithMaskHex.find()) {
            int row = 0, col = matWithMaskHex.start() / 2;
            while (col > 15) {
                row++;
                col -= 16;
            }
            MyFrame.rows.add(row);
            MyFrame.cols.add(col);
            MyFrame.index = 1;
        }
        if (! MyFrame.rows.isEmpty()) {
            MyFrame.table.setRowSelectionInterval( MyFrame.rows.get(0),  MyFrame.rows.get(0));
            MyFrame.table.setColumnSelectionInterval( MyFrame.cols.get(0),  MyFrame.cols.get(0));

        } else {
            JOptionPane.showMessageDialog(null, "No matches in file ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
