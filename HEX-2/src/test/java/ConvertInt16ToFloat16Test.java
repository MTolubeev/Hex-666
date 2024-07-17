import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertInt16ToFloat16Test {

    @Test
    void convertInt16ToFloat16Test() {

       assertEquals(1394.0f, ConvertInt16ToFloat16.convertInt16ToFloat16(25970),0.0f);
    }
}