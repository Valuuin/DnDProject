package raceCollection.elfMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Elf;

public class Drow extends Elf{

	private JPanel jp;
	private JButton acceptRace;

	// strings unique to Drow
	String ASI = abilityScoreIncrease;
	String darkElf_ASI = "Your Charisma score increases by 1.";
	String superiorDarkvision = "Your darkvision has a radius of 120 feet.";
	String sunlightSensitivity = "You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.";
	String drowMagic = "You know the dancing lights cantrip. When you reach 3rd level, you can cast the faerie fire spell once per day. When you reach 5th level, you can also cast the darkness spell once per day. Charisma is your spellcasting ability for these spells.";
	String drowWeaponTraining = "You have proficiency with rapiers, shortswords, and hand crossbows.";
	
	
	public Drow() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Drow</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		acceptRace = new JButton("Accept Drow as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
}
