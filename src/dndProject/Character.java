package dndProject;

public class Character {

	Object selectedRace;
	Object selectedClass;
	Object selectedBackground;
	
	public Character(){
		selectedRace = null;
		selectedClass = null;
		selectedBackground = null;
	}
	
	public Character ( Object rc, Object cs, Object bg){
		selectedRace = rc;
		selectedClass = cs;
		selectedBackground = bg;
	}
	
	public void setRace(Object r){
		selectedRace = r;
	}
	
	public void setClass(Object c){
		selectedClass = c;
	}
	
	public void setBackground(Object b){
		selectedBackground = b;
	}
	
}
