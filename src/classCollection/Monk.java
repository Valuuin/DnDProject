package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Attributes;
import net.miginfocom.swing.MigLayout;

public class Monk {
	private JPanel jp;
	private JButton acceptClass;

	//Strings unique to Monks
	String hitPoints = "1d8 + your Constitution modifier per Monk level.";
	String armor = "Monks are not proficient in any armors.";
	String weapons = "Proficient in simple weapons and short swords.";
	String tools = "Choose one type of artisan's tools or one musical instrument.";
	String savingThrows = "Strength and Dexterity are the Monk's saving throws.";
	String skills = "Choose two from Acrobatics, Athletics, History, Insight, Religion, and Stealth.";
	
	ArrayList<String> skillList = new ArrayList<String>();
	ArrayList<Attributes> sThrows = new ArrayList<Attributes>(); 
	
	public Monk() {
		
		skillList.add("Acrobatics");
		skillList.add("Athletics");
		skillList.add("History");
		skillList.add("Insight");
		skillList.add("Religion");
		skillList.add("Stealth");
		
		sThrows.add(Attributes.STR);
		sThrows.add(Attributes.DEX);
		
		createJPanel();
		
		
	}

	
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Monk</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
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
		
		acceptClass = new JButton("Accept Monk as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
	public String getSkillString(){return skills;}
	public ArrayList<Attributes> getSavingThrows(){return sThrows;}
}
