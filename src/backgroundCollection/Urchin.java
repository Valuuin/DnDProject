package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiencies;
import net.miginfocom.swing.MigLayout;

public class Urchin {
	private JPanel jp;
	private JButton acceptBackground;
	
	//Strings unique to Urchin
	//String[] skillProf = {"Sleight of Hand", "Stealth"};
	ArrayList<Proficiencies> skillProf = new ArrayList<Proficiencies>();
	//String[] toolProf = {"Disguise kit", "Thieves' tools"};
	ArrayList<String> toolProf = new ArrayList<String>();
	String languages = "No new languages";
	String equipment = "A small knife, a map of the city you grew up in, a pet mouse, a token to remember your parents by, a set of common clothes, and a belt pouch containing 10 Gp.";
	

	public Urchin() {

		skillProf.add(Proficiencies.SLEIGHT_OF_HAND);
		skillProf.add(Proficiencies.STEALTH);
		toolProf.add("Disguise kit");
		toolProf.add("Thieves' tools");
		
		createJPanel();
	}
		
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Urchin</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Sleight of Hand, Stealth"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel("Disguise kit, Thieves' tools"), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 4,alignx right,aligny bottom");
		jp.add(new JLabel(languages), "cell 1 4,alignx left,aligny bottom");
		
		
		acceptBackground = new JButton("Accept Urchin as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiencies> getProficiencies(){return skillProf;}
	public ArrayList<String> getTools(){return toolProf;}
}

