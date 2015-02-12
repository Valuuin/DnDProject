package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiences;
import net.miginfocom.swing.MigLayout;

public class Noble {

	private JPanel jp;
	private JButton acceptBackground;

	//String unique to nobles
	//String[] skillProf = {"History", "Persuasion"};
	ArrayList<Proficiences> skillProf = new ArrayList<Proficiences>();
	String toolProf = "One type of gaming set";
	String languages = "One of your choice";
	String equipment = "A set of fine clothes, a signet ring, a scroll of pedigree, and a purse containing 25 GP.";
	
	
	public Noble() {
		
		skillProf.add(Proficiences.HISTORY);
		skillProf.add(Proficiences.PERSUASION);

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Noble</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("History, Persuasion"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(toolProf), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 4,alignx right,aligny bottom");
		jp.add(new JLabel(languages), "cell 1 4,alignx left,aligny bottom");
		
		
		acceptBackground = new JButton("Accept Noble as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiences> getProficiencies(){return skillProf;}
}

