public class HexToSignedInt16 {
    public static void hexToSignedInt16() {

        String st16 = StringsForInfo.stringsForInfo(16).toUpperCase();
        if (st16.isEmpty()) MyFrame.third.setText("");
        else {
            String lowByteStr = st16.substring(0, 2);
            String highByteStr = st16.substring(2);
            String littleEndianHexStr = highByteStr + lowByteStr;
            int intVal = Integer.parseInt(littleEndianHexStr, 16);

            if (intVal > 32767) {

                MyFrame.third.setText(String.valueOf(intVal - 65536));
            } else {
                MyFrame.third.setText(String.valueOf(intVal));
            }
        }
    }
}
