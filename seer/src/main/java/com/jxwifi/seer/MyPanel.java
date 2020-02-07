package com.jxwifi.seer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 显示面板
 */
public class MyPanel extends JPanel implements Runnable {


   private int pIndex=0;

    public MyPanel() {
        this.setBackground(new Color(0x666666));
    }

    @Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        arg0.setColor(new Color(0x00ff00));
        arg0.drawRect(Hospital.getInstance().getX(),Hospital.getInstance().getY(),
                Hospital.getInstance().getWidth(),Hospital.getInstance().getHeight());

        List<Person> people = PersonPool.getInstance().getPersonList();
        if(people==null){
            return;
        }
        people.get(pIndex).update();
        for(Person person:people){

            switch (person.getState()){
                case Person.PersonState.NORMAL:{
                    arg0.setColor(new Color(0xdddddd));

                }break;
                case Person.PersonState.SHADOW:{
                    arg0.setColor(new Color(0xffee00));

                }break;
                case Person.PersonState.CONFIRMED:
                case Person.PersonState.FREEZE:{
                    arg0.setColor(new Color(0xff0000));

                }break;
            }
            person.update();
            arg0.fillOval(person.getX(), person.getY(), 4, 4);

        }
        pIndex++;
        if(pIndex>=people.size()){
            pIndex=0;
        }
    }

    public static int worldTime=0;
    @Override
    public void run() {
        while (true) {

            this.repaint();

            try {
                Thread.sleep(100);
                worldTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
