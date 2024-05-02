import java.awt.*;

public class GridBagConstruct {
    public static Object gridBagConstruct(float wx, int wy, int gx, int gy, int gh, int gw) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gx;
        constraints.gridy = gy;
        constraints.gridheight = gh;
        constraints.gridwidth = gw;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(3, 5, 0, 5);
        constraints.weightx = wx;
        constraints.weighty = wy;

        return constraints;
    }
}
