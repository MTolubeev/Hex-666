public class HexToUnsignedInt16 {
    public static void hexToUnsignedInt16() {
        String st16 = StringsForInfo.stringsForInfo(16).toUpperCase();
        if (st16.isEmpty()) MyFrame.fourth.setText("");
        else {
            String lowByteStr = st16.substring(0, 2);
            String highByteStr = st16.substring(2);
            String littleEndianHexStr = highByteStr + lowByteStr;
            int intVal = Integer.parseInt(littleEndianHexStr, 16);
            MyFrame.fourth.setText(String.valueOf(intVal));
        }
    }

}
