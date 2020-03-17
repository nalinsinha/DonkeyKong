//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public class Wall extends Sprite {
    public Wall(int var1, int var2, int var3, int var4, int var5) {
        super(var1, var2, var3, var5, var4);
    }

    public void draw(Graphics var1) {
        var1.fillRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
    }

    public void move(int var1) {
    }

    public int isHitting(Sprite var1) {
        int var2 = var1.getxPos();
        int var3 = var1.getyPos();
        int var4 = var1.getxPos() + var1.getWidth();
        int var5 = var1.getyPos() + var1.getHeight();
        int var6 = var1.getxPos();
        int var7 = var1.getyPos() + var1.getHeight();
        int var8 = this.getxPos();
        int var9 = this.getyPos();
        int var10 = this.getxPos() + this.getWidth();
        int var11 = this.getyPos() + this.getHeight();
        if (var8 <= var4 && var10 >= var2 && var9 <= var5 && var11 >= var3) {
            if (Math.abs(var4 - var8) > Math.abs(var5 - var9)) {
                return 2;
            }

            if (Math.abs(var4 - var8) < Math.abs(var5 - var9)) {
                return 3;
            }

            if (Math.abs(var6 - var10) < Math.abs(var7 - var9)) {
                return 1;
            }

            if (var11 <= var5) {
                return 4;
            }
        }

        return -1;
    }
}
