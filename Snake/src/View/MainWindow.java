package View;

import Config.Settings;
import Controller.SnakeListener;

import javax.swing.*;

public class MainWindow
{
    public static void launch()
    {
        JFrame f = new JFrame();
        f.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);

        SnakePanel panel = new SnakePanel();

        f.add(panel);
        f.setUndecorated(true);
        panel.addKeyListener(new SnakeListener(panel));
        panel.setFocusable(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
