package raceCollection.elfMenu;

import java.util.ArrayList;

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
	String sunlightSensitivity = "<html>You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight "
			+ 	"when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.<br>";
	String drowMagic = "<html>You know the dancing lights cantrip. When you reach 3rd level, "
			+ "you can cast the faerie fire spell once <br>"
			+ 	" per day. When you reach 5th level, you can also cast the darkness spell once per day. <br>"
			+   " Charisma is your spellcasting ability for these spells.<html>";
	String drowWeaponTraining = "You have proficiency with rapiers, shortswords, and hand crossbows.";
	
	ArrayList<String> atri = new ArrayList<String>();
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	//String[] atri = {"0","2","0","0","0","1"};
	
	public Drow() {

		atri.add("0"); //Strength
		atri.add("2"); //Dexterity
		atri.add("0"); //Constitution
		atri.add("0"); //Intelligence
		atri.add("0"); //Wisdom
		atri.add("1"); //Charisma
		createJPanel();
		
	}
	
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Drow</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+darkElf_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
				
		// alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left,aligny top");
				
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 0 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 1 3,alignx left, aligny top");
						
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 0 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 1 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 1 5,alignx left, aligny top");
		
		//Superior Dark vision
		jp.add(new JLabel("<html><b>Superior Dark Vision:</b></html>"), "cell 0 6,alignx right, aligny top");
		jp.add(new JLabel(superiorDarkvision), "cell 1 6,alignx left, aligny top");
		
		//Sunlight Sensitivity
		jp.add(new JLabel("<html><b>Sunlight Sensitivity:</b></html>"), "cell 0 7,alignx right, aligny top");
		jp.add(new JLabel(sunlightSensitivity), "cell 1 7,alignx left, aligny top");
		
		//Drow Magic
		jp.add(new JLabel("<html><b>Drow Magic:</b></html>"), "cell 0 8,alignx right, aligny top");
		jp.add(new JLabel(drowMagic), "cell 1 8,alignx left, aligny top");
		
		
		//Drow Weapon Training
		jp.add(new JLabel("<html><b>Drow Weapon Training:</b></html>"), "cell 0 9,alignx right, aligny top");
		jp.add(new JLabel(drowWeaponTraining), "cell 1 9,alignx left,aligny top");
		
		acceptRace = new JButton("Accept Drow as Your Race");
		jp.add(acceptRace, "cell 1 10,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
	public ArrayList<String> getAttributes(){return atri;}
}
