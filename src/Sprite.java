//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public abstract class Sprite {
    private int xPos;
    private int yPos;
    private int speed;
    private int direction;
    private int width;
    private int height;

    public Sprite(int var1, int var2, int var3, int var4, int var5) {
        this.xPos = var1;
        this.yPos = var2;
        this.speed = var3;
        this.width = var4;
        this.height = var5;
    }

    public abstract void draw(Graphics var1);

    public abstract void move(int var1);

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void setxPos(int var1) {
        this.xPos = var1;
    }

    public void setyPos(int var1) {
        this.yPos = var1;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int var1) {
        this.direction = var1;
    }

    public void setSpeed(int var1) {
        this.speed = var1;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
