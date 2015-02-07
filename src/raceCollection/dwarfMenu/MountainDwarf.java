package raceCollection.dwarfMenu;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Dwarf;

public class MountainDwarf extends Dwarf {

	private JPanel jp;
	private JButton acceptRace;

	// Create the Strings unique to HillDwarf
	String ASI = abilityScoreIncrease;
	String mountainDwarf_ASI = "Your Strength score increases by 2.";
	String dwarvenArmorTraining = "You have proficiency with light and medium armor";
	
	ArrayList<String> atri = new ArrayList<String>();
	
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	//String[] atri = {"2","0","2","0","0","0"};
	
	public MountainDwarf() {

		atri.add("2"); //Strength
		atri.add("0"); //Dexterity
		atri.add("2"); //Constitution
		atri.add("0"); //Intelligence
		atri.add("0"); //Wisdom
		atri.add("0"); //Charisma
		createJPanel();
	}
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Mountain Dwarf</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+mountainDwarf_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
				
		// alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left,aligny bottom");
				
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 0 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 1 3,alignx left, aligny top");
						
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 0 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 1 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 1 5,alignx left, aligny top");
						
		//dwarven armor training
		jp.add(new JLabel("<html><b>Dwarven Armor Training:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(dwarvenArmorTraining), "cell 1 5,alignx left, aligny top");
		
		
		acceptRace = new JButton("Accept MountainDwarf as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
	public ArrayList<String> getAttributes(){return atri;}
}
