package raceCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class Human {
	
	private JPanel jp;
	private JButton acceptHuman;
	
	// Human Traits
	String abilityScoreIncrease = "Your ability scores each increase by 1.";
	String alignment = "<html>Humans tend toward no particular alignment.<br> "
			+          "The best and worst are found among them.</html>";
	String size = "<html>Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall.<br>Regardless of your position in that range, your size is Medium.</html>";
	String speed = "Your base walking speed is 30 feet.";
	String languages = "<html>You can speak, read, and write Common and one extra language of your choice."
			+ "<br>Humans typically learn the languages of other peoples they deal with, including obscure dialects."
			+ "<br>They are fond of sprinkling their speech with words borrowed from other tongues:"
			+ "<br>Orc curses, Elvish musical expressions, Dwarvish military phrases, and so on.<html>";
	
	/**
	 * Create the panel.
	 */
	public Human() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Humans</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel(abilityScoreIncrease), "cell 1 1,alignx left,aligny bottom");
		
		// Alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right, aligny top");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left, aligny top");
		//
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 0 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 1 3,alignx left, aligny top");
		
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 0 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 1 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 1 5,alignx left, aligny top");
		
		acceptHuman = new JButton("Accept Human as Your Race");
		jp.add(acceptHuman, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedHumanButton(){return acceptHuman;}
	
}
