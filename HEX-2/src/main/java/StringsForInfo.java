public class StringsForInfo {
    public static String stringsForInfo(int por) {
        int row =  MyFrame.table.rowAtPoint( MyFrame.point);
        int col =  MyFrame.table.columnAtPoint( MyFrame.point);

        String[] hexArr =  MyFrame.hexStr.split(" ");


        if (row * 16 + col >= hexArr.length) {
            return "";
        } else {
            String st = hexArr[row * 16 + col];
            if (por == 8) return st;
            if (row * 16 + col + 1 > hexArr.length) {
                return "";
            } else {
                String st16 = hexArr[row * 16 + col] + hexArr[row * 16 + col + 1];
                if (por == 16) return st16;

                if (row * 16 + col + 2 >= hexArr.length || row * 16 + col + 3 >= hexArr.length) {
                    return "";
                } else {
                    String st32 = st16 + hexArr[row * 16 + col + 2] + hexArr[row * 16 + col + 3];
                    if (por == 32) return st32;

                    if (row * 16 + col + 4 >= hexArr.length || row * 16 + col + 7 >= hexArr.length) {
                        return "";
                    } else {
                        String st64 = st32 + hexArr[row * 16 + col + 4] + hexArr[row * 16 + col + 5] + hexArr[row * 16 + col + 6] + hexArr[row * 16 + col + 7];
                        if (por == 64) return st64;

                    }
                }
            }
        }
        return "";
    }
}
