package lesson1;

import java.awt.*;

public class Ball extends Sprite {

    private final Color color = new Color (
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)      // генерация случайного цвета для шаров
    );
    private float vX = (float)(100f + (Math.random() * 200f));  // скорость шаров по Х,   Math.random() - случ число от 0 вкл. до 1 невкл.
    private float vY = (float)(100f + (Math.random() * 200f));  // скорость по У

    Ball() {    //конструктор объекта
        halfHeight = 20 + (float)(Math.random() * 50f);     // половина высоты шара
        halfWidth = halfHeight;                             //половина ширины шара
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {   // смена позиции обеъкта
        x += vX * deltaTime;
        y += vY * deltaTime;
        // условия изменения направления скорости по осям (смена напр движения)
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    void render(GameCanvas canvas, Graphics g) {        // переопределение метода
        g.setColor(color);                              // определение цвета шара
        g.fillOval((int) getLeft(), (int) getTop(),     // прорисовка шара
                (int) getWidth(), (int) getHeight());
    }


}