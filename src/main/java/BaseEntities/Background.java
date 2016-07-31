package BaseEntities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by Артем on 31.07.2016.
 */

public class Background extends JPanel implements ActionListener{
    public Background(){
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    Image img = new ImageIcon("res/BGSpace.jpg").getImage(); // задаем фон фрэйма
    Player p = new Player();
    Timer mainTimer = new Timer(20, this); // таймер запускает функцию ActionPerformed каждые 20 милисек в объекте this, реализующий интерфейс ActionListener

    public void paint(Graphics g){
        ((Graphics2D) g).drawImage(img,p.layer1,0,null); // рисуем фон
        ((Graphics2D) g).drawImage(img,p.layer2,0,null);
        ((Graphics2D) g).drawImage(p.img,p.x,p.y,null);
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();// paint вызывает
    }
}


