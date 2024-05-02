public class ConvertInt16ToFloat16 {
    public static float convertInt16ToFloat16(int val) {
        // Получаем знаковый бит
        int sign = (val & 0x8000) >> 15;
        // Получаем экспоненту
        int exponent = (val & 0x7C00) >> 10;
        // Получаем мантиссу
        int mantissa = val & 0x03FF;

        if (exponent == 0) {
            if (mantissa == 0) {
                // Если экспонента и мантисса равны нулю, то число ноль
                return 0.0f;
            } else {
                // Если экспонента равна нулю, а мантисса не равна нулю, то число -0
                return -0.0f;
            }
        } else if (exponent == 0x1F) {
            if (mantissa == 0) {
                // Если экспонента равна 31, а мантисса равна нулю, то число бесконечность
                return (sign == 0) ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
            } else {
                // Если экспонента равна 31, а мантисса не равна нулю, то число NaN
                return Float.NaN;
            }
        }
        int normalizedExponent = exponent - 15;
        float normalizedMantissa = (float) mantissa / 1024.0f; // Деление на 2^10

        // Составляем число с плавающей точкой
        float result = (float) Math.pow(2, normalizedExponent) * (1.0f + normalizedMantissa);

        // Применяем знак
        return (sign == 0) ? result : -result;
    }
}
