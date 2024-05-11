package View;

import Config.Score;
import Config.Settings;
import Model.Game;
import Model.Position;
import Model.World;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel
{
    public SnakePanel()
    {
        Score score = Score.getInstance();

        add(score.getScoreText());
        reset();
    }

    public void reset()
    {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Game game = Game.getGame();
        if(!game.isAlive())
        {
            Score score = Score.getInstance();
            System.out.println("GAME OVER | Score : " + score.getScore());
            System.exit(0);
            return;
        }
        else if (game.isWin())
        {
            System.out.println("YOU WIN");
            System.exit(0);
            return;
        }

        World world = game.getWorld();
        for (int i = 0; i < world.getSize(); i++)
        {
            for(int j = 0; j < world.getSize(); j++)
            {
                Model.Position p = new Position(i, j);
                if (world.isEmpty(p))
                {
                    continue;
                }
                Color c = Color.WHITE;

                if(world.isGrass(p))
                {
                    c = Color.DARK_GRAY;
                }
                else if(world.isSnakeHead(p))
                {
                    c = Color.GRAY;
                }
                else if(world.isApple(p))
                {
                    c = Color.RED;
                }

                g.setColor(c);

                g.fillRect(i * Settings.BLOCK_SIZE, j * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE);
            }
        }
    }
}
