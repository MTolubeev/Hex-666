import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetJPanelTest {

    @Test
    void getJPanel() {
        GetJPanel.getJPanel();
        assertNotNull(MyFrame.buttonPanel);
    }
}