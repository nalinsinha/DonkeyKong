//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MonkeyKong extends JPanel implements JavaArcade, KeyListener, ActionListener {
    private int count = 0;
    private int Score;
    private String name = "Monkey Kong";
    private String instructions = "The goal of the game is to collect all the coins on the way to the top of the map. \n Use the Arrow keys to move the character around and pick up the hemmer to destroy nearby barrels.";
    private String credits;
    private Timer timer;
    private Hero h;
    private Background back;
    private Wall w;
    private ArrayList<Wall> walls = new ArrayList();
    private boolean isRunning;
    ArrayList<Integer> wallsHit = new ArrayList();

    public MonkeyKong(int var1, int var2) {
        this.walls.add(new Wall(250, 400, 0, 100, 200));
        this.walls.add(new Wall(450, 380, 0, 100, 200));
        this.back = new Background();
        this.h = new Hero(120, 605, 3, 50, 50);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(var1, var2));
        this.timer = new Timer(10, this);
        this.timer.start();
        this.addMouseMotionListener(new MonkeyKong.PanelMotionListener());
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public boolean running() {
        return this.isRunning;
    }

    public void startGame() {
        this.isRunning = true;
    }

    public String getGameName() {
        return this.name;
    }

    public void pauseGame() {
        this.timer.stop();
        this.isRunning = false;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getCredits() {
        return this.credits;
    }

    public String getHighScore() {
        return Integer.toString(1 / this.Score * 1000);
    }

    public void stopGame() {
        this.timer.stop();
        this.isRunning = false;
    }

    public int getPoints() {
        return 1 / this.Score * 1000;
    }

    public void paintComponent(Graphics var1) {
        super.paintComponent(var1);
        Iterator var2 = this.walls.iterator();

        while(var2.hasNext()) {
            Wall var3 = (Wall)var2.next();
            var3.draw(var1);
        }

        this.h.draw(var1);
    }

    public void actionPerformed(ActionEvent var1) {
        boolean var2 = true;
        ArrayList var3 = this.hittingWall(this.h);
        System.out.println(var3);

        for(int var4 = 0; var4 < var3.size(); ++var4) {
            if ((Integer)var3.get(var4) == 2) {
                var2 = false;
            }
        }

        if (var2 && this.count % 30 == 0) {
            this.h.move(2);
        }

        if (this.count % 100 == 0) {
            ++this.Score;
        }

        ++this.count;
        this.repaint();
    }

    public ArrayList<Integer> hittingWall(Hero var1) {
        this.wallsHit.clear();

        for(int var2 = 0; var2 < this.walls.size(); ++var2) {
            if (((Wall)this.walls.get(var2)).isHitting(var1) > 0) {
                this.wallsHit.add(((Wall)this.walls.get(var2)).isHitting(this.h));
            }
        }

        return this.wallsHit;
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyPressed(KeyEvent var1) {
        if (this.isRunning) {
            ArrayList var2 = this.hittingWall(this.h);
            boolean var3 = true;
            int var4;
            switch(var1.getKeyCode()) {
                case 27:
                    System.exit(0);
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 34:
                case 35:
                case 36:
                default:
                    break;
                case 32:
                    this.timer.stop();
                    break;
                case 37:
                    for(var4 = 0; var4 < var2.size(); ++var4) {
                        if ((Integer)var2.get(var4) == 1) {
                            var3 = false;
                        }
                    }

                    if (var3) {
                        this.h.move(3);
                    }
                    break;
                case 38:
                    for(var4 = 1; var4 < 8; ++var4) {
                        var2 = this.hittingWall(new Hero(this.h.getxPos(), this.h.getyPos() + var4 * this.h.getSpeed(), 0, 0, 0));

                        for(int var5 = 0; var5 < var2.size(); ++var5) {
                            if ((Integer)var2.get(var5) == 4) {
                                var3 = false;
                            }
                        }

                        if (!var3) {
                            return;
                        }

                        this.h.move(4);
                    }

                    return;
                case 39:
                    for(var4 = 0; var4 < var2.size(); ++var4) {
                        if ((Integer)var2.get(var4) == 3) {
                            var3 = false;
                        }
                    }

                    if (var3) {
                        this.h.move(1);
                    }
                    break;
                case 40:
                    for(var4 = 0; var4 < var2.size(); ++var4) {
                        if ((Integer)var2.get(var4) == 2) {
                            var3 = false;
                        }
                    }

                    if (var3) {
                        this.h.move(2);
                    }
            }
        }

    }

    private class PanelMotionListener extends MouseMotionAdapter {
        private PanelMotionListener() {
        }

        public void mouseDragged(MouseEvent var1) {
            double var2 = (double)var1.getX();
            double var4 = (double)var1.getY();
            System.out.println(var2 + ", " + var4);
        }
    }
}
