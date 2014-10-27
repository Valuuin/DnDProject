package dndProject;

import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import raceCollection.Human;

public class RaceMenu {

	private String[] raceNames = { "Human", "Elf" };
	private String[] elfNames = { "Dark Elf", "High Elf" };
	private JList<String[]> list, elfList; 
	private JSplitPane raceMenu, elfMenu;
	private Human hm;
	
	private ListSelectionListener raceListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateRaceRightPane(list.getSelectedIndex());
		}
	};
	
	private ListSelectionListener elfListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateSubElfRightPane(list.getSelectedIndex());
		}
	};

	/**
	 * Create the panel.
	 */
	public RaceMenu() {
		
		hm = new Human();

		raceMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		raceMenu.setOneTouchExpandable(true);
		raceMenu.setDividerLocation(100);
		
		list = new JList(raceNames);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(raceListener);
		
		JScrollPane raceList = new JScrollPane(list);
		raceMenu.setLeftComponent(raceList);
		updateRaceRightPane(0);
		
	}
	
	public JSplitPane getRaceMenuSplitPane(){return raceMenu;}
	
	public void updateRaceRightPane(int index){
		switch(index){
		case 0: // human
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(hm.getJPanel());
			
			break;
		case 1: // elf
			raceMenu.setDividerLocation(100);
			elfMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			elfMenu.setDividerLocation(100);
			raceMenu.setRightComponent(elfMenu);
			
			elfList = new JList(elfNames);
			elfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			elfList.setSelectedIndex(0);
			elfList.addListSelectionListener(elfListener);
			
			JScrollPane elf_List = new JScrollPane(elfList);
			elfMenu.setLeftComponent(elf_List);
			updateSubElfRightPane(0);
			
			break;
		default: break;
		}
	}
		
	public void updateSubElfRightPane(int index){
		switch(index){
		case 0:
			// Content Filler Needs to be Relpaced
			elfMenu.setDividerLocation(100);
			Label darkElfTitle = new Label("Dark Elf");
			JPanel jpDarkElf = new JPanel();
			jpDarkElf.setLayout(new GridLayout());
			jpDarkElf.add(darkElfTitle);
			elfMenu.setRightComponent(jpDarkElf);
			break;
		case 1:
			// Content Filler Needs to be Relpaced
			elfMenu.setDividerLocation(100);
			Label highElfTitle = new Label("High Elf");
			JPanel jpHighElf = new JPanel();
			jpHighElf.setLayout(new GridLayout());
			jpHighElf.add(highElfTitle);
			elfMenu.setRightComponent(jpHighElf);
			break;
		default: break;
		}
	}
	
	public Human getHuman(){return hm;} 
}
