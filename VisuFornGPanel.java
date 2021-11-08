package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VisuFornGPanel extends JPanel {

	private JButton btTds, btNome;

	public VisuFornGPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visu.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		btTds = new JButton("Visualizar Todos");
		btTds.setBounds(255, 250, 250, 40);

		btNome = new JButton("Visualizar pelo Nome");
		btNome.setBounds(255, 340, 250, 40);

		add(btTds);
		add(btNome);
		add(fundo);
	}

	private void event() {
		btTds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuTdFornGPanel panel = new VisuTdFornGPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
		
		btNome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuNFornGPanel panel = new VisuNFornGPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
	}
}
