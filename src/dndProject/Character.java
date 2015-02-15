package dndProject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFA;

import classCollection.Barbarian;
import classCollection.Bard;
import backgroundCollection.Artisan;
import backgroundCollection.Charlatan;
import backgroundCollection.Criminal;
import backgroundCollection.Entertainer;
import backgroundCollection.FolkHero;
import backgroundCollection.GuildArtisan;
import backgroundCollection.Hermit;
import backgroundCollection.Noble;
import backgroundCollection.Outlander;
import backgroundCollection.Sage;
import backgroundCollection.Sailor;
import backgroundCollection.Soldier;
import backgroundCollection.Urchin;
import raceCollection.DragonBorn;
import raceCollection.HalfElf;
import raceCollection.HalfOrc;
import raceCollection.Human;
import raceCollection.Tiefling;
import raceCollection.dwarfMenu.HillDwarf;
import raceCollection.dwarfMenu.MountainDwarf;
import raceCollection.elfMenu.Drow;
import raceCollection.elfMenu.HighElf;
import raceCollection.elfMenu.WoodElf;
import raceCollection.gnomeMenu.ForrestGnome;
import raceCollection.gnomeMenu.RockGnome;
import raceCollection.halflingMenu.LightfootHalfling;
import raceCollection.halflingMenu.StoutHalfling;


public class Character {

	public enum Race{HUMAN, DROW, HIGH_ELF, WOOD_ELF, DRAGONBORN, TIEFLING, HALF_ELF, HALF_ORC, ROCK_GNOME, FORREST_GNOME, HILL_DWARF, MOUNTAIN_DWARF, LIGHTFOOT_HALFLING, STOUT_HALFLING}
	public enum cClass{BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZZARD}
	public enum bGround{ARTISAN, CHARLATAN, CRIMINAL, ENTERTAINER, FOLKHERO, GUILDARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN}
	public enum Proficiencies{ACROBATICS, ANIMAL_HANDELING, ARCANA, ATHETICS, DECEPTION, HISTORY, INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION, REGLIGION, SLEIGHT_OF_HAND, STEALTH, SURVIVAL}
	public enum Attributes{STR, DEX, CON, INT, WIS, CHA}
	
	private static PDDocument pdfTemplate;
	static PDAcroForm acroForm;

	Race rName;
	cClass cName;
	bGround bName;
	
	Object selectedRace;
	Object selectedClass;
	Object selectedBackground;
	
	String newRace;
	String newClass;
	String newBackground;
	
	String profBonus = "2";
	
	ArrayList<String> proficienciesSelected = new ArrayList<String>();
	ArrayList<String> attributesSelected = new ArrayList<String>();
	
	ArrayList<String> errorString = new ArrayList<String>();
	ArrayList<Proficiencies> errorProficiences= new ArrayList<Proficiencies>();
	ArrayList<Attributes> savingThrows = new ArrayList<Attributes>();
	
	String[] savingThrowsResults = new String[6];
	String[] attributesModifiers = new String[6];
	
