package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Barbarian {
	private JPanel jp;
	private JButton acceptClass;

	//unique strings for barbarians
	String hitPoints = "As a Barbarian, you gain 1d12 + your Constitution modifier in health per level.";
	String armor = "Barbarians gain proficiencies in Light armor, medium armor, and shields.";
	String weapons = "Barbarians gain proficiencies in all simple and martial weapons";
	String savingThrows = "Strength and Constitution are a Barbarian's saving throws";
	String skills = "Choose two from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival.";
	
	ArrayList<String> skillList = new ArrayList<String>();
	
	
	
	
	public Barbarian() {
		
		skillList.add("Animal Handling");
		skillList.add("Athletics");
		skillList.add("Intimidation");
		skillList.add("Nature");
		skillList.add("Perception");
		skillList.add("Survival");
		createJPanel();	
			
		}
		
		
	public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Barbarian</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
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
		
		acceptClass = new JButton("Accept Barbarian as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
}
