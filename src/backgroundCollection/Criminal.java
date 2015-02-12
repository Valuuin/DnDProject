package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiences;
import net.miginfocom.swing.MigLayout;

public class Criminal {
	private JPanel jp;
	private JButton acceptBackground;

	//Strings unique to Criminal
	//String[] skillProf = {"Deception", "Stealth"};
	ArrayList<Proficiences> skillProf = new ArrayList<Proficiences>();
	String[] toolProf = {"One type of gaming set", "Thieves' tools"};
	String equipment = "A crowbar, a set of dark common clothes including a hood, and a belt pouch containing 15 GP.";

	public Criminal() {
		
		
		skillProf.add(Proficiences.DECEPTION);
		skillProf.add(Proficiences.STEALTH);

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Criminal</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Deception, Stealth"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(toolProf[0] +", "+toolProf[1]), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		
		acceptBackground = new JButton("Accept Criminal as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiences> getProficiencies(){return skillProf;}
}

