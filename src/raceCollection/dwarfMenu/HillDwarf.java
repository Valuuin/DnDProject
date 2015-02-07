package raceCollection.dwarfMenu;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Dwarf;

public class HillDwarf extends Dwarf {
	// Create 2 global variables one JPanel one JButton
	private JPanel jp;
	private JButton acceptHillDwarf;
	
	// Create the Strings unique to HillDwarf
	String ASI = abilityScoreIncrease;
	String hillDwarf_ASI = "Your Wisdom score increases by 1.";
	String dwarvenToughness = "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.";

	ArrayList<String> atri = new ArrayList<String>();
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	//String[] atri = {"0","0","2","0","1","0"};
	
	/**
	 * Create the panel.
	 */
	public HillDwarf() {
		
		atri.add("0"); //Strength
		atri.add("0"); //Dexterity
		atri.add("2"); //Constitution
		atri.add("0"); //Intelligence
		atri.add("1"); //Wisdom
		atri.add("0"); //Charisma
		createJPanel();
		
	}
	public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Hill Dwarf</font></html>"), "cell 0 0 2 1,alignx center,aligny center");

		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+hillDwarf_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
		
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
		
		//Dwarven Toughness
		jp.add(new JLabel("<html><b>Dwarven Toughness:</b></html>"), "cell 0 6,alignx right, aligny top");
		jp.add(new JLabel(dwarvenToughness), "cell 1 6,alignx left, aligny top");
		
		
		acceptHillDwarf = new JButton("Accept Hill Dwarf as Your Race");
		jp.add(acceptHillDwarf, "cell 0 9 2 1,alignx center,aligny center");
	}

	// Create one method to return the JPanel created up top
	public JPanel getJPanel(){return jp;}
	// Create one method to return the JButton created up top
	public JButton getAcceptedRace(){return acceptHillDwarf;}
	public ArrayList<String> getAttributes(){return atri;}
}
