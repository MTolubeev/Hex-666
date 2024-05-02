public class HexToSignedInt8 {
    public static void hexToSignedInt8() {
        String st = StringsForInfo.stringsForInfo(8).toUpperCase();
        if (st.isEmpty()) MyFrame.second.setText("");
        else {
            int intVal = Integer.parseInt(st, 16);
            if (intVal > 127) {
                MyFrame.first.setText(String.valueOf((intVal - 256)));
            } else {
                MyFrame.first.setText(String.valueOf(intVal));
            }
        }
    }
}
