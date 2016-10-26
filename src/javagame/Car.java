package javagame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Car {
    private int z;
    private int pos;
    private int lane;
    private Image car;
    public int h;
    public int x;
    public int y;
    public int tick;
    public double changeH;
    public double changeX;
    public double changeY;

    public Car(){
        changeY = 0.03353;
        changeH = 0.03881;
        changeX = 0.02;
        tick = 0;
        y = 163;
        h = 10;
        ImageIcon carImage;
        Random rnd = new Random();
        lane = rnd.nextInt(3);
        switch (lane){
            case 0:
                pos = 17;
                this.x = 487;
                carImage = new ImageIcon("car_1.gif");
                break;
            case 1:
                pos = 50;
                this.x = 500;
                carImage = new ImageIcon("car_2.gif");
                break;
            default:
                pos = 82;
                this.x = 513;
                carImage = new ImageIcon("car_3.gif");
                break;
        }
        z = 100;
        car = carImage.getImage();
    }
    public Image getCar(){
        return car;
    }
    public void setCar(String filename){
        ImageIcon carImage = new ImageIcon(filename);
        car = carImage.getImage();
    }
    public int getPos(){
        return this.pos;
    }
}
