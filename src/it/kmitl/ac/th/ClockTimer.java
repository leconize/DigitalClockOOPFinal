package it.kmitl.ac.th;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.TimeZone;

public class ClockTimer extends Thread {
    SimpleDateFormat simpleDateFormat;
    JLabel timeJLabel;
    String town;

    ClockTimer(JLabel timeLabel, String timezone){
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.town = timezone;
        this.timeJLabel = timeLabel;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            timeJLabel.setText(town + " : "+simpleDateFormat.format(new Date()));
        }
    }
}
