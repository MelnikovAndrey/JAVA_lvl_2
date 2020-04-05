package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[5];

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
        BackGround backGround = new BackGround(this);
        add(backGround, BorderLayout.CENTER);
        backGround.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == 1) {
                    sprites = increaseArr(sprites);
                    System.out.println("клик левой, значение n = " + sprites.length);
                }
                if (e.getButton() == 3) {
                    sprites = reduceArr(sprites);
                    System.out.println("клик правой, значение n = " + sprites.length);
                }
            }
        });
        setTitle("Circles"); //...
        initApplication(); //...
        setVisible(true); //...
    }

    private static Sprite[] increaseArr(Sprite[] sprite){
        Sprite[] sprites1 = new Sprite[sprite.length + 1];
        System.arraycopy(sprite,0,sprites1,0, sprite.length);
        sprites1[sprites1.length-1] = new Ball();
        return sprites1;
    }
    private static Sprite[] reduceArr(Sprite[] sprite){
        Sprite[] sprites1 = new Sprite[sprite.length - 1];
        sprites1 = Arrays.copyOf(sprite, sprites1.length);
        return sprites1;
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
        for (Sprite sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.render(canvas, g);
        }
    }
}