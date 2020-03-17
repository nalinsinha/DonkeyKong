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

public class Background {
    Image img;

    public Background() {
        try {
            this.img = ImageIO.read(new File("/Users/nalinsinha/Downloads/New Donkey/src/img/Background.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        this.img = this.img.getScaledInstance(720, 720, 4);
    }

    public void draw(Graphics var1) {
        var1.drawImage(this.img, 0, 0, (ImageObserver)null);
    }
}
