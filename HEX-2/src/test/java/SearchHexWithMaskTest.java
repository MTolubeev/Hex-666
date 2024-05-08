import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchHexWithMaskTest {

    @Test
    void searchHexWithMask() {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        Assert.assertEquals(rows,MyFrame.rows);
        Assert.assertEquals(cols,MyFrame.cols);

    }
}