//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Arcade extends JFrame {
    public Arcade() {
        super("AP Java Arcade");
        MonkeyKong var1 = new MonkeyKong(720, 720);
        GameStats var2 = new GameStats(var1);
        ControlPanel var3 = new ControlPanel(var1, var2);
        JPanel var4 = new JPanel();
        var4.setLayout(new BorderLayout());
        var4.setBorder(new EmptyBorder(0, 5, 0, 5));
        var4.add(var2, "North");
        var4.add((JPanel)var1, "Center");
        var4.add(var3, "South");
        Container var5 = this.getContentPane();
        var5.add(var4, "Center");
    }

    public static void main(String[] var0) {
        Arcade var1 = new Arcade();
        var1.setBounds(100, 100, 600, 600);
        var1.setDefaultCloseOperation(3);
        var1.setVisible(true);
    }
}
