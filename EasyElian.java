/*Todo
	-make convert button actually work
	-make the 2 textareas stay consistent size
*/

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
		
public class EasyElian {
	public static void main(String [] args) throws Exception{
	
		//Setup the GUI
		JFrame mainFrame = new JFrame("EasyElian");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel englishPanel = new JPanel();
		mainFrame.add(englishPanel, BorderLayout.LINE_START);
		JTextArea englishField = new JTextArea("Please enter English here then click Convert.",10,5);
		englishPanel.add(englishField);
		
		JPanel elianPanel = new JPanel();
		mainFrame.add(elianPanel, BorderLayout.LINE_END);
		JTextArea elianField = new JTextArea(10,5);
		elianPanel.add(elianField);
		
		//Setup the elian textarea
		elianField.setEditable(false);
		
		//Create the ElianScript font and set the textarea to that font
		File f = new File("elian_cc_variant.ttf");
		FileInputStream in = new FileInputStream(f);
		Font elianFont = Font.createFont(Font.TRUETYPE_FONT, in);
		
		elianField.setFont(elianFont);
		
		//Add button to translate text
		JButton copy = new JButton( "Convert" );
		copy.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
               elianField.setText(englishField.getSelectedText());
            }
         }
		);
		mainFrame.add(copy, BorderLayout.PAGE_END);
		
		//Show the GUI for user interaction
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}