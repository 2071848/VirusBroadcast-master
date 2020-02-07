package com.jxwifi.seer;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class Main {


    private static int screen_width=1000;
    private static int screen_heigth=1000;


    public static void main(String[] args) {
        MyPanel p = new MyPanel();
        Thread panelThread = new Thread(p);
        JFrame frame = new JFrame();
        frame.add(p);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen_heigth= ((int) screenSize.getHeight()-50);
        screen_width= (int) screenSize.getWidth();

        frame.setSize(screen_width, screen_heigth);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelThread.start();

        List<Person> people = PersonPool.getInstance().getPersonList();
        for(int i=0;i<Constants.ORIGINAL_COUNT;i++){
            int index = new Random().nextInt(people.size()-1);
            Person person = people.get(index);

            while (person.isInfected()){
                index = new Random().nextInt(people.size()-1);
                person = people.get(index);
            }
            person.beInfected();

        }


    }
}
