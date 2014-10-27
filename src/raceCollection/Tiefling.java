package raceCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import dndProject.RaceMenu;

public class Tiefling {
	
	private JPanel jp;
	private JButton acceptTiefling;
	
	// Tiefling traits
	String abilityScoreIncrease = "Your Intelligence score increases by 1, and your Charisma score increases by 2.";
	String alignment = "<html>Tieflings might not have an innate tendency toward evil, but many of them end up there."
			+          "<br> Evil or not, an independant nature inclines many tieflings toward a chaotic alignment.</html";
	String size = "Tieflings are about the same size and build as humans. Your size is Medium.";
	String speed = "Your base walking speed is 30 feet.";
	String darkvision = "<html>Thanks to your infernal heritage, you have superior vision in dark and dim conditions."
			+           "<br> You can see in dim light within 60 feet of you as if it were bright light,<br> "
			+           "and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.";
	String hellishResistance = "You have resistance to fire damage.";
	String infernalLegacy = "<html>You know the thaumaturgy cantrip. Once you reach 3rd level,"
			+               "<br> you can cast the hellish rebuke spell once per day as a 2nd-level spell."
			+               "<br> Once you reach 5th level, you can also cast the darkness spell once per day."
			+               "<br> Charisma is your spellcasting ability for these spells.</html>";
	String languages = "You can speak, read, and write Common and Infernal";
	
	/**
	 * Create the panel.
	 */
	public Tiefling() {
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[5%][20%][70%][5%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Tiefling</font></html>"), "cell 0 0 4 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 1 1,alignx right,aligny bottom");
		jp.add(new JLabel(abilityScoreIncrease), "cell 2 1,alignx left,aligny bottom");
		
		// Alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 1 2,alignx right, aligny top");
		jp.add(new JLabel(alignment), "cell 2 2,alignx left, aligny top");
		//
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 1 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 2 3,alignx left, aligny top");
		
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 1 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 2 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 1 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 2 5,alignx left, aligny top");
		
		//DarkVision
		jp.add(new JLabel("<html><b>Darkvision:</b></html>"), "cell 1 6,alignx right, aligny top");
		jp.add(new JLabel(darkvision), "cell 2 6,alignx left, aligny top");
		
		//Hellish Resistace
		jp.add(new JLabel("<html><b>Hellish Resistance:</b></html>"), "cell 1 7,alignx right, aligny top");
		jp.add(new JLabel(hellishResistance), "cell 2 7,alignx left, aligny top");
		
		//Infernal Legacy
		jp.add(new JLabel("<html><b>Infernal Legacy:</b></html>"), "cell 1 8,alignx right, aligny top");
		jp.add(new JLabel(infernalLegacy), "cell 2 8,alignx left, aligny top");
		
		acceptTiefling = new JButton("Accept Tiefling as Your Race");
		jp.add(acceptTiefling, "cell 0 9 4 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptTiefling;}
	
}
