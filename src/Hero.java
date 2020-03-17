//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hero extends Sprite {
    private Image img = null;

    public Hero(int var1, int var2, int var3, int var4, int var5) {
        super(var1, var2, var3, var4, var5);

        try {
            this.img = ImageIO.read(new File("/Users/nalinsinha/Downloads/New Donkey/src/img/Jump-Left.png"));
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        this.img = this.img.getScaledInstance(50, 50, 4);
    }

    public void draw(Graphics var1) {
        var1.drawImage(this.img, this.getxPos(), this.getyPos(), (ImageObserver)null);
    }

    public void move(int var1) {
        switch(var1) {
            case 1:
                this.setxPos(this.getxPos() + this.getSpeed());
                break;
            case 2:
                this.setyPos(this.getyPos() + this.getSpeed());
                break;
            case 3:
                this.setxPos(this.getxPos() - this.getSpeed());
                break;
            case 4:
                this.setyPos(this.getyPos() - this.getSpeed());
        }

    }
}
