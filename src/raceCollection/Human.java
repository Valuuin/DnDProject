package raceCollection;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import dndProject.RaceMenu;
import net.miginfocom.swing.MigLayout;

public class Human extends RaceMenu  {
	
	private JPanel jp;
	
	// Human Traits
	String abilityScoreIncrease = "Your ability scores each increase by 1.";
	String alignment = "<html>Humans tend toward no particular alignment.<br> "
			+          "The best and worst are found among them.</html>";
	String size = "Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall."
			+ "      Regardless of your position in that range, your size is Medium.";
	String speed = "Your base walking speed is 30 feet.";
	String languages = "You can speak, read, and write Common and one extra language of your choice."
			+ "           Humans typically learn the languages of other peoples they deal with, including obscure dialects."
			+ "           They are fond of sprinkling their speech with words borrowed from other tongues:"
			+ "           Orc curses, Elvish musical expressions, Dwarvish military phrases, and so on.";
	
	/**
	 * Create the panel.
	 */
	public Human() {

		Border blackLine = BorderFactory.createLineBorder(Color.black);
		JLabel human = new JLabel(abilityScoreIncrease);
		human.setBorder(blackLine);
		

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("Human"), "span, alignx center, aligny center");
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel(abilityScoreIncrease), "cell 1 1,alignx left,aligny bottom");
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right, aligny top");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left, aligny top");
		
	}

	public JPanel getJPanel(){return jp;}
	
}
