package Controller;

import Model.Game;
import View.SnakePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeListener extends KeyAdapter
{
    private final SnakePanel snakePanel;

    public SnakeListener(SnakePanel snakePanel)
    {
        this.snakePanel = snakePanel;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
            case KeyEvent.VK_N:
                Game.restartGame();
                snakePanel.reset();
                break;
            case KeyEvent.VK_A:
                Game.getGame().setDirection(Game.MOVE_LEFT);
                break;
            case KeyEvent.VK_D:
                Game.getGame().setDirection(Game.MOVE_RIGHT);
                break;
            case KeyEvent.VK_S:
                Game.getGame().setDirection(Game.MOVE_DOWN);
                break;
            case KeyEvent.VK_W:
                Game.getGame().setDirection(Game.MOVE_UP);
                break;
        }
        snakePanel.repaint();
    }
}
