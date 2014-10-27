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
import raceCollection.Human;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class DnDHandBook {

	public JFrame frame;
	public CharacterCreation cC;
	public RaceMenu rM;
	public JPanel cCreationPanel;
	public Human hm;
	public DragonBorn dB;
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
		hm = rM.getHuman();
		dB = rM.getDragonBorn();

		//frame.setBounds(100, 100, 532, 300);
		frame.setSize(640, 480);
		
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
		
		JButton humanSelected = hm.getAcceptedHumanButton();
		humanSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu.setVisible(false);
				cC.setRace("Human");
				cCreationPanel.setVisible(true);
			}
		});
		
		JButton dragonBornSelected = dB.getAcceptedDragonBornButton();
		dragonBornSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu.setVisible(false);
				cC.setRace("Dragonborn");
				cCreationPanel.setVisible(true);
			}
		});
	}
}
