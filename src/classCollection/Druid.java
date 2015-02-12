package classCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Druid {
	
	private JPanel jp;
	private JButton acceptClass;

	//Strings unique to Druid
	String hitPoints = "1d8 + your Constitution modier per Druid level";
	String armor = "Proficient in light armor, medium armor, shields (druids will not wear armor or use shields made of metal)";
	String weapons = "Proficient in clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, and spears.";
	String savingThrows = "Intelligence and Wisdom are a Druid's saving throws";
	String tools = "Druids are proficient with Herbalism kits";
	String skills = "Choose two from Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion and Survival.";
	
	ArrayList<String> skillList = new ArrayList<String>();
	
	public Druid() {
		skillList.add("Arcana");
		skillList.add("Animal Handling");
		skillList.add("Insight");
		skillList.add("Medicine");
		skillList.add("Nature");
		skillList.add("Nature");
		skillList.add("Perception");
		skillList.add("Religion");
		skillList.add("Survival");
		createJPanel();
		

	}
	public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Druid</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
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
				
		
		
		acceptClass = new JButton("Accept Druid as Your Class");
		jp.add(acceptClass, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptClass;}
	public ArrayList<String> getSkillList(){return skillList;}
	public String getSkillString(){return skills;}
}