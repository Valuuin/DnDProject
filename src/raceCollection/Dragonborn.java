package raceCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DragonBorn  {

	private JPanel jp;
	private JButton acceptDragonBorn;
	
	// Dragonborn traits
	String abilityScoreIncrease = "Your Strength score increases by 2, and your Charisma score increases by 1";
	String alignment = "<html>Dragonborn tend to extremes, making a conscious choice for one side or the other "
			+          "in the cosmic war between good and evil (represented by Bahamut and Tiamat, respectively).<br> "
			+          "Most dragonborn are good, but those who side with Tiamat can be terrible villians.</html>";
	String size = "<html>Dragonborn are taller and heavier than humans.<br> Standing well over 6 feet tall and averaging almost 250 pounds.<br> Your size is Medium.</html>";
	String speed = "Your base walking speed is 30 feet.";
	String languages = "You can speak, read and write Common and Draconic.";
	
	/**
	 * Create the panel.
	 */
	public DragonBorn() {
		
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">DragonBorn</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel(abilityScoreIncrease), "cell 1 1,alignx left,aligny bottom");
		
		// Alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right, aligny top");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left, aligny top");
		
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 0 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 1 3,alignx left, aligny top");
		
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 0 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 1 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 1 5,alignx left, aligny top");
		
		acceptDragonBorn = new JButton("Accept DragonBorn as Your Race");
		jp.add(acceptDragonBorn, "cell 0 9 2 1,alignx center,aligny center");

	}
	
	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedDragonBornButton(){return acceptDragonBorn;}

}
