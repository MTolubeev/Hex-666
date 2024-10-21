import javax.swing.*;
import java.util.regex.Pattern;

public class HexCellEditor extends DefaultCellEditor {
    private static final Pattern HEX_PATTERN = Pattern.compile("^[0-9A-Fa-f]{2}$");

    public HexCellEditor() {
        super(new JTextField());
    }

    @Override
    public boolean stopCellEditing() {
        String value = (String) getCellEditorValue();
        if (!HEX_PATTERN.matcher(value).matches()) {
            JOptionPane.showMessageDialog(null, "Некорректный ввод, введите число в пределах (00-FF).");
            return false;
        }
        return super.stopCellEditing();
    }
}
