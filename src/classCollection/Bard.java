package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Bard {
	private JPanel jp;
	private JButton acceptClass;

	//unique strings for bards
	String hitPoints = "As a Bard, you gain 1d8 + your Constitution modifier in health per level.";
	String armor = "Bards gain proficiencies in Light armor.";
	String weapons = "Bars gain proficiencies in all simple weapons, hand crossbows, longswords, rapiers, and shortswords.";
	String savingThrows = "Dexterity and Charisma are the Bard's saving throws.";
	String skills = "Choose any three skills and become proficient in them.";
	String tools = "Three musical instruments of your choice";
	
	ArrayList<String> skillList = new ArrayList<String>();
	
	
	public Bard() {
		
		skillList.add("Acrobatics");
		skillList.add("Sleight of Hand");
		skillList.add("Stealth");
		skillList.add("Athletics");
		skillList.add("Arcana");
		skillList.add("History");
		skillList.add("Investigation");
		skillList.add("Nature");
		skillList.add("Religion");
		skillList.add("Animal Handling");
		skillList.add("Insight");
		skillList.add("Medicine");
		skillList.add("Perception");
		skillList.add("Survival");
		skillList.add("Deception");
		skillList.add("Intimidation");
		skillList.add("Performance");
		skillList.add("Persuasion");
		createJPanel();
	}
	
		
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Bard</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
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
		
		acceptClass = new JButton("Accept Bard as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
}

