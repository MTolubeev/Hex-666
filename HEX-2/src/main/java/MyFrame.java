import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;


public class MyFrame extends JFrame{
    public static JTable table;
    public static byte[] lineValue;
    public static JScrollPane forTable;
    public static DefaultTableModel model;
    public static ArrayList<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
    public static int index, countOfPanels = 0;
    public static String stringLineValue, selectedFile, line, hexStr;
    public static Matcher matcherForNorm;
    public static JButton findButton, nextButton;
    public static ArrayList<ArrayList<Object>> clipboardData;
    public static Point point;
    public static JPanel findPanel, panelForTable, panelForInfo, buttonPanel;
    public static JTextField first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, findText;

    public static JFrame myFrame() {

        JFrame frame = new JFrame();
        frame.setTitle("HEX-editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        frame.setLayout(gbl);
        frame.setResizable(false);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        bar.add(file);
        file.add(new JMenuItem("open new file")).addActionListener(e -> {

            if (countOfPanels == 1) {
                frame.getContentPane().remove(panelForTable);
                frame.revalidate();
                frame.setVisible(false);
                frame.setVisible(true);
                frame.pack();
                countOfPanels = 0;
            }
            if (countOfPanels == 3) {
                frame.getContentPane().remove(panelForTable);
                frame.getContentPane().remove(findPanel);

                frame.revalidate();
                frame.setVisible(false);
                frame.setVisible(true);
                frame.pack();
                countOfPanels = 0;
            }
            JFileChooser fileChooser = new JFileChooser();
            countOfPanels++;
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                // Получение выбранного файла
                selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
                // Вызов метода для чтения данных из файла и создания модел таблицы

                model = CreateTableModelFromFile.createTableModelFromFile(selectedFile);
                table = new JTable();
                table.setModel(model);

                hexStr = "";
                for (int j = 0; j < model.getRowCount(); j++) {
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        if (model.getValueAt(j, i) != null) {
                            hexStr += (String) model.getValueAt(j, i);
                        }
                    }
                }

                table.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        point = e.getPoint();

                        HexToUnsignedInt8.hexToUnsignedInt8();
                        HexToSignedInt8.hexToSignedInt8();
                        HexToUnsignedInt16.hexToUnsignedInt16();
                        HexToSignedInt16.hexToSignedInt16();
                        HexToUnsignedInt32.hexToUnsignedInt32();
                        HexToSignedInt32.hexToSignedInt32();
                        HexToUnsignedInt64.hexToUnsignedInt64();
                        HexToSignedInt64.hexToSignedInt64();
                        HexToFloat16.hexToFloat16();
                    }

                });
                forTable = new JScrollPane(table);
                forTable.setPreferredSize(new Dimension(500, 500));

                table.setCellSelectionEnabled(true);
                table.getTableHeader().setResizingAllowed(false);
                table.getTableHeader().setReorderingAllowed(false);
                table.setDragEnabled(false);

                panelForTable = new JPanel();
                panelForTable.setLayout(new GridBagLayout());
                GridBagConstraints constraintsForTable = new GridBagConstraints();
                constraintsForTable.insets = new Insets(10, 5, 10, 5);
                panelForTable.add(forTable, constraintsForTable);

                frame.add(panelForTable, GridBagConstruct.gridBagConstruct(0, 0, 1, 0, 2, 3));
                frame.revalidate();
                frame.pack();
            }

        });
        file.add(new JMenuItem("find")).addActionListener(e -> {
            findText = new JTextField();
            findPanel = new JPanel();
            findPanel.setLayout(new GridBagLayout());
            GridBagConstraints constraintsForFind = new GridBagConstraints();
            constraintsForFind.insets = new Insets(0, 2, 0, 2);
            countOfPanels += 2;
            findText.setPreferredSize(new Dimension(100, 50));
            findButton = new JButton("FIND");
            nextButton = new JButton("NEXT");
            stringLineValue = new String(lineValue);
            findButton.addActionListener(e1 -> {

                if (findText.getText().contains(".")) {

                    SearchWithMask.searchWithMask(findText.getText());
                }

                else{

                    Search.search(findText.getText());

                }
            });

            nextButton.addActionListener(e12 -> FindNext.findNext());

            findPanel.add(findButton, constraintsForFind);
            findPanel.add(findText, constraintsForFind);
            findPanel.add(nextButton, constraintsForFind);

            frame.add(findPanel, GridBagConstruct.gridBagConstruct(0, 0, 0, 2, 1, 1));
            frame.revalidate();

            frame.pack();


        });
        file.addSeparator();
        file.add(new JMenuItem("close")).addActionListener(e -> System.exit(0));

        frame.add(PanelForInfoCreator.panelForInfoCreator(), GridBagConstruct.gridBagConstruct(0, 1, 0, 0, 2, 1));

        frame.add(GetjPanel.getjPanel(), GridBagConstruct.gridBagConstruct(0, 0, 1, 2, 1, 3));

        clipboardData = new ArrayList<>();

        frame.setJMenuBar(bar);
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }
}


