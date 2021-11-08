package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class VisuTdClieVPanel extends JPanel {

	private JButton btBack;
	private JScrollPane spPanel;
	private JList list;
	private ArrayList<Cliente> clientes;

	public VisuTdClieVPanel() {
		clientes = DAOClie.verCli();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visutela.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		String [] dadosClie = new String [clientes.size()];
		for(int i=0; i<dadosClie.length; i++) {
			String aux = "";
			aux = "Nome: "+clientes.get(i).getNome()+"CPF: "+clientes.get(i).getCpf()+"Rua: "+clientes.get(i).getRua()+
					"Bairro: "+clientes.get(i).getBairro();
			dadosClie[i] = aux;
		}
		
		list = new JList(dadosClie);
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
				VisuClieVPanel panel = new VisuClieVPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
	}
}