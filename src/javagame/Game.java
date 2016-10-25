package javagame;
import javax.swing.*;

public class Game extends JFrame {

    static JFrame F = new Game();
    Screen screen = new Screen();

    public Game() {

        add(screen);
        setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String [] args) {

    }
}
