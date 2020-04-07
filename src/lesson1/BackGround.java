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
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) { //обработка искл. прерывания потока другим потоком
//            e.printStackTrace();
//        }
        repaint();
    }
}
