package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class MyFrameDate extends JFrame {
    JLabel dateLabel,randomPickLabel;
    public MyFrameDate(){
        this.setBounds(100,100,300,300);
        this.setVisible(true);
    }
    public MyFrameDate(String s){
        super(s);
        this.setBounds(100,100,300,300);
        this.setVisible(true);
    }
    public void showTime(){
        FlowLayout layout=new FlowLayout();
        setLayout(layout);
        //设置对齐方式
        layout.setAlignment(FlowLayout.LEFT);
        JButton b1=new JButton("显示时间");
        add(b1);
        dateLabel=new JLabel("点击显示时间");
        add(dateLabel);
        JButton b2=new JButton("随机点名");
        add(b2);
        randomPickLabel=new JLabel("点击显示学号");
        add(randomPickLabel);
        //添加监视器
        ActionListener Listener1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDate();
            }
        };
        b1.addActionListener(Listener1);
        ActionListener Listener2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomPick();
            }
        };
        b2.addActionListener(Listener2);
    }
    public void showDate(){
        Date nowTime=new Date();
        dateLabel.setText(nowTime.toString());
    }
    public void randomPick(){
        Random random=new Random();
        int
                i=random.nextInt(36);
        if(i==0||i==1){
            randomPickLabel.setText("20203606130");
        }
        else if(i<=10){
            randomPickLabel.setText("20208117010"+i);
        }
        else{
            randomPickLabel.setText("2020811701"+i);
        }
    }
}

