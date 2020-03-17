//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {
    private JavaArcade game;
    private GameStats gStats;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton instructionsButton;
    private JButton creditsButton;

    public ControlPanel(JavaArcade var1, GameStats var2) {
        this.game = var1;
        this.gStats = var2;
        this.instructionsButton = new JButton("Instructions");
        this.instructionsButton.addActionListener(this);
        this.add(this.instructionsButton);
        this.add(Box.createHorizontalStrut(80));
        this.startButton = new JButton("Start");
        this.startButton.addActionListener(this);
        this.add(this.startButton);
        this.pauseButton = new JButton("Pause");
        this.pauseButton.addActionListener(this);
        this.add(this.pauseButton);
        this.stopButton = new JButton("Stop");
        this.stopButton.addActionListener(this);
        this.add(this.stopButton);
        this.add(Box.createHorizontalStrut(80));
        this.creditsButton = new JButton("Credits");
        this.creditsButton.addActionListener(this);
        this.add(this.creditsButton);
    }

    public void actionPerformed(ActionEvent var1) {
        JButton var2 = (JButton)var1.getSource();
        if (var2 == this.startButton) {
            if (!this.game.running()) {
                ((JPanel)this.game).requestFocus();
                this.game.startGame();
                this.gStats.update(0);
                this.gStats.repaint();
            }
        } else if (var2 == this.pauseButton) {
            this.game.pauseGame();
            this.startButton.setText("Resume");
            this.startButton.setEnabled(true);
            this.repaint();
        } else if (var2 == this.stopButton) {
            this.game.stopGame();
            this.gStats.gameOver(this.game.getPoints());
            this.gStats.repaint();
            this.startButton.setEnabled(true);
            this.startButton.setText("Restart");
            this.repaint();
        } else {
            String var3;
            if (var2 == this.creditsButton) {
                var3 = this.game.getCredits();
                JOptionPane.showMessageDialog(this, var3, "Game Credits", -1);
            } else if (var2 == this.instructionsButton) {
                var3 = this.game.getInstructions();
                JOptionPane.showMessageDialog(this, var3, "Game Rules", -1);
            }
        }

        ((JPanel)this.game).requestFocus();
    }
}
