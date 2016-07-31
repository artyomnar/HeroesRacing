package BaseEntities;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Iterator;


/**
 * Created by Артем on 31.07.2016.
 */

public class Background extends JPanel implements ActionListener, Runnable{
    public Background(){
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        oponentFactory.start();
    }

    @Override
    public void run() {
        while (true){
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                oponentList.add(new Oponent(1300,rand.nextInt(600),rand.nextInt(50),this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
    Thread oponentFactory = new Thread(this); // фабрика опонентов в игре
    java.util.List<Oponent> oponentList = new ArrayList<Oponent>();

    public void paint(Graphics g){
        ((Graphics2D) g).drawImage(img,p.layer1,0,null); // рисуем фон
        ((Graphics2D) g).drawImage(img,p.layer2,0,null);
        ((Graphics2D) g).drawImage(p.img,p.x,p.y,null);

        Iterator<Oponent> i =  oponentList.iterator();
        while (i.hasNext()) {
            Oponent e = i.next();
            if (e.x >= 2400 || e.x <= -2400) {
                i.remove();
            } else {
                e.move();
                ((Graphics2D) g).drawImage(e.img, e.x, e.y, null);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();// paint вызывает
        testCrush();
    }

    private void testCrush(){
        Iterator<Oponent> i =  oponentList.iterator();
        while (i.hasNext()){
            Oponent e = i.next();
            if (p.getRect().intersects(e.getRect())){
                JOptionPane.showMessageDialog(null,"You lose!");
                System.exit(1);
                //i.remove();// при столкновении уничтожаем врага
            }

        }
    }

}


