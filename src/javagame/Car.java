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

    public Car(Road road){
        h = 10;
        Random rnd = new Random();
        lane = rnd.nextInt(3);
        int a = (road.xpoints[1] - road.xpoints[0])/6;
        switch (lane){
            case 0:
                pos = a;
            case 1:
                pos = a*3;
            case 2:
                pos = a*5;
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
}
