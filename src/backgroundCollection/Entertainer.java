package backgroundCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Entertainer {
	private JPanel jp;
	private JButton acceptBackground;

	public Entertainer() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Entertainer</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		acceptBackground = new JButton("Accept Entertainer as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
}

