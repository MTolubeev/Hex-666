public class HexToUnsignedInt8 {
    public static void hexToUnsignedInt8() {

        String st = StringsForInfo.stringsForInfo(8).toUpperCase();
        if (st.isEmpty()) MyFrame.first.setText("");
        else {
            int intVal = Integer.parseInt(st, 16);
            MyFrame.second.setText(String.valueOf((intVal)));
        }
    }

}
