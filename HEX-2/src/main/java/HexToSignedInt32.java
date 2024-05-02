public class HexToSignedInt32 {
    public static void hexToSignedInt32() {
        String str32 = StringsForInfo.stringsForInfo(32);
        if (str32.isEmpty()) MyFrame.fifth.setText("");
        else {
            String byte1 = str32.substring(0, 2);
            String byte2 = str32.substring(2, 4);
            String byte3 = str32.substring(4, 6);
            String byte4 = str32.substring(6);
            String littleEndianHexStr = byte4 + byte3 + byte2 + byte1;

            long longVal = Long.parseLong(littleEndianHexStr, 16);
            if (longVal > 2147483647) {
                MyFrame.fifth.setText(String.valueOf(longVal - 4294967296L));
            } else {
                MyFrame.fifth.setText(String.valueOf(longVal));
            }
        }
    }
}
