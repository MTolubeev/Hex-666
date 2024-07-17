
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class ClearArrListTest {

    @Test
    void clearArrList() {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        assertEquals(rows,MyFrame.rows);
        assertEquals(cols, MyFrame.cols);
    }
}