package dndProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSplitPane;

import raceCollection.DragonBorn;
import raceCollection.HalfElf;
import raceCollection.HalfOrc;
import raceCollection.Human;
import raceCollection.Tiefling;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class DnDHandBook {

	public JFrame frame;
	public CharacterCreation cC;
	public RaceMenu rM;
	public JPanel cCreationPanel;
	public Human hm; // memory location 5
	public HalfElf hE;
	public HalfOrc hO;
	public DragonBorn dB;
	public Tiefling tF;
	private JSplitPane raceMenu;
	
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

		cC = new CharacterCreation();
		rM = new RaceMenu();
		hm = rM.getHuman(); // take loc 32's object and save it to loc 5
		// DnDHandBook Hm and a RaceMenu hm 
		dB = rM.getDragonBorn();
		tF = rM.getTiefing();
		hE = rM.getHalfElf();
		hO = rM.getHalfOrc();
		
		//frame.setBounds(100, 100, 532, 300);
		frame.setSize(720, 540);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel startMenu = new JPanel();
		frame.getContentPane().add(startMenu, "name_730638497947775");
		startMenu.setLayout(new MigLayout("", "[100%,center]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));

		JLabel titleName = new JLabel("DnD Hand Book");
		titleName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		startMenu.add(titleName, "cell 0 2,alignx center,aligny center");
		
		JButton loadCharacter = new JButton("Load Character");
		startMenu.add(loadCharacter, "cell 0 6,alignx center,aligny center");
		
		JButton createCharacter = new JButton("Create Character");
		startMenu.add(createCharacter, "cell 0 7,alignx center,aligny center");
		createCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cCreationPanel = cC.getCharacterCreationPanel();
				frame.getContentPane().add(cCreationPanel);
				startMenu.setVisible(false);
				cCreationPanel.setVisible(true);	
			}
		}); 
		
		JButton raceMenuOpen = cC.getOpenRaceMenuButton();
		raceMenuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu = rM.getRaceMenuSplitPane();
				frame.getContentPane().add(raceMenu);
				cCreationPanel.setVisible(false);
				raceMenu.setVisible(true);	
			}
		});
		
		waitForRaceAcceptance(hm.getAcceptedRace(), "Human");
		waitForRaceAcceptance(dB.getAcceptedRace(), "DragonBorn");
		waitForRaceAcceptance(tF.getAcceptedRace(), "Tiefling");
		waitForRaceAcceptance(hE.getAcceptedRace(), "HalfElf");
		waitForRaceAcceptance(hO.getAcceptedRace(), "HalfOrc");
	}
	
	public void waitForRaceAcceptance( JButton race, String name){
			race.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu.setVisible(false);
				cC.setRace(name);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
}
