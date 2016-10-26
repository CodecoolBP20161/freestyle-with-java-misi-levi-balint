package javagame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Cabin {

    private int drawX;
    private int drawY;
    private Image cabin;
    private int mapX = 50;

    public Cabin() {

        initCabin();
    }

    private void initCabin() {

        ImageIcon cabinImage = new ImageIcon("cabin.png");
        cabin = cabinImage.getImage();

        drawX = 0;
        drawY = 800;
    }
    public Image getCabin(){
        return cabin;
    }
    public int getDrawX(){
        return drawX;
    }
    public int getDrawY(){
        return drawY;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (this.mapX > 0) {
                this.mapX -= 3;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            if (this.mapX < 100) {
                this.mapX += 3;
            }
        }
    }

    public int getMapX() {
        return this.mapX;
    }


}
