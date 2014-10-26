package raceCollection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dndProject.RaceMenu;
import net.miginfocom.swing.MigLayout;

public class Human extends RaceMenu  {
	
	// Human Traits
	String abilityScoreIncrease = "Ability Score Increaase: Your ability scores each increase by 1.\n";
	String alignment = "Alignment: Humans tend toward no particular alignment.\n"
			+ "           The best and worst are found among them.\n";
	String size = "Size: Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall.\n"
			+ "      Regardless of your position in that range, your size is Medium.\n";
	String speed = "Speed: Your base walking speed is 30 feet.";
	String languages = "Languages: You can speak, read, and write Common and one extra language of your choice.\n"
			+ "           Humans typically learn the languages of other peoples they deal with, including obscure dialects.\n "
			+ "           They are fond of sprinkling their speech with words borrowed from other tongues:\n"
			+ "           Orc curses, Elvish musical expressions, Dwarvish military phrases, and so on.";
	
	
	String Traits = "                              Human                                            \n"
				    + abilityScoreIncrease + alignment + size + speed + languages;
	
	/**
	 * Create the panel.
	 */
	public Human() {

		JPanel jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[100%,center]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		//"", "[100%,center]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"
		jp.add(new JLabel("Human"), "dock north");
		//jp.add(new JLabel(abilityScoreIncrease), "alignx right, aligny center");
		//jp.add(new JLabel(alignment), "alignx right, aligny center");
		
	}

//	public JScrollPane getScrollPane(){}
	
}
