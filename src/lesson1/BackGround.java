package lesson1;

import java.awt.*;

public class BackGround extends GameCanvas{

    public BackGround(MainCircles listener) {
        super(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
        setBackground(color);
        repaint();
    }
}
