package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiences;
import net.miginfocom.swing.MigLayout;

public class Sailor {


	private JPanel jp;
	private JButton acceptBackground;

	//String unique to Sailor
	//String[] skillProf = {"Athletics", "Perception"};
	ArrayList<Proficiences> skillProf = new ArrayList<Proficiences>();
	String[] toolProf = {"Navigator's tools", "Vehicles (water)"};
	String languages = "no new languages";
	String equipment = "50 feet of silk rope, a lucky charm such as a rabbit foot or small stone with a hole in the center, a set of common clohes, and a belt pouch containing 10 GP";
	
	
	public Sailor() {
		
		skillProf.add(Proficiences.ATHETICS);
		skillProf.add(Proficiences.PERCEPTION);

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Sailor</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Athletics, Perception"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(toolProf[0] +", "+toolProf[1]), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 4,alignx right,aligny bottom");
		jp.add(new JLabel(languages), "cell 1 4,alignx left,aligny bottom");
		
		
		acceptBackground = new JButton("Accept Sailor as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiences> getProficiencies(){return skillProf;}
}


