package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuGPanel extends JPanel {


	public MenuGPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);
		// setBackground(new Color(81, 224, 156));

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("menug.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
			));
		fundo.setBounds(-10, -20, 1366, 685);
		
		add(fundo);
	}

	private void event() {
		
	}
}
