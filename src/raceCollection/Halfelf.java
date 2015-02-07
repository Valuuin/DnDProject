package raceCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class HalfElf  {

	private JPanel jp;
	private JButton acceptHalfElf;
	
	// Halfelf traits
	String abilityScoreIncrease = "Your Charisma score increases by 2, and two other ability scores of your choice increase by 1.";
	String alignment = "<html>Half-elves share the chaotic bent of their elven heritage. They value both personal freedom and"
			+          "<br> creative expression, demonstrating neither love of leaders nor desire for followers."
			+          "<br> They chafe at rules, resent others' demands, and sometimes prove unreliable,"
			+          "<br> or at least unpredictable.</html>";
	String size = "Half-elves are about the same size as humans, ranging from 5 to 6 feet tall. Your size is Medium";
	String speed = "Your base walking speed is 30 feet.";
	String darkvision = "<html>Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions."
			+           "<br> You can see in dim light within 60 feet of you as if it were bright light,"
			+           "<br> and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray</html>";
	String feyAncestry = "You have advantage on saving throws against being charmed, and magic can't put you to sleep.";
	String skillVersatility = "You gain proficiency in two skills of your choice.";
	String languages = "You can speak, read, and write Common, Elvish, and one extra language of your choice.";
	
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	String[] atri = {"0","0","0","1","1","2"};
	
	/**
	 * Create the panel.
	 */
	public HalfElf() {
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[5%][20%][70%][5%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">HalfElf</font></html>"), "cell 0 0 4 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 1 1,alignx right,aligny bottom");
		jp.add(new JLabel(abilityScoreIncrease), "cell 2 1,alignx left,aligny bottom");
		
		// Alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 1 2,alignx right, aligny top");
		jp.add(new JLabel(alignment), "cell 2 2,alignx left, aligny top");
		//
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 1 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 2 3,alignx left, aligny top");
		
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 1 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 2 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 1 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 2 5,alignx left, aligny top");
		
		//DarkVision
		jp.add(new JLabel("<html><b>Darkvision:</b></html>"), "cell 1 6,alignx right, aligny top");
		jp.add(new JLabel(darkvision), "cell 2 6,alignx left, aligny top");
		
		//feyAncestry
		jp.add(new JLabel("<html><b>Fey Ancestry:</b></html>"), "cell 1 7,alignx right, aligny top");
		jp.add(new JLabel(feyAncestry), "cell 2 7,alignx left, aligny top");
		
		//Skill Versatility
		jp.add(new JLabel("<html><b>Skill Versatility:</b></html>"), "cell 1 8,alignx right, aligny top");
		jp.add(new JLabel(skillVersatility), "cell 2 8,alignx left, aligny top");
		
		acceptHalfElf = new JButton("Accept HalfElf as Your Race");
		jp.add(acceptHalfElf, "cell 0 9 4 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptHalfElf;}
	public String[] getAttributes(){return atri;}
	
}
