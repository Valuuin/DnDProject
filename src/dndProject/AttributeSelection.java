package dndProject;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class AttributeSelection {

	private JPanel aS;
	
	public AttributeSelection(){
	
		aS = new JPanel();
		aS.setSize(620, 480);
		aS.setLayout(new MigLayout("", "[2%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][2%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		
		JLabel title = new JLabel("Attribute Selection");
		aS.add(title, "cell 1 0 12 1,alignx center,aligny center");
		
		JLabel strength = new JLabel("Strength:");
		aS.add(strength, "cell 1 4,alignx center,aligny center");
		JTextField strengthValue = new JTextField();
		aS.add(strengthValue,"cell 2 4,growx" );
		
		JLabel dexterity = new JLabel("Dexterity:");
		aS.add(dexterity, "cell 3 4,alignx center,aligny center");
		JTextField dexterityValue = new JTextField();
		aS.add(dexterityValue,"cell 4 4,growx" );
		
		JLabel constitution = new JLabel("Constitution:");
		aS.add(constitution, "cell 5 4,alignx center,aligny center");
		JTextField constitutionValue = new JTextField();
		aS.add(constitutionValue,"cell 6 4,growx" );
		
		JLabel intelligence = new JLabel("Intelligence:");
		aS.add(intelligence, "cell 7 4,alignx center,aligny center");
		JTextField intelligenceValue = new JTextField();
		aS.add(intelligenceValue,"cell 8 4,growx" );

		JLabel wisdom = new JLabel("Wisdom:");
		aS.add(wisdom, "cell 9 4,alignx center,aligny center");
		JTextField wisdomValue = new JTextField();
		aS.add(wisdomValue,"cell 10 4,growx" );
		
		JLabel charisma = new JLabel("Charisma:");
		aS.add(charisma, "cell 11 4,alignx center,aligny center");
		JTextField charismaValue = new JTextField();
		aS.add(charismaValue,"cell 12 4,growx" );
	}
	
	public JPanel getAttributeSelectionPanel(){return aS;}
}
