package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiencies;
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
	
	ArrayList<Proficiencies> skillList = new ArrayList<Proficiencies>();
	
	
	public Bard() {
		
		skillList.add(Proficiencies.ACROBATICS);
		skillList.add(Proficiencies.SLEIGHT_OF_HAND);
		skillList.add(Proficiencies.STEALTH);
		skillList.add(Proficiencies.ATHETICS);
		skillList.add(Proficiencies.ARCANA);
		skillList.add(Proficiencies.HISTORY);
		skillList.add(Proficiencies.INVESTIGATION);
		skillList.add(Proficiencies.NATURE);
		skillList.add(Proficiencies.REGLIGION);
		skillList.add(Proficiencies.ANIMAL_HANDELING);
		skillList.add(Proficiencies.INSIGHT);
		skillList.add(Proficiencies.MEDICINE);
		skillList.add(Proficiencies.PERCEPTION);
		skillList.add(Proficiencies.SURVIVAL);
		skillList.add(Proficiencies.DECEPTION);
		skillList.add(Proficiencies.INTIMIDATION);
		skillList.add(Proficiencies.PERFORMANCE);
		skillList.add(Proficiencies.PERSUASION);
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
	public String getSkillString(){return skills;}
	public ArrayList<Proficiencies> getProficiencies(){return skillList;}
}

