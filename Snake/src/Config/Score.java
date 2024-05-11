package Config;

import javax.swing.*;
import java.awt.*;

public class Score {
    private static Score instance;

    private int score;
    JLabel scoreText = new JLabel("SCORE : " + score);

    private Score()
    {
        this.score = 0;
        scoreText.setForeground(Color.WHITE);
    }

    public static Score getInstance()
    {
        if (instance == null)
        {
            instance = new Score();
        }
        return instance;
    }

    public JLabel getScoreText() {
        return scoreText;
    }

    public void incrementScore() {
        score += 1;
        scoreText.setText("SCORE : " + score);
    }

    public int getScore() {
        return score;
    }
}
