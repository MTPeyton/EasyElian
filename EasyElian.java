/*
Created by Matthew Peyton
2016

ElianScript Font Used: https://github.com/komiga/elian-fonts
elian_cc_variant.ttf

Other Resources Used:
http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/Createfontfromtruetypefont.htm
http://www.java-tips.org/java-se-tips-100019/15-javax-swing/757-how-to-copy-selected-text-from-one-text-area-to-another.html
*/
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.util.Timer;
		
public class EasyElian {
	
	public static JTextArea englishField;
	public static JTextArea elianField;
	
	public static void main(String [] args) throws Exception{
	
		//Setup the main frame
		JFrame mainFrame = new JFrame("EasyElian");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setup the english pane
		englishField = new JTextArea("Please enter English here.\nNewline formatting is preserved.",20,40);
		JScrollPane englishPanel = new JScrollPane(englishField);
		mainFrame.add(englishPanel, BorderLayout.WEST);
		
		//Set up the elian panel
		elianField = new JTextArea(20,40);
		JScrollPane elianPanel = new JScrollPane(elianField);
		mainFrame.add(elianPanel, BorderLayout.CENTER);
		
		//Setup the elian textarea
		elianField.setEditable(false);
		
		//Create the ElianScript font and set the textarea to that font
		File f = new File("elian_cc_variant.ttf");
		FileInputStream in = new FileInputStream(f);
		Font elianFont = Font.createFont(Font.TRUETYPE_FONT, in);
		Font elianFontSized = elianFont.deriveFont(32F);
		
		elianField.setFont(elianFontSized);
		
		//Show the GUI for user interaction
		mainFrame.setResizable(false);
		//mainFrame.pack();
		mainFrame.setSize(1000,500);
		mainFrame.setVisible(true);

		Timer timer = new Timer();
		timer.schedule(new RealTimeTranslate(), 0, 250);
	}
	
	private static class RealTimeTranslate extends TimerTask{
		public void run() {
			elianField.setText(englishField.getText());
		}
	}
}