package Model;

import Config.Score;

public class Game
{
    public final static int MOVE_RIGHT = 0;
    public final static int MOVE_LEFT = 1;
    public final static int MOVE_UP = 2;
    public final static int MOVE_DOWN = 3;

    private static Game game = null;

    private boolean win;
    private final World world;

    private int direction = -1;

    private Game()
    {
        win = false;
        world = new World();
    }

    public World getWorld() 
    {
        return world;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
        move();
    }

    public static Game getGame()
    {
        if (game == null)
            game = new Game();
        return game;
    }

    public static void restartGame() 
    {
        game = new Game();
    }

    public boolean isAlive() 
    {
        return world.getSnake().isAlive();
    }

    public boolean isWin() 
    {
        return win;
    }

    public void move()
    {
        Position newHead = switch (direction)
        {
            case MOVE_RIGHT -> new Position(world.getSnake().getHead().x() + 1, world.getSnake().getHead().y());
            case MOVE_LEFT -> new Position(world.getSnake().getHead().x() - 1, world.getSnake().getHead().y());
            case MOVE_UP -> new Position(world.getSnake().getHead().x(), world.getSnake().getHead().y() - 1);
            case MOVE_DOWN -> new Position(world.getSnake().getHead().x(), world.getSnake().getHead().y() + 1);
            default -> null;
        };

        if (newHead == null)
        {
            return;
        }

        if (world.isGrass(newHead) || world.isSnakeBody(newHead))
        {
            world.getSnake().setDead();
        }
        else
        {
            boolean hitApple = world.isApple(newHead);

            if (hitApple)
            {
                if (!world.generateApple())
                {
                    win = true;
                }
                else
                {
                    Score score = Score.getInstance();
                    world.getSnake().addBodyBlock(newHead);
                    score.incrementScore();
                }
            }

            world.moveSnake(newHead);
        }
    }
}
