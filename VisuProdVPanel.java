package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VisuProdVPanel extends JPanel {

	private JButton btTds, btNome;

	public VisuProdVPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visu.png")).getImage()
				.getScaledInstance(1366, 650, Image.SCALE_DEFAULT)));
		fundo.setBounds(0, 0 , 1366, 685);

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
				VisuTdProdGPanel panel = new VisuTdProdGPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
		
		btNome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuNProdGPanel panel = new VisuNProdGPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
	}
}
