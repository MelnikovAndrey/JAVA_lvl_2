package lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles listener; //создание пустой объектной переменной класса для доступа к методам класса
    long lastFrameTime; //...

    GameCanvas(MainCircles listener) { //конструктор класса
        this.listener = listener;   //...
        lastFrameTime = System.nanoTime();  //...
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // вызов конструктора супер класса
        //60 frames per second
        long currentTime = System.nanoTime(); // считывание и запись машинного времени
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //...
        lastFrameTime = currentTime;    //...
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) { //обработка искл. прерывания потока другим потоком
            e.printStackTrace();
        }
        repaint();
    }
        // определение границ канвы
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}