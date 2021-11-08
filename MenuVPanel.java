package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuVPanel extends JPanel{

	
	public MenuVPanel() {
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("menuv.png"))
						.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
					));
		fundo.setBounds(-10, -20, 1366, 685);
		
		add(fundo);
	}
	
	private void event() {
		
	}
}
