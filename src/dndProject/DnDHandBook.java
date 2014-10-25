package dndProject;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JSplitPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Label;

import net.miginfocom.swing.MigLayout;


public class DnDHandBook implements ListSelectionListener{

	private JFrame frame;
	private String[] raceNames = { "Human", "Elf" };
	private String[] humanNames = { "Royal", "Bum" };
	private String[] elfNames = { "Dark Elf", "High Elf" };
	private JList<String[]> list, humanList, elfList; 
	private JSplitPane raceMenu, humanMenu, elfMenu;
	
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
	
	private ListSelectionListener humanListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateSubHumanRightPane(list.getSelectedIndex());
		}
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnDHandBook window = new DnDHandBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DnDHandBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel startMenu = new JPanel();
		frame.getContentPane().add(startMenu, "name_730638497947775");
		startMenu.setLayout(new MigLayout("", "[100%,center]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		
		raceMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		frame.getContentPane().add(raceMenu, "name_731099668565998");
		raceMenu.setOneTouchExpandable(true);
		raceMenu.setDividerLocation(100);
		
		JLabel titleName = new JLabel("DnD Hand Book");
		titleName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		startMenu.add(titleName, "cell 0 2,alignx center,aligny center");
		
		JButton loadCharacter = new JButton("Load Character");
		startMenu.add(loadCharacter, "cell 0 6,alignx center,aligny center");
		
		JButton createCharacter = new JButton("Create Character");
		startMenu.add(createCharacter, "cell 0 7,alignx center,aligny center");
		createCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startMenu.setVisible(false);
				raceMenu.setVisible(true);
			}
		});
		
        list = new JList(raceNames);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(raceListener);
        
		JScrollPane raceList = new JScrollPane(list);
		raceMenu.setLeftComponent(raceList);
		updateRaceRightPane(0);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		System.out.println(list.getSelectedValue());
	}
	
	public void updateRaceRightPane(int index){
		switch(index){
		case 0: // human
			humanMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			humanMenu.setDividerLocation(100);
			raceMenu.setRightComponent(humanMenu);
			
			humanList = new JList(humanNames);
			humanList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			humanList.setSelectedIndex(0);
			humanList.addListSelectionListener(humanListener);
			
			JScrollPane human_List = new JScrollPane(humanList);
			humanMenu.setLeftComponent(human_List);
			updateSubHumanRightPane(0);

			break;
		case 1: // elf
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
	
	public void updateSubHumanRightPane(int index){
		switch(index){
		case 0:
			Label royalTitle = new Label("Royal Humans");
			JPanel jpRoyal = new JPanel();
			jpRoyal.setLayout(new GridLayout());
			jpRoyal.add(royalTitle);
			humanMenu.setRightComponent(jpRoyal);
			break;
		case 1:
			Label bumTitle = new Label("Bum Humans");
			JPanel jpBum = new JPanel();
			jpBum.setLayout(new GridLayout());
			jpBum.add(bumTitle);
			humanMenu.setRightComponent(jpBum);
			break;
		default: break;
		}
	}
	
	public void updateSubElfRightPane(int index){
		switch(index){
		case 0:
			Label darkElfTitle = new Label("Dark Elf");
			JPanel jpDarkElf = new JPanel();
			jpDarkElf.setLayout(new GridLayout());
			jpDarkElf.add(darkElfTitle);
			elfMenu.setRightComponent(jpDarkElf);
			break;
		case 1:
			Label highElfTitle = new Label("High Elf");
			JPanel jpHighElf = new JPanel();
			jpHighElf.setLayout(new GridLayout());
			jpHighElf.add(highElfTitle);
			elfMenu.setRightComponent(jpHighElf);
			break;
		default: break;
		}
	}
}
