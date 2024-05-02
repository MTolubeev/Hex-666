public class HexToFloat16 {
    public static void hexToFloat16() {
        String st16 = StringsForInfo.stringsForInfo(16);
        if (st16.isEmpty()) MyFrame.ninth.setText("");
        else {
            String lowByteStr = st16.substring(0, 2);
            String highByteStr = st16.substring(2);
            String littleEndianHexStr = highByteStr + lowByteStr;

            // Преобразование little endian hex строки в целое число
            int intVal = Integer.parseInt(littleEndianHexStr, 16);

            // Преобразование 16-битного целого числа в 16-битное число с плавающей точкой
            MyFrame.ninth.setText(String.valueOf(ConvertInt16ToFloat16.convertInt16ToFloat16(intVal)));
        }
    }
}
