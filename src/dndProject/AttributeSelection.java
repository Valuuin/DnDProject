package dndProject;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;

public class AttributeSelection implements FocusListener {

	private JPanel aS;
	private JButton btnBack;
	private NumberFormat amountDisplayed = NumberFormat.getIntegerInstance();
	Character c;
	
	JLabel strBonus = new JLabel();
	JLabel dexBonus = new JLabel();
	JLabel conBonus = new JLabel();
	JLabel intBonus = new JLabel();
	JLabel wizBonus = new JLabel();
	JLabel chrBonus = new JLabel();
	JLabel raceChoiseResults = new JLabel();
	
	JFormattedTextField strengthValue, dexterityValue, constitutionValue, intelligenceValue, wisdomValue, charismaValue;
	JTextField totalStrengthValue, totalDexterityValue, totalConstitutionValue, totalIntelligenceValue, totalWisdomValue, totalCharismaValue;
	private JButton btnSave;
	
	public AttributeSelection(){
		createJPanel();
	}
	
	private void createJPanel(){
		
		aS = new JPanel();
		aS.setSize(620, 480);
		aS.setLayout(new MigLayout("", "[2%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][8%][2%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		
		JLabel title = new JLabel("Attribute Selection");
		aS.add(title, "cell 1 0 12 1,alignx center,aligny center");
		
		aS.add(raceChoiseResults, "cell 1 2 12 1,alignx center,aligny center");
		
		aS.add(strBonus, "cell 2 3,alignx center,aligny center");
		aS.add(dexBonus, "cell 4 3,alignx center,aligny center");
		aS.add(conBonus, "cell 6 3,alignx center,aligny center");
		aS.add(intBonus, "cell 8 3,alignx center,aligny center");
		aS.add(wizBonus, "cell 10 3,alignx center,aligny center");
		aS.add(chrBonus, "cell 12 3,alignx center,aligny center");
		
		JLabel strength = new JLabel("Strength:");
		aS.add(strength, "cell 1 4,alignx center,aligny center");
		strengthValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		strengthValue.addFocusListener(this);
		aS.add(strengthValue,"cell 2 4,growx" );
		strength.setToolTipText("<html> Measures: Natural athleticism,  bodily power<br> Important for:  Barbarian, Fighter,  Paladin</html>");
		
		JLabel dexterity = new JLabel("Dexterity:");
		aS.add(dexterity, "cell 3 4,alignx center,aligny center");
		dexterityValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		dexterityValue.addFocusListener(this);
		aS.add(dexterityValue,"cell 4 4,growx" );
		dexterity.setToolTipText("<html>Measures: Physical agility, reflexes, balance, poise<br>Important for: Monk, Ranger, Rogue</html>");
		
		JLabel constitution = new JLabel("Constitution:");
		aS.add(constitution, "cell 5 4,alignx center,aligny center");
		constitutionValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		constitutionValue.addFocusListener(this);
		aS.add(constitutionValue,"cell 6 4,growx" );
		constitution.setToolTipText("<html>Measures: Health, stamina, vital force<br>Important for: Everyone</html>");
		
		JLabel intelligence = new JLabel("Intelligence:");
		aS.add(intelligence, "cell 7 4,alignx center,aligny center");
		intelligenceValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		intelligenceValue.addFocusListener(this);
		aS.add(intelligenceValue,"cell 8 4,growx" );
		intelligence.setToolTipText("<html>Measures: Mental acuity, information recall, analytical skill<br>Important for: Wizard</html>");
		
		JLabel wisdom = new JLabel("Wisdom:");
		aS.add(wisdom, "cell 9 4,alignx center,aligny center");
		wisdomValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		wisdomValue.addFocusListener(this);
		aS.add(wisdomValue,"cell 10 4,growx" );
		wisdom.setToolTipText("<html>Measures: Awareness, intuition, insight<br>Important for: Cleric, Druid </html>");
		
		JLabel charisma = new JLabel("Charisma:");
		aS.add(charisma, "cell 11 4,alignx center,aligny center");
		charismaValue = new JFormattedTextField( new DefaultFormatterFactory(new NumberFormatter(amountDisplayed)));
		charismaValue.addFocusListener(this);
		aS.add(charismaValue,"cell 12 4,growx" );
		charisma.setToolTipText("<html>Measures: Confidence, eloquence, leadership<br>Important for: Bard,  sorcerer, warlock</html>");
		
		JLabel totalStrength = new JLabel("<html>Total<br>Strength:</html>");
		aS.add(totalStrength, "cell 1 5,alignx center,aligny center");
		totalStrengthValue = new JTextField();
		totalStrengthValue.setEditable(false);
		aS.add(totalStrengthValue,"cell 2 5,growx" );
		
		JLabel totalDexterity = new JLabel("<html>Total<br>Dexterity:</html>");
		aS.add(totalDexterity, "cell 3 5,alignx center,aligny center");
		totalDexterityValue = new JTextField();
		totalDexterityValue.setEditable(false);
		aS.add(totalDexterityValue,"cell 4 5,growx" );
		
		JLabel totalConstitution = new JLabel("<html>Total<br>Constitution:</html>");
		aS.add(totalConstitution, "cell 5 5,alignx center,aligny center");
		totalConstitutionValue = new JTextField();
		totalConstitutionValue.setEditable(false);
		aS.add(totalConstitutionValue,"cell 6 5,growx" );
		
		JLabel totalIntelligence = new JLabel("<html>Total<br>Intelligence:</html>");
		aS.add(totalIntelligence, "cell 7 5,alignx center,aligny center");
		totalIntelligenceValue = new JTextField();
		totalIntelligenceValue.setEditable(false);
		aS.add(totalIntelligenceValue,"cell 8 5,growx" );
		
		JLabel totalWisdom = new JLabel("<html>Total<br>Wisdom:</html>");
		aS.add(totalWisdom, "cell 9 5,alignx center,aligny center");
	    totalWisdomValue = new JTextField();
	    totalWisdomValue.setEditable(false);
		aS.add(totalWisdomValue,"cell 10 5,growx" );
		
		JLabel totalCharisma = new JLabel("<html>Total<br>Charisma:</html>");
		aS.add(totalCharisma, "cell 11 5,alignx center,aligny center");
		totalCharismaValue = new JTextField();
		totalCharismaValue.setEditable(false);
		aS.add(totalCharismaValue,"cell 12 5,growx" );
		
		btnBack = new JButton("Back");
		aS.add(btnBack, "cell 5 8,alignx center,aligny center");
		
		btnSave = new JButton("Save");
		aS.add(btnSave, "cell 7 8,alignx center,aligny center");
		
	}
	public JButton getAttributeSelectionBack(){return btnBack;}
	public JButton getAttributeSelectionSave(){return btnSave;} 
	
	public void updateTextFields(Character c){
		
		raceChoiseResults.setText("As a "+c.getRaceName()+" you Recieve These Atribute bonuses:");
		this.c = c;
		strBonus.setText("Str:+"+c.getAtributes().get(0));
		dexBonus.setText("Dex:+"+c.getAtributes().get(1));
		conBonus.setText("Con:+"+c.getAtributes().get(2));
		intBonus.setText("Int:+"+c.getAtributes().get(3));
		wizBonus.setText("Wiz:+"+c.getAtributes().get(4));
		chrBonus.setText("Chr:+"+c.getAtributes().get(5));
	
	}
	
	public JPanel getAttributeSelectionPanel(){return aS;}
	
	public ArrayList<String> getAttributeResults(){
		ArrayList<String> results = new ArrayList<String>();
		results.add(totalStrengthValue.getText());
		results.add(totalDexterityValue.getText());
		results.add(totalConstitutionValue.getText());
		results.add(totalIntelligenceValue.getText());
		results.add(totalWisdomValue.getText());
		results.add(totalCharismaValue.getText());
		return results;
	}
	
	public void resetAttributes(){
		strengthValue.setText("");
		totalStrengthValue.setText("");
	
		dexterityValue.setText("");
		totalDexterityValue.setText("");
	
		constitutionValue.setText("");
		totalConstitutionValue.setText("");
		
		intelligenceValue.setText("");
		totalIntelligenceValue.setText("");
		
		wisdomValue.setText("");
		totalWisdomValue.setText("");
		
		charismaValue.setText("");
		totalCharismaValue.setText("");
	}
	

	public void focusGained(FocusEvent e) {
		
	}

	public void focusLost(FocusEvent e) {
		Object source = e.getSource();
		if(source == strengthValue){validatingValue(strengthValue,totalStrengthValue,0);}
		else if(source == dexterityValue){validatingValue(dexterityValue,totalDexterityValue,1);}
		else if(source == constitutionValue){validatingValue(constitutionValue,totalConstitutionValue,2);}
		else if(source == intelligenceValue){validatingValue(intelligenceValue,totalIntelligenceValue,3);}
		else if(source == wisdomValue){validatingValue(wisdomValue,totalWisdomValue,4);}
		else if(source == charismaValue){validatingValue(charismaValue,totalCharismaValue,5);}
	}
	
	private void validatingValue(JFormattedTextField testedValue, JTextField savedValue, int index ){
		try{
			int tempValue = Integer.parseInt(testedValue.getText());
			if (tempValue > 20){
				testedValue.setText("");
				JOptionPane.showMessageDialog(testedValue, "The value cannot be larger than 20");
			}
			else{
				int tempFinal  = tempValue + Integer.parseInt(c.getAtributes().get(index));
				if (tempFinal > 20){
					testedValue.setText("");
					JOptionPane.showMessageDialog(testedValue, "Calculated Value was larger than 20 when bonus was applied");
				}
				else{
					savedValue.setText(String.valueOf(tempFinal));
				}
			}
		}catch(Exception e){
			
		}
	}
}
