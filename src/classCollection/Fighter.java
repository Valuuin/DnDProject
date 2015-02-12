package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Fighter {

	private JPanel jp;
	private JButton acceptClass;

	//Strings unique to Fighter
	String hitPoints = "1d10 + your constitution modifier per Fighter level";
	String armor = "Proficient in all armor and shields.";
	String weapons = "Proficient in simple martial weapons.";
	String savingThrows = "Strength and Constitution are the Fighter's saving throws";
	String skills = "Choose two skills from Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival.";
	
	ArrayList<String> skillList = new ArrayList<String>();
	
	
	
	
	public Fighter() {
		
		skillList.add("Acrobatics");
		skillList.add("Animal Handling");
		skillList.add("Athletics");
		skillList.add("History");
		skillList.add("Insight");
		skillList.add("Intimidation");
		skillList.add("Perception");
		skillList.add("Survival");
		createJPanel();
		
		
	}
		
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Fighter</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
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
		
		acceptClass = new JButton("Accept Fighter as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
	public String getSkillString(){return skills;}
}
