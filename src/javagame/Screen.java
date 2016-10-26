package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Screen extends JPanel implements ActionListener{
    int x, y, mapX;
    double changeH, changeY, changeX;

    Road road;
    Cabin cabin;
    Car car1, car2, car3;
    boolean anyad = true;
    ImageIcon bgr = new ImageIcon("bg.png");
    Image bg = bgr.getImage();
    private Timer timer;

    public Screen(){
        mapX = 50;
        x = 500;
        y = 163;
        changeY = 0.03353;
        changeH = 0.03881;
        changeX = 0.02;
        road = new Road(new int[]{480,520,2000,-1000}, new int[]{163,163,700,700}, Color.gray);
        cabin = new Cabin();
        car1 = new Car(0);
        car2 = new Car(1);
        car3 = new Car(2);
        timer = new Timer(50, this);
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
        g2d.drawImage(car1.getCar(),car1.x-car1.h/2,y-car1.h,car1.h,car1.h,this);
//        car.setCar("car_2.gif");
        g2d.drawImage(car2.getCar(),car2.x-car2.h/2,y-car2.h,car2.h,car2.h,this);
//        car.setCar("car_1.gif");
        g2d.drawImage(car3.getCar(),car3.x-car3.h/2,y-car3.h,car3.h,car3.h,this);
        g2d.drawImage(cabin.getCabin(), 0, 500, 1000, 200, this);
    }

    private void drawBackground(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg,0,0,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeH *= 1.05;
        changeY *= 1.05;
        changeX *= 1.072;
        car1.h += changeH;
        car2.h += changeH;
        car3.h += changeH;
        System.out.println(car1.getPos());
        car1.x = car1.x + (int)((car1.getPos()-mapX)*changeX*0.01);
        System.out.println(car2.getPos());
        car2.x = car2.x + (int)((car2.getPos()-mapX)*changeX*0.01);
        System.out.println(car3.getPos());
        car3.x = car3.x + (int)((car3.getPos()-mapX)*changeX*0.01);
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