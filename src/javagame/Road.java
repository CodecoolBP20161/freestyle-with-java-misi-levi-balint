package javagame;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;

public class Road extends Polygon{

    Color c;

    public Road(int[] x, int[] y, Color c) {
        xpoints = x;
        ypoints = y;
        npoints = x.length;
        this.c = c;
    }
    public void drawRoad(Graphics g){
        g.setColor(c);
        g.fillPolygon(this);
    }


}