	public Character(){
		selectedRace = null;
		selectedClass = null;
		selectedBackground = null;
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		
		// Load the pdfTemplate
	    try {
			pdfTemplate = PDDocument.load(new File("characterFourm.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
	    acroForm = docCatalog.getAcroForm();
	    acroForm.getDictionary().setItem(COSName.getPDFName("NeedAppearances"), COSBoolean.TRUE);
		
	}
	
	public Character ( Object rc, Object cs, Object bg){
		this.selectedRace = rc;
		this.selectedClass = cs;
		this.selectedBackground = bg;
	}
	
	
	/***********************************************************************************************************/
	/*                                   Setters For Character Class                                          */
	/***********************************************************************************************************/	
	public void setRace(Object r, String name, Race re){
		this.selectedRace = r;
		this.newRace = name;
		this.rName = re;
	}
	
	public void setClass(Object c, String name, cClass cC){
		this.selectedClass = c;
		this.newClass = name;
		this.cName = cC;
	}
	
	public void setBackground(Object b, String name, bGround bG){
		this.selectedBackground = b;
		this.newBackground = name;
		this.bName = bG;
	}
	
	public void setSavedProficiences(ArrayList<String> prof){
		this.proficienciesSelected = prof;
	}
	
	public void setSavedAttributes(ArrayList<String> attri){
		this.attributesSelected = attri;
	}

	/***********************************************************************************************************/
	/*                                   GITTERS For Character Class                                          */
	/***********************************************************************************************************/
	 public String getRaceName(){return newRace;}
	 public String getClassName(){return newClass;}
	 public String getBackgroundName(){return newBackground;}
	 
	 public Race get_Race(){return rName;}
	 public cClass get_Class(){return cName;}
	 public bGround get_Background(){return bName;}
	 
	/***********************************************************************************************************/
	/*                                   GITTERS From Race Classes                                             */
	/***********************************************************************************************************/
	
	/*
	 * Get the Atributes from the class file.
	 */
	public ArrayList<String> getAtributes(){
		if (selectedRace != null){
			switch(rName){
			case DRAGONBORN:         return (ArrayList<String>)((DragonBorn)        selectedRace).getAttributes();
			case HUMAN:              return (ArrayList<String>)((Human)             selectedRace).getAttributes();
			case DROW:               return (ArrayList<String>)((Drow)              selectedRace).getAttributes();
			case HIGH_ELF:           return (ArrayList<String>)((HighElf)           selectedRace).getAttributes();
			case WOOD_ELF:           return (ArrayList<String>)((WoodElf)           selectedRace).getAttributes();
			case TIEFLING:           return (ArrayList<String>)((Tiefling)          selectedRace).getAttributes();
			case HALF_ELF:           return (ArrayList<String>)((HalfElf)           selectedRace).getAttributes();
			case HALF_ORC:           return (ArrayList<String>)((HalfOrc)           selectedRace).getAttributes();
			case ROCK_GNOME:         return (ArrayList<String>)((RockGnome)         selectedRace).getAttributes();
			case FORREST_GNOME:      return (ArrayList<String>)((ForrestGnome)      selectedRace).getAttributes();
			case HILL_DWARF:         return (ArrayList<String>)((HillDwarf)         selectedRace).getAttributes();
			case MOUNTAIN_DWARF:     return (ArrayList<String>)((MountainDwarf)     selectedRace).getAttributes();
			case LIGHTFOOT_HALFLING: return (ArrayList<String>)((LightfootHalfling) selectedRace).getAttributes();
			case STOUT_HALFLING:     return (ArrayList<String>)((StoutHalfling)     selectedRace).getAttributes();
			default: return errorString;
			}
		}
		return errorString;
	}
	
	public ArrayList<Proficiencies> getBackgroundProficiencies(){
		if (selectedBackground != null){
			switch(bName){
			case ARTISAN:      return (ArrayList<Proficiencies>)((Artisan)      selectedBackground).getProficiencies();
			case CHARLATAN:    return (ArrayList<Proficiencies>)((Charlatan)    selectedBackground).getProficiencies();
			/*case CRIMINAL:   return (ArrayList<Proficiences>)((Criminal)	   selectedBackground).getProficiencies();
			case ENTERTAINER:  return (ArrayList<Proficiences>)((Entertainer)  selectedBackground).getProficiencies();
			case FOLKHERO:     return (ArrayList<Proficiences>)((FolkHero)     selectedBackground).getProficiencies();
			case GUILDARTISAN: return (ArrayList<Proficiences>)((GuildArtisan) selectedBackground).getProficiencies();
			case HERMIT:	   return (ArrayList<Proficiences>)((Hermit)       selectedBackground).getProficiencies();
			case NOBLE:		   return (ArrayList<Proficiences>)((Noble)        selectedBackground).getProficiencies();
			case OUTLANDER:	   return (ArrayList<Proficiences>)((Outlander)    selectedBackground).getProficiencies();
			case SAGE:		   return (ArrayList<Proficiences>)((Sage)         selectedBackground).getProficiencies();
			case SAILOR:	   return (ArrayList<Proficiences>)((Sailor)       selectedBackground).getProficiencies();
			case SOLDIER:      return (ArrayList<Proficiences>)((Soldier)      selectedBackground).getProficiencies();
			case URCHIN:	   return (ArrayList<Proficiences>)((Urchin)       selectedBackground).getProficiencies();
			*/default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public ArrayList<Proficiencies> getClassProficiencies(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return (ArrayList<Proficiencies>)((Barbarian) selectedClass).getProficiencies();
			case BARD:      return (ArrayList<Proficiencies>)((Bard)      selectedClass).getProficiencies();
			case CLERIC:
			case DRUID:
			case FIGHTER:
			case MONK:
			case PALADIN:
			case RANGER:
			case ROGUE:
			case SORCERER:
			case WARLOCK:
			case WIZZARD:
			default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public String getClassSkillString(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return "Barbarian: " + (String)((Barbarian) selectedClass).getSkillString();
			case BARD:      return "Bard: " +      (String)((Bard)      selectedClass).getSkillString();
			case CLERIC:
			case DRUID:
			case FIGHTER:
			case MONK:
			case PALADIN:
			case RANGER:
			case ROGUE:
			case SORCERER:
			case WARLOCK:
			case WIZZARD:
			default: return "";
			}
		}
		return "";
	}
	
	public String setSavingThrows(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: savingThrows = (ArrayList<Attributes>)((Barbarian) selectedClass).getSavingThrows(); break;
			case BARD:      
			case CLERIC:
			case DRUID:
			case FIGHTER:
			case MONK:
			case PALADIN:
			case RANGER:
			case ROGUE:
			case SORCERER:
			case WARLOCK:
			case WIZZARD:
			default: return "";
			}
		}
		return "";
	}

	public PDDocument savePDF() throws IOException, COSVisitorException{
		setModifiers();
		setSavingThrowMod();
		 
		setField("Class&Level", "newClass" + " LvL: 1");
		setField("Race",        "newRace");
		setField("Background",  "newBackground");
		setField("ProfBonus" ,  profBonus );
		
		// Attributes
		setField("STR01", attributesSelected.get(0));
		setField("STR02", attributesModifiers[0]);
		setField("DEX01", attributesSelected.get(1));
		setField("DEX02", attributesModifiers[1]);
		setField("CON01", attributesSelected.get(2));
		setField("CON02", attributesModifiers[2]);
		setField("INT01", attributesSelected.get(3));
		setField("INT02", attributesModifiers[3]);
		setField("WIS01", attributesSelected.get(4));
		setField("WIS02", attributesModifiers[4]);
		setField("CHA01", attributesSelected.get(5));
		setField("CHA02", attributesModifiers[5]);
	
		// Saving Throws
		setField("STR04",   ""  ); // Button 
		setField("STR03", savingThrowsResults[0] );
		setField("DEX04",   ""  ); // Button
		setField("DEX03", savingThrowsResults[1] );
		setField("CON04",   ""  ); // Button
		setField("CON03", savingThrowsResults[2] );
		setField("INT04",   ""  ); // Button
		setField("INT03", savingThrowsResults[3] );
		setField("WIS04",   ""  ); // Button
		setField("WIS03", savingThrowsResults[4] );
		setField("CHA04",   ""  ); // Button
		setField("CHA03", savingThrowsResults[5] );
		
		// Skills
		setField("acro02", ""); //Btn
		setField("acro01", "");
		setField("Anim02", ""); //Btn
		setField("anim01", "");
		setField("arca02", ""); //Btn
		setField("arca01", "");
		setField("athl02", ""); //Btn
		setField("Athl01", "");
		setField("dece02", ""); //Btn
		setField("dece01", "");
		setField("hist02", ""); //Btn
		setField("hist01", "");
		setField("insi02", ""); //Btn
		setField("insi01", "");
		setField("inti02", ""); //Btn
		setField("inti01", "");
		setField("inve02", ""); //Btn
		setField("inve01", "");
		setField("medi02", ""); //Btn
		setField("medi01", "");
		setField("natu02", ""); //Btn
		setField("natu01", "");
		setField("perc02", ""); //Btn
		setField("perc01", "");
		setField("perf02", ""); //Btn
		setField("perf01", "");
	    setField("pers02", ""); //Btn
	    setField("pers01", "");
	    setField("reli02", ""); //Btn
	    setField("reli01", "");
	    setField("slei02", ""); //Btn
	    setField("slei01", "");
	    setField("stea02", ""); //Btn
	    setField("stea01", "");
	    setField("surv02", ""); //Btn
	    setField("surv01", "");
		
		setField("Perception",   "");
		setField("ArmorClass01", "");
		setField("Initiative01", "");
		setField("Speed01",      "");
		setField("HP max",       "");
		setField("HD Total",     "");
		
		
		
	    // Get field names
	    @SuppressWarnings("unchecked")
		List<PDField> fieldList = acroForm.getFields();

	    // String the object array
	   
	    for (PDField sField : fieldList) {
	        System.out.print("f : "+  sField.getFullyQualifiedName());
	        System.out.println(" Type: "+ sField.getFieldType());
	    }
	    
	    // Save edited file
	    return pdfTemplate;
	    //pdfTemplate.save("s.pdf");
	    //pdfTemplate.close();
	}
	
	private static void setField(String name, String value ) throws IOException {
		PDField field = acroForm.getField( name );
		if( field != null ) {
			field.setValue(value);
		}
		else {
			System.err.println( "No field found with name:" + name );
		}
	}
	
	private static void toggelButton(String name){}

	private void setSavingThrowMod() {
		setSavingThrows();
				
		for(Attributes a : savingThrows){
			switch (a) {
			case CHA:  attributesModifiers[5]=String.valueOf(Integer.parseInt(attributesModifiers[5]) + Integer.parseInt(profBonus)); break;
			case CON:  attributesModifiers[2]=String.valueOf(Integer.parseInt(attributesModifiers[2]) + Integer.parseInt(profBonus)); break;
			case DEX:  attributesModifiers[1]=String.valueOf(Integer.parseInt(attributesModifiers[1]) + Integer.parseInt(profBonus)); break;
			case INT:  attributesModifiers[3]=String.valueOf(Integer.parseInt(attributesModifiers[3]) + Integer.parseInt(profBonus)); break;
			case STR:  attributesModifiers[0]=String.valueOf(Integer.parseInt(attributesModifiers[0]) + Integer.parseInt(profBonus)); break;
			case WIS:  attributesModifiers[4]=String.valueOf(Integer.parseInt(attributesModifiers[4]) + Integer.parseInt(profBonus)); break;
			default: break;
			}
		}
	}


	private void setModifiers(){
		int index = 0;
		for( String s : attributesSelected){
			int val = Integer.parseInt(s);
			if(val == 1)      {attributesModifiers[index] =  "-5";}
			else if(val <= 3) {attributesModifiers[index] =  "-4";}
			else if(val <= 5) {attributesModifiers[index] =  "-3";}
			else if(val <= 6) {attributesModifiers[index] =  "-2";}
			else if(val <= 9) {attributesModifiers[index] =  "-1";}
			else if(val <= 11){attributesModifiers[index] =  "0"; }
			else if(val <= 13){attributesModifiers[index] =  "1"; }
			else if(val <= 15){attributesModifiers[index] =  "2"; }
			else if(val <= 17){attributesModifiers[index] =  "3"; }
			else if(val <= 19){attributesModifiers[index] =  "4"; }
			else if(val <= 21){attributesModifiers[index] =  "5"; }
			else if(val <= 23){attributesModifiers[index] =  "6"; }
			else if(val <= 25){attributesModifiers[index] =  "7"; }
			else if(val <= 27){attributesModifiers[index] =  "8"; }
			else if(val <= 29){attributesModifiers[index] =  "9"; }
			else if(val <= 30){attributesModifiers[index] =  "10";}
			else               attributesModifiers[index] =  "";
			
			index++;
		}
	}
	
}
