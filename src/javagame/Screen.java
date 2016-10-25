package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Screen extends JPanel implements ActionListener{
    int x, y;
    double changeH, changeY;

    Road road;
    Cabin cabin;
    Car car;
    boolean anyad = true;
    ImageIcon bgr = new ImageIcon("bg.png");
    Image bg = bgr.getImage();
    private Timer timer;

    public Screen(){
        x = 500;
        y = 163;
        changeY = 2.4;
        changeH = 2.8;
        road = new Road(new int[]{480,520,2000,-1000}, new int[]{163,163,700,700}, Color.gray);
        cabin = new Cabin();
        car = new Car(road);
        timer = new Timer(500, this);
        timer.start();
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
//        g2d.drawImage(car.getCar(),-150,100,400,400,this);
//        car.setCar("car_2.gif");
        g2d.drawImage(car.getCar(),x-car.h/2,y-car.h,car.h,car.h,this);
//        car.setCar("car_1.gif");
//        g2d.drawImage(car.getCar(),700,100,400,400,this);
        g2d.drawImage(cabin.getCabin(), 0, 500, 1000, 200, this);
    }

    private void drawBackground(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg,0,0,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeH *= 1.4;
        changeY *= 1.4;
        car.h += changeH;
        y = y + (int)changeY;
        repaint();
    }

//    private class TAdapter extends KeyAdapter{
//
//        @Override
//        public void keyPressed(keyEvent e){
//            cabin.keyPressed(e);
//        }
//    }
}