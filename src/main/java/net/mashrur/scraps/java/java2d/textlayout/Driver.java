package net.mashrur.scraps.java.java2d.textlayout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.SwingUtilities;

public class Driver{

    private static final Logger LOGGER = LogManager.getLogger("Try");

    public static void main(String [] args){
        
        SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    ApplicationFrame applicationFrame = new ApplicationFrame();
                    applicationFrame.addComponent(new PaintComponent("ERRORÀÇESaad is my name"));
                    applicationFrame.setVisible(true); 
                }
            });

        
    }

}