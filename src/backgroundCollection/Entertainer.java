package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiencies;
import net.miginfocom.swing.MigLayout;

public class Entertainer {
	private JPanel jp;
	private JButton acceptBackground;

	//String unique to Entertainer
	//String[] skillProf = {"Acrobatics", "Performance"};
	ArrayList<Proficiencies> skillProf = new ArrayList<Proficiencies>();
	//String[] toolProf = {"Disguise kit", "one type of musical instrument"};
	ArrayList<String> toolProf = new ArrayList<String>();
	String equipment = "A musical instrument, the favor of an admirer, a costume, and a belt pouch containing 15 GP.";
	
	
	public Entertainer() {

		skillProf.add(Proficiencies.ACROBATICS);
		skillProf.add(Proficiencies.PERFORMANCE);
		toolProf.add("Disguise kit");
		toolProf.add("a musical instrument");
		
		createJPanel();
	}
		
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Entertainer</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Acrobatics, Performance"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel("Disguise kit, a musical instrument"), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		acceptBackground = new JButton("Accept Entertainer as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiencies> getProficiencies(){return skillProf;}
	public ArrayList<String> getTools(){return toolProf;}
}

