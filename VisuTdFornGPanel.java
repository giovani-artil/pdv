package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class VisuTdFornGPanel extends JPanel {

	private JButton btBack;
	private JScrollPane spPanel;
	private JList list;
	private ArrayList<Fornecedor> fornecedores;

	public VisuTdFornGPanel() {
		fornecedores = DAOForn.verForn();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visutela.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		String [] dadosForn = new String [fornecedores.size()];
		for(int i=0; i<dadosForn.length; i++) {
			String aux = "";
			aux = "Nome: "+fornecedores.get(i).getNome()+"Endereço: "+fornecedores.get(i).getEnd()+"Produto: "+fornecedores.get(i).getProd()+
					"Telefone: "+fornecedores.get(i).getTele()+"CNPJ: "+fornecedores.get(i).getCnpj();
			dadosForn[i] = aux;
		}
		
		list = new JList(dadosForn);
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
				VisuFornGPanel panel = new VisuFornGPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
	}
}