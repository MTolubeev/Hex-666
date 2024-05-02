import java.math.BigInteger;

public class HexToSignedInt64 {
    public static void hexToSignedInt64() {
        String str64 = StringsForInfo.stringsForInfo(64);
        if (str64.isEmpty()) MyFrame.seventh.setText("");
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

            BigInteger bigIntVal = new BigInteger(littleEndianHexStr, 16);

            if (bigIntVal.compareTo(new BigInteger("9223372036854775807")) > 0) {
                MyFrame.seventh.setText(String.valueOf(bigIntVal.subtract(new BigInteger("18446744073709551616")).longValue()));
            } else {
                MyFrame.seventh.setText(String.valueOf(bigIntVal.longValue()));
            }
        }
    }
}
