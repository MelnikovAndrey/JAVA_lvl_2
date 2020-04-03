package lesson1;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {     // конструктор главного окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //...
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); //...
        GameCanvas canvas = new GameCanvas(this);   // присвоение переменной ссылки на объект ссылающийся на конструктор который его вызывает
        add(canvas, BorderLayout.CENTER);   //добавление на окно канвы с размещением в центре
        setTitle("Circles"); //...
        initApplication(); //заполняем массив объектов
        setVisible(true); //...
    }

    private void initApplication() {       // заполнения массива объектов
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float delta) {
        update(canvas, delta);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}