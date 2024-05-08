import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveAsToFileTest {

    @Test
    void saveAsToFile() {
        SaveAsToFile saveAsToFile = new SaveAsToFile();

        Assert.assertNull(MyFrame.model);
    }
}