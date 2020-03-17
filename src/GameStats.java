//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GameStats extends JPanel {
    private JTextField gameNameText;
    private JTextField currentHighScorer;
    private JTextField currentHighScore;
    private int yourScore;
    private JLabel yourScoreText;
    private JavaArcade game;

    public GameStats(JavaArcade var1) {
        super(new GridLayout(2, 4, 10, 0));
        this.setBorder(new EmptyBorder(0, 0, 5, 0));
        Font var2 = new Font("Monospaced", 1, 24);
        JLabel var3 = new JLabel(" " + var1.getGameName());
        var3.setForeground(Color.red);
        var3.setFont(var2);
        this.add(var3);
        this.add(new JLabel(" Current High Score:   " + var1.getHighScore()));
        this.add(new JLabel(" "));
        this.yourScoreText = new JLabel(" Your Final Score: 0");
        this.add(this.yourScoreText);
        new Font("Monospaced", 1, 16);
        this.game = var1;
    }

    public void update(int var1) {
        this.yourScoreText.setText(" Your Score: " + var1);
    }

    public void gameOver(int var1) {
        if (var1 > Integer.parseInt(this.game.getHighScore())) {
            this.yourScoreText.setForeground(Color.BLUE);
            String var2 = (String)JOptionPane.showInputDialog(this, "You are the new high scorer. Congratulations!\n Enter your name: ", "High Score", -1, (Icon)null, (Object[])null, "name");
        }

    }
}
