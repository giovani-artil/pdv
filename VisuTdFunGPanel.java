package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class VisuTdFunGPanel extends JPanel {

	private JButton btBack;
	private JScrollPane spPanel;
	private JList list;
	private ArrayList<Vendedor> vendedores;

	public VisuTdFunGPanel() {
		vendedores = DAOVende.verVend();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visutela.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		String [] dadosVend = new String [vendedores.size()];
		for(int i=0; i<dadosVend.length; i++) {
			String aux = "";
			aux = "Nome: "+vendedores.get(i).getNome()+"Senha: "+vendedores.get(i).getSenha()+"Email: "+
			vendedores.get(i).getEmail()+"Telefone: "+vendedores.get(i).getTele()+"CPF: "+vendedores.get(i).getCpf();
			dadosVend[i] = aux;
		}
		
		list = new JList(dadosVend);
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
				VisuFunGPanel panel = new VisuFunGPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
	}
}