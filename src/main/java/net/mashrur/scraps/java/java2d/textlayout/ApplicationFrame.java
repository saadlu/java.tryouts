package net.mashrur.scraps.java.java2d.textlayout;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.BorderLayout;

public class ApplicationFrame{

    private final JFrame applicationFrame;
    
    public ApplicationFrame(){
        applicationFrame = new JFrame();
        applicationFrame.getContentPane().setLayout(new BorderLayout());


        
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

    public void addComponent(JComponent component){

        applicationFrame.getContentPane().add(component);

        applicationFrame.pack();
                
    }


    public void setVisible(boolean visible){
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }

    
    
}