import javax.swing.*;
import java.awt.*;

public class PanelForInfoCreator {
    public static JComponent panelForInfoCreator() {

        MyFrame.panelForInfo = new JPanel();
        MyFrame.panelForInfo.setLayout(new GridBagLayout());
        MyFrame.panelForInfo.setPreferredSize(new Dimension(300, 360));

        JTextField type = new JTextField("Type");
        JTextField signed = new JTextField("Signed");
        JTextField unsigned = new JTextField("Unsigned");

        type.setEditable(false);
        signed.setEditable(false);
        unsigned.setEditable(false);

        MyFrame.panelForInfo.add(type, GridBagConstruct.gridBagConstruct(0.2f, 0, 0, 0, 1, 1));
        MyFrame.panelForInfo.add(signed, GridBagConstruct.gridBagConstruct(0.4f, 0, 1, 0, 1, 1));
        MyFrame.panelForInfo.add(unsigned, GridBagConstruct.gridBagConstruct(0.4f, 0, 2, 0, 1, 1));

        JTextField bit8 = new JTextField("8-bit Int");
        bit8.setEditable(false);
        MyFrame.panelForInfo.add(bit8, GridBagConstruct.gridBagConstruct(0, 0, 0, 1, 1, 1));
        MyFrame.first = new JTextField("");
        MyFrame.first.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.first, GridBagConstruct.gridBagConstruct(0, 0, 1, 1, 1, 1));
        MyFrame.second = new JTextField("");
        MyFrame.second.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.second, GridBagConstruct.gridBagConstruct(0, 0, 2, 1, 1, 1));

        JTextField bit16 = new JTextField("16-bit Int");
        bit16.setEditable(false);
        MyFrame.panelForInfo.add(bit16, GridBagConstruct.gridBagConstruct(0, 0, 0, 2, 1, 1));
        MyFrame.third = new JTextField("");
        MyFrame.third.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.third, GridBagConstruct.gridBagConstruct(0, 0, 1, 2, 1, 1));
        MyFrame.fourth = new JTextField("");
        MyFrame.fourth.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.fourth, GridBagConstruct.gridBagConstruct(0, 0, 2, 2, 1, 1));

        JTextField bit32 = new JTextField("32-bit Int");
        bit32.setEditable(false);
        MyFrame.panelForInfo.add(bit32, GridBagConstruct.gridBagConstruct(0, 0, 0, 3, 1, 1));
        MyFrame.fifth = new JTextField("");
        MyFrame.fifth.setEditable(false);
         MyFrame.panelForInfo.add( MyFrame.fifth, GridBagConstruct.gridBagConstruct(0, 0, 1, 3, 1, 1));
        MyFrame.sixth = new JTextField("");
        MyFrame.sixth.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.sixth, GridBagConstruct.gridBagConstruct(0, 0, 2, 3, 1, 1));

        JTextField bit64 = new JTextField("64-bit Int");
        bit64.setEditable(false);
        MyFrame.panelForInfo.add(bit64, GridBagConstruct.gridBagConstruct(0, 0, 0, 4, 1, 1));
        MyFrame.seventh = new JTextField("");
        MyFrame.seventh.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.seventh, GridBagConstruct.gridBagConstruct(0, 0, 1, 4, 1, 1));
        MyFrame.eighth = new JTextField("");
        MyFrame.eighth.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.eighth, GridBagConstruct.gridBagConstruct(0, 0, 2, 4, 1, 1));

        JTextField fl = new JTextField("Float");
        fl.setEditable(false);
        MyFrame.panelForInfo.add(fl, GridBagConstruct.gridBagConstruct(0, 0, 0, 5, 1, 1));
        MyFrame.ninth = new JTextField("");
        MyFrame.ninth.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.ninth, GridBagConstruct.gridBagConstruct(0, 0, 1, 5, 1, 2));

        JTextField db = new JTextField("Double");
        db.setEditable(false);
        MyFrame.panelForInfo.add(db, GridBagConstruct.gridBagConstruct(0, 0, 0, 6, 1, 1));
        MyFrame.tenth = new JTextField("");
        MyFrame.tenth.setEditable(false);
        MyFrame.panelForInfo.add( MyFrame.tenth, GridBagConstruct.gridBagConstruct(0, 0, 1, 6, 1, 2));

        return MyFrame.panelForInfo;
    }
}
