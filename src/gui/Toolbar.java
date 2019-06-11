package gui;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel {

	private JLabel clock;

	public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
		
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		clock = new JLabel("Current Date: " + dateFormat.format(date));
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		add(clock);

	}


	// http://dev.cs.ovgu.de/java/Tutorials/java.old/uiswing/components/toolbar.html

}
