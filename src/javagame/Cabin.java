package javagame;


import javax.swing.*;
import java.awt.*;

public class Cabin {

    private int drawX;
    private int drawY;
    private Image cabin;

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


}
