package javagame;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;

public class Road {

    Polygon P;
    Color c;

    public Road(int[] x, int[] y, Color c) {
        P = new Polygon();
        P.xpoints = x;
        P.ypoints = y;
        P.npoints = x.length;
        this.c = c;
    }
    public void drawRoad(Graphics g){
        g.setColor(c);
        g.fillPolygon(P);
    }


}
