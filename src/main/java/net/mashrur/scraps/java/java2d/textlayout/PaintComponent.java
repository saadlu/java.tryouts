package net.mashrur.scraps.java.java2d.textlayout;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.font.TextLayout;
import java.awt.RenderingHints;
import java.text.AttributedString;
import java.text.AttributedCharacterIterator;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.LineMetrics;

import java.awt.Font;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintComponent extends JComponent{

    private static final Logger LOGGER = LogManager.getLogger("PaintComponent");
    private final String textToPaint;
    public PaintComponent(String textToPaint){
        this.textToPaint = textToPaint;
        setPreferredSize(new Dimension(600,600));
    }

    @Override
    public void paint(Graphics g){

        LOGGER.debug("paint called");

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(0,0,getWidth(),getHeight());

        g2.setColor(Color.black);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("SansSerif", Font.PLAIN, 32);
        g2.setFont(font);

        int x = 10;
        int y = 50;
        
        g2.drawString(textToPaint, x, y);

        LineMetrics lm = font.getLineMetrics(textToPaint, g2.getFontRenderContext());

        
        g.drawLine(x, y, x+100, y);

        g.drawLine(x, (int)(y-lm.getAscent()), x+100, (int)(y-lm.getAscent()));
        g2.setColor(Color.red);
        int m = (int)lm.getBaselineOffsets()[1];
        g.drawLine(x, y+m, x+100, y+m);
        g.drawLine(x, y+2*m, x+100, y+2*m);
        /*
        AttributedString textToPaintAS = new AttributedString(textToPaint);
        textToPaintAS.addAttribute(TextAttribute.FONT, font);
        LineBreakMeasurer lbm = new LineBreakMeasurer(textToPaintAS.getIterator(),g2.getFontRenderContext());

        int x = 10;
        int y = 0;
        while(lbm.getPosition() < textToPaintAS.getIterator().getEndIndex()){
            TextLayout textLayout = lbm.nextLayout(getWidth());
            y+=textLayout.getAscent();
            textLayout.draw(g2,x,y);
            y+=textLayout.getDescent() + textLayout.getLeading();
        }

        */
        //g2.drawString(textToPaintAS.getIterator(), 10,40);
    }

}