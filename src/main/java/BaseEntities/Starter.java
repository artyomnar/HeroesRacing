package BaseEntities;

import javax.swing.*;

/**
 * Created by Артем on 31.07.2016.
 */
public class Starter {
    public static void main(String[] args) {
        JFrame f = new JFrame("Heroes Racing"); //создаем фрэйм, в конструкторе заголовок окна
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //событие по закрытию
        f.setSize(1300,700);//установка размеров фрэйма и видимости
        f.add(new Background()); // добавляем обьект фона на фрэйм
        f.setVisible(true);



    }
}
