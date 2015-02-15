package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Attributes;
import net.miginfocom.swing.MigLayout;

public class Rogue {

	private JPanel jp;
	private JButton acceptClass;

	
	//Strings unique to Rogues
	String hitPoints = "1d8 + Constitution modifier per Rogue level.";
	String armor = "Proficient with light armors.";
	String weapons = "Proficient in all simple weapons, hand crossbows, longswords, rapiers, and shortswords.";
	String tools = "Proficient with Thieves' tools.";
	String savingThrows = "Dexterity and Intelligence are the Rogue's saving throws.";
	String skills = "Choose four from Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation, Perception, Performance, Persuasion, Sleight of Hand, and Stealth.";
	
	ArrayList<String> skillList = new ArrayList<String>();
	ArrayList<Attributes> sThrows = new ArrayList<Attributes>(); 
	
	public Rogue() {
		
		skillList.add("Acrobatics");
		skillList.add("Athletics");
		skillList.add("Deception");
		skillList.add("Insight");
		skillList.add("Intimidation");
		skillList.add("Perception");
		skillList.add("Performance");
		skillList.add("Persuasion");
		skillList.add("Sleight of Hand");
		skillList.add("Stealth");
		
		sThrows.add(Attributes.DEX);
		sThrows.add(Attributes.INT);
		
		createJPanel();
		
	}
	
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Rogue</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		// Hitpoints
		jp.add(new JLabel("<html><b>Hit Points:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel(hitPoints), "cell 1 1,alignx left,aligny bottom");
				
		// Armor
		jp.add(new JLabel("<html><b>Armor:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(armor), "cell 1 2,alignx left,aligny bottom");
				
		// Weapons
		jp.add(new JLabel("<html><b>Weapons:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(weapons), "cell 1 3,alignx left,aligny bottom");
				
		// Saving Throws
		jp.add(new JLabel("<html><b>Saving Throws:</b></html>"), "cell 0 4,alignx right,aligny bottom");
		jp.add(new JLabel(savingThrows), "cell 1 4,alignx left,aligny bottom");
				
		// Skills
		jp.add(new JLabel("<html><b>Skills:</b></html>"), "cell 0 5,alignx right,aligny bottom");
		jp.add(new JLabel(skills), "cell 1 5,alignx left,aligny bottom");
		
		// Tools
		jp.add(new JLabel("<html><b>Tools:</b></html>"), "cell 0 6,alignx right,aligny bottom");
		jp.add(new JLabel(tools), "cell 1 6,alignx left,aligny bottom");
		
		acceptClass = new JButton("Accept Rogue as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
	public ArrayList<Attributes> getSavingThrows(){return sThrows;}
}

