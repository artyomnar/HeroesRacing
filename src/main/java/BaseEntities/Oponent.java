package BaseEntities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Артем on 31.07.2016.
 */
public class Oponent {
    int x;
    int y;
    int speed;
    Background background;
    Image img = new ImageIcon("res/GG-Model2.png").getImage();

    public Rectangle getRect(){
        return new Rectangle(x, y, 200, 115);
    }

    public Oponent (int x, int y, int speed, Background background){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.background = background;
    }

    public void move(){
        x = x - background.p.speed + speed;
    }
}
