import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchHexTest {

    @Test
    void searchHex() {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        assertEquals(rows, MyFrame.rows);
        assertEquals(cols, MyFrame.cols);

    }
}