package javagame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;


public class Screen extends JPanel implements ActionListener{
    int mapX;
    double changeH, changeY, changeX;
    private Graphics g;
    Road road;
    Cabin cabin;
    List<Car> cars;
    boolean anyad = true;
    ImageIcon bgr = new ImageIcon("bg.png");
    Image bg = bgr.getImage();
    Image exp;
    private Timer timer;

    public Screen(){
        mapX = 50;
        changeY = 0.03353;
        changeH = 0.03881;
        changeX = 0.02;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        cabin = new Cabin();
        cars = new ArrayList<Car>();
        timer = new Timer(50, this);
        timer.start();
        ImageIcon expl = new ImageIcon("explosion.png");
        exp = expl.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (anyad){
            drawBackground(g);
        }

        road = new Road(
                new int[]{
                        480,
                        520,
                        this.convertMapXR(cabin.getMapX()),
                        this.convertMapXL(cabin.getMapX())},
                new int[]{
                        163,
                        163,
                        700,
                        700},
                Color.gray);
        road.drawRoad(g);
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        for (int i=0; i<cars.size(); i++){
            g2d.drawImage(cars.get(i).getCar(), cars.get(i).x - cars.get(i).h / 2, cars.get(i).y - cars.get(i).h, cars.get(i).h, cars.get(i).h, this);
            if (cars.get(i).tick >= 130) {
                if (abs(cabin.getMapX() - cars.get(i).getPos()) < 11) {
                    g2d.drawImage(exp, 250, 160, cars.get(i).h, cars.get(i).h, this);
                    timer.stop();
                    System.out.println("gameover");
                } else {
                    cars.remove(i);
                }
            }

        }
//        g2d.drawImage(car1.getCar(),car1.x-car1.h/2,y-car1.h,car1.h,car1.h,this);
//        g2d.drawImage(car2.getCar(),car2.x-car2.h/2,y-car2.h,car2.h,car2.h,this);
//        g2d.drawImage(car3.getCar(),car3.x-car3.h/2,y-car3.h,car3.h,car3.h,this);
        g2d.drawImage(cabin.getCabin(), 0, 500, 1000, 200, this);
    }

    private void drawBackground(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg,0,0,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rnd = new Random();
        if (rnd.nextInt(25)==0) {
            cars.add(0, new Car());
        }
//        changeH *= 1.05;
//        changeY *= 1.05;
//        changeX *= 1.072;
        for (int i=0; i<cars.size(); i++){
//            if (cars.get(i).tick >= 130) {
//                if (abs(cabin.getMapX() - cars.get(i).getPos()) < 11){
//                    Graphics2D g2d = (Graphics2D) g;
//                    g2d.drawImage(exp,cars.get(i).x,cars.get(i).y,cars.get(i).h,cars.get(i).h,this);
//                    timer.stop();
//                    System.out.println("gameover");
//                }
//                else {
//                    cars.remove(i);
//                }

            cars.get(i).changeH *= 1.05;
            cars.get(i).changeY *= 1.05;
            cars.get(i).changeX *= 1.072;
            cars.get(i).tick += 1;
            cars.get(i).h += cars.get(i).changeH;
            cars.get(i).x += (int) ((cars.get(i).getPos() - cabin.getMapX()) * cars.get(i).changeX * 0.01);
            cars.get(i).y += (int) cars.get(i).changeY;

        }
//        car1.h += changeH;
//        car2.h += changeH;
//        car3.h += changeH;
//        car1.x = car1.x + (int)((car1.getPos()-cabin.getMapX())*changeX*0.01);
//        car2.x = car2.x + (int)((car2.getPos()-cabin.getMapX())*changeX*0.01);
//        car3.x = car3.x + (int)((car3.getPos()-cabin.getMapX())*changeX*0.01);
//        y = y + (int)changeY;
            repaint();
    }

    private int convertMapXL(int mapx) {
       return -mapx*40-500;
    }

    private int convertMapXR(int mapx) {
        return 40*-(mapx-100) + 1500;
    }

    private class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        cabin.keyPressed(e);
    }
}
}