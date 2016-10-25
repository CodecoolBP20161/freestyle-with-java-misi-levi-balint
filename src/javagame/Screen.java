package javagame;

import javax.swing.*;
import java.awt.*;


public class Screen extends JPanel {

    Road road;
    Cabin cabin;
    boolean anyad = true;
    ImageIcon bgr = new ImageIcon("bg.png");
    Image bg = bgr.getImage();
    public Screen(){
        road = new Road(new int[]{480,520,2000,-1000}, new int[]{163,163,700,700}, Color.gray);
        cabin = new Cabin();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (anyad){
            drawBackground(g);
        }

        road.drawRoad(g);
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(cabin.getCabin(), 0, 500, 1000, 200, this);
    }

    private void drawBackground(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg,0,0,this);
    }
}