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

    public Car(int rnd){
        h = 10;
        // Random rnd = new Random();
        lane = rnd;
        switch (rnd){
            case 0:
                pos = 17;
                this.x = 487;
                break;
            case 1:
                pos = 50;
                this.x = 500;
                break;
            case 2:
                pos = 82;
                this.x = 513;
                break;
        }
        z = 100;
        ImageIcon carImage = new ImageIcon("car_3.gif");
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
