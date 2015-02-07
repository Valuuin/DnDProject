package raceCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class HalfOrc {

	private JPanel jp;
	private JButton acceptHalfOrc;
	
	// HalfOrc traits
	String abilityScoreIncrease = "Your Strength score increases by 2, and your Constitution score increases by 1."; 
	String alignment = "<html>Half-orcs inherit a tendancy toward chaos from their orc parents and are"
			+          "<br> not strongly inclined toward good. Half-orcs raised among orcs and willing"
			+          "<br> to live out their lives among them are usually evil.</html>";
	String size = "<html>Half-orcs are somewhat larger and bulkier than humans,"
			+     "<br> and they range from 5 to well over 6 feet tall. Your size is Medium.</html>";
	String speed = "Your base walking speed is 30 feet.";
	String darkvision = "<html>Thanks to your orc blood you have superior vision in dark and dim conditions."
			+           "<br> You can see in dim light within 60 feet of you as if it were bright light,"
			+           "<br> and in darkness as if it were dim light. You can't discern color in darkness,"
			+           "<br> only shades of gray</html>";
	String menacing = "You gain proficiency in the Intimidation skill.";
	String relentlessEndurance = "<html>When you are reduced to 0 hit points but not killed outright,"
			+                    "<br> you can drop to 1 hit point instead. You can't use this feature"
			+                    "<br> again until you finish a long rest.</html>";
	String savageAttacks = "<html>When you score a critical hit with a weapoin attack, you can roll one of"
			+              "<br> the weapon's damage dice one additional time and add it to the extra"
			+              "<br> damage of the critical hit.<html>";
	String languages = "<html>You can speak, read, and write Common and Orc. Orc is a harsh, grating language"
			+          "<br> with hard consonants. It has no script of its own but is written in the Dwarvish script.</html>";

	
	ArrayList<String> atri = new ArrayList<String>();
	
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	//String[] atri = {"2","0","1","0","0","0"};
	
	/**
	 * Create the panel.
	 */
	public HalfOrc() {
	
		atri.add("2"); //Strength
		atri.add("0"); //Dexterity
		atri.add("1"); //Constitution
		atri.add("0"); //Intelligence
		atri.add("0"); //Wisdom
		atri.add("0"); //Charisma
		createJPanel();
	}
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[5%][20%][70%][5%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">HalfOrc</font></html>"), "cell 0 0 4 1,alignx center,aligny center");
		
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
		
		//menacing
		jp.add(new JLabel("<html><b>Menacing:</b></html>"), "cell 1 7,alignx right, aligny top");
		jp.add(new JLabel(menacing), "cell 2 7,alignx left, aligny top");
		
		//Relentless Endurance
		jp.add(new JLabel("<html><b>Relentless</b> <br><div align=\"right\"><b>Endurance:</b></html>"), "cell 1 8,alignx right, aligny top");
		jp.add(new JLabel(relentlessEndurance), "cell 2 8,alignx left, aligny top");
		
		//savageAttacks
		jp.add(new JLabel("<html><b>Savage Attacks:</b></html>"), "cell 1 9,alignx right, aligny top");
		jp.add(new JLabel(savageAttacks), "cell 2 9,alignx left, aligny top");
		
		acceptHalfOrc = new JButton("Accept HalfOrc as Your Race");
		jp.add(acceptHalfOrc, "cell 0 10 4 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptHalfOrc;}
	public ArrayList<String> getAttributes(){return atri;}
	
}
