package BaseEntities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Артем on 31.07.2016.
 */
public class Player {
    public static final int maxSpeed = 70;
    public static final int maxTop = 0;
    public static final int maxBottom = 460;

    Image img = new ImageIcon("res/IM-Model2.png").getImage();

    public Rectangle getRect(){
        return new Rectangle(x, y, 230, 150);
    }

    int speed = 0;
    int boost = 0; //ускорение
    int pathway = 0; //путь
    int x = 0; //начальные координаты
    int y = 200;
    int dy = 0;
    int layer1 = 0; //слой
    int layer2 = 1300;

    public void move(){
        pathway += speed;
        speed += boost;
        if (speed <= 0) speed = 0;
        if (speed >= maxSpeed) speed = maxSpeed;
        y -= dy;
        if (y <= maxTop) y = maxTop;
        if (y >= maxBottom) y = maxBottom;
        if (layer2 - speed <= 0){
            layer1 = 0;
            layer2 = 1300;
        } else {
            layer1 -= speed;
            layer2 -= speed;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT){
            boost = 5;
        }
        if (key == KeyEvent.VK_LEFT){
            boost = -5;
        }
        if (key == KeyEvent.VK_UP){
            dy = 10;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = -10;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
            boost = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }
}
