import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.EventObject;

public class HexCellEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private JTextField textField;
    private boolean isEditing = false;

    public HexCellEditor() {
        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String text = textField.getText().trim();
                if (isValidHex(text)) {
                    fireEditingStopped();
                    isEditing = false;
                } else {
                    JOptionPane.showMessageDialog(textField, "Введите валидное шестнадцатеричное значение (00 - FF).", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                }
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText((String) value);
        isEditing = true; // Устанавливаем флаг редактирования
        return textField;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textField.setText((String) value);
        return textField;
    }

    private boolean isValidHex(String text) {
        return text.matches("^[0-9A-Fa-f]{2}$");
    }

    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }
}
