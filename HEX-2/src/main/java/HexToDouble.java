public class HexToDouble {

    public static void hexToDouble() {
        String str64 = StringsForInfo.stringsForInfo(64);
        if (str64.isEmpty()) MyFrame.tenth.setText("");
        else {
            String byte1 = str64.substring(0, 2);
            String byte2 = str64.substring(2, 4);
            String byte3 = str64.substring(4, 6);
            String byte4 = str64.substring(6, 8);
            String byte5 = str64.substring(8, 10);
            String byte6 = str64.substring(10, 12);
            String byte7 = str64.substring(12, 14);
            String byte8 = str64.substring(14);
            String littleEndianHexStr = byte8 + byte7 + byte6 + byte5 + byte4 + byte3 + byte2 + byte1;
            long longVal = Long.parseLong(littleEndianHexStr, 16);

            MyFrame.tenth.setText(String.valueOf(longVal));
        }

    }
}
