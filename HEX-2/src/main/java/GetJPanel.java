import javax.swing.*;
import java.awt.*;

public class GetJPanel {

    public static JPanel getJPanel() {
        MyFrame.buttonPanel = new JPanel();
        MyFrame.buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraintsForButtons = new GridBagConstraints();
        constraintsForButtons.insets = new Insets(0, 2, 0, 2);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(e -> CopySelection.copySelection());
        MyFrame.buttonPanel.add(copyButton, constraintsForButtons);

        JButton cutButton = new JButton("Cut");
        cutButton.addActionListener(e -> CutSelection.cutSelection());
        MyFrame.buttonPanel.add(cutButton, constraintsForButtons);

        JButton cutShiftButton = new JButton("Cut with shift");
        cutShiftButton.addActionListener(e -> CutWithShiftSelection.cutWithShiftSelection());
        MyFrame.buttonPanel.add(cutShiftButton, constraintsForButtons);

        JButton pasteButton = new JButton("Paste");
        pasteButton.addActionListener(e ->
                PasteSelection.pasteSelection());
        MyFrame.buttonPanel.add(pasteButton, constraintsForButtons);

        JButton pasteWithShiftButton = new JButton("paste with shift");
        pasteWithShiftButton.addActionListener(e ->
                PasteWithShift.pasteWithShift());
        MyFrame.buttonPanel.add(pasteWithShiftButton, constraintsForButtons);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            SaveToFile.saveToFile(MyFrame.selectedFile);
            JOptionPane.showMessageDialog(null, "File saved successfully.");
        });
        MyFrame.buttonPanel.add(saveButton, constraintsForButtons);

        JButton saveAsButton = new JButton("Save As");
        saveAsButton.addActionListener(e -> SaveAsToFile.saveAsToFile());
        MyFrame.buttonPanel.add(saveAsButton, constraintsForButtons);

        JButton addRow = new JButton("Add row");
        addRow.addActionListener(e -> MyFrame.model.addRow(new Object[16]));
        MyFrame.buttonPanel.add(addRow, constraintsForButtons);


        MyFrame.buttonPanel.setPreferredSize(new Dimension(800, 80));
        return MyFrame.buttonPanel;
    }
}
