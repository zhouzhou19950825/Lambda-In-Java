package com.upic.LambdaTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionEventDemo {
    private JButton button = new JButton();


    public void bindEvent(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("你好！" );

            }
        });
    }

    /**
     * 使用Lambda表达式 为button添加ActionListener
     */
    public void bindEventByLambda(){
        button.addActionListener(e -> System.out.println("你好！"));
    }
}