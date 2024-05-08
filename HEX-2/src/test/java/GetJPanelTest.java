import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetJPanelTest {

    @Test
    void getJPanel() {
        GetJPanel.getJPanel();
        Assert.assertNotNull(MyFrame.buttonPanel);
    }
}