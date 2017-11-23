package it.kmitl.ac.th;

import javax.swing.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock extends JFrame{

    DigitalClock(){
        super();
        this.setTitle("Digital Clock");
        this.setBounds(0, 0, 600, 330);
        this.setLayout(null);


        JLabel thaiTime = new JLabel();
        JLabel londonTime = new JLabel();
        JLabel japanTime = new JLabel();

        this.add(thaiTime);
        this.add(londonTime);
        this.add(japanTime);

        thaiTime.setBounds(0, 0, 300, 50);
        londonTime.setBounds(0, 50, 300, 50);
        japanTime.setBounds(0, 100, 300, 50);

        //https://www.mkyong.com/java/java-display-list-of-timezone-with-gmt/
        //reference for choose time zone

        /*

        you can you this source code for check available time zone

        String[] ids = TimeZone.getAvailableIDs();
		for (String id : ids) {
			System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
		}

		System.out.println("\nTotal TimeZone ID " + ids.length);
         */
        new ClockTimer(thaiTime, "Asia/Bangkok").start();
        new ClockTimer(londonTime, "Europe/London").start();
        new ClockTimer(japanTime, "Japan").start();



        this.setVisible(true);

    }
}