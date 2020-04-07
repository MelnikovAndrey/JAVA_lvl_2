package lesson1;

import java.awt.*;

public abstract class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    protected float getLeft() {
        return x - halfWidth;   // получение координаты левой границы объекта
    }
    protected void setLeft(float left) {
        x = left + halfWidth;   // изменение координаты по оси Х в большую сторону
    }
    protected float getRight() {
        return x + halfWidth;   // получение координаты правой границы объекта
    }
    protected void setRight(float right) {
        x = right - halfWidth;  // изменение координаты по оси Х в меньшую сторону
    }
    protected float getTop() {
        return y - halfHeight;  // получение координаты верхней границы объекта
    }
    protected void setTop(float top) {
        y = top + halfHeight;   // изменение координаты по оси У в большую сторону
    }
    protected float getBottom() {
        return y + halfHeight;  // получение координаты нижней границы объекта
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight; // изменение координаты по оси У в меньшую сторону
    }
    protected float getWidth() { // получение значения полной ширины
        return 2f * halfWidth;
    }
    protected float getHeight() {   // получение значения полной высоты
        return 2f * halfHeight;
    }
        //абстрактные методы
    void update(GameCanvas canvas, float deltaTime) {}
    void render(GameCanvas canvas, Graphics g) {}

}