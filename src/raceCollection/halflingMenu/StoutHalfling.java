package raceCollection.halflingMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Halfling;

public class StoutHalfling extends Halfling {

	private JPanel jp;
	private JButton acceptRace;

	// unqiue strings for stout halfling
	String ASI = abilityScoreIncrease;
	String stoutHalfling_ASI = "Your Constitution score increases by 1.";
	String resilience = "You have advantage on saving throws against poison, and you have resistance against poison damage";
	
	
	public StoutHalfling() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Stout Halfling</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+stoutHalfling_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
												
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
				
		//Resilience
		jp.add(new JLabel("<html><b>Resilience:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(resilience), "cell 1 5,alignx left, aligny top");
						
		
		acceptRace = new JButton("Accept Stout Halfling as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
}
