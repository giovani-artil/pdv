package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class VisuPromoGPanel extends JPanel {

	private JButton btBack;
	private JScrollPane spPanel;
	private JList list;
	private ArrayList<Promocao> promos;

	public VisuPromoGPanel() {
		promos = DAOPromo.verPromo();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visutela.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		String [] dadosPromo = new String [promos.size()];
		for(int i=0; i<dadosPromo.length; i++) {
			String aux = "";
			aux = promos.get(i).getNome()+"Desconto: "+promos.get(i).getDesc();
			dadosPromo[i] = aux;
		}
		
		list = new JList(dadosPromo);
		list.setBackground(Color.cyan);
		list.setForeground(Color.black);
		
		spPanel = new JScrollPane(list);
		spPanel.setBounds(0, 0, 683, 685);
		
		btBack = new JButton("Voltar");
		btBack.setBounds(678, 340, 150, 40);
		
		add(spPanel);
		add(btBack);
		add(fundo);
	}

	private void event() {
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuGPanel panel = new MenuGPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
	}
}
