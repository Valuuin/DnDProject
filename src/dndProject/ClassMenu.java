package dndProject;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classCollection.Barbarian;
import classCollection.Bard;
import classCollection.Cleric;
import classCollection.Druid;
import classCollection.Fighter;
import classCollection.Monk;
import classCollection.Paladin;
import classCollection.Ranger;
import classCollection.Rogue;
import classCollection.Sorcerer;
import classCollection.Warlock;
import classCollection.Wizzard;

public class ClassMenu {
	
	private String[] classNames = {  "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock" , "Wizard"};
	
	private JList<String[]> classList;
	private JSplitPane classMenu;
	
	private Barbarian bB;
	private Bard b;
	private Cleric c;
	private Druid d;
	private Fighter f;
	private Monk m;
	private Paladin p;
	private Ranger rA;
	private Rogue rO;
	private Sorcerer sO;
	private Warlock wA;
	private Wizzard wI;
	
	private ListSelectionListener classListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			JList<?> list = (JList<?>) e.getSource();
			updateClassRightPane(list.getSelectedIndex());
		}
	};
	
	public ClassMenu(){
		
		bB = new Barbarian();
		b = new Bard();
		c = new Cleric();
		d = new Druid();
		f = new Fighter();
		m = new Monk();
		p = new Paladin();
		rA = new Ranger();
		rO = new Rogue();
		sO = new Sorcerer();
		wA = new Warlock();
		wI = new Wizzard();
		
		classMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		classMenu.setOneTouchExpandable(true);
		classMenu.setDividerLocation(100);
		
		classList = new JList(classNames);
		classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		classList.setSelectedIndex(0);
		classList.addListSelectionListener(classListener);
		
		JScrollPane cList = new JScrollPane(classList);
		classMenu.setLeftComponent(cList);
		updateClassRightPane(0);
	}
	
	public JSplitPane getClassMenuSplitPane(){return classMenu;}
	
	public void updateClassRightPane(int index){
		switch(index){
		case 0:// Barbarian
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(bB.getJPanel());
			break;
		case 1:// Bard
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(b.getJPanel());
			break;
		case 2:// Cleric
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(c.getJPanel());
			break;
		case 3:// Driud
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(d.getJPanel());
			break;
		case 4:// Fighter
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(f.getJPanel());
			break;
		case 5:// Monk
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(m.getJPanel());
			break;
		case 6:// Paladin
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(p.getJPanel());
			break;
		case 7:// Ranger
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(rA.getJPanel());
			break;
		case 8:// Rogue
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(rO.getJPanel());
			break;
		case 9:// Sorcerer
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(sO.getJPanel());
			break;
		case 10:// Warlock
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(wA.getJPanel());
			break;
		case 11:// Wizard
			classMenu.setDividerLocation(100);
			classMenu.setRightComponent(wI.getJPanel());
			break;
		default: break;
		}
	}
	
	public Barbarian getBarbarian(){return bB;}
	public Bard      getBard(){return b;}
	public Cleric    getCleric(){return c;}
	public Druid     getDruid(){return d;}
	public Fighter   getFighter(){return f;}
	public Monk      getMonk(){return m;}
	public Paladin   getPaladin(){return p;}
	public Ranger    getRanger(){return rA;}
	public Rogue     getRogue(){return rO;}
	public Sorcerer  getSorcerer(){return sO;}
	public Warlock   getWarlock(){return wA;}
	public Wizzard   getWizzard(){return wI;}
	
}
