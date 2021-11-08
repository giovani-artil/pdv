package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class VisuTdProdVPanel extends JPanel {

	private JButton btBack;
	private JScrollPane spPanel;
	private JList list;
	private ArrayList<Produto> produtos;

	public VisuTdProdVPanel() {
		produtos = DAOProd.verProd();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("visutela.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		String [] dadosProd = new String [produtos.size()];
		for(int i=0; i<dadosProd.length; i++) {
			String aux = "";
			aux = produtos.get(i).getNome()+"Código: "+produtos.get(i).getCod()+"Quantidade: "+
			String.valueOf(produtos.get(i).getQntd())+"Valor de Venda: R$"+String.valueOf(produtos.get(i).getValorV())+"Valor de Revenda: R$"+
					String.valueOf(produtos.get(i).getValorR())+"Data de Fab: "+produtos.get(i).getDatFab()+"Data de Val: "+produtos.get(i).getDatVal();
			dadosProd[i] = aux;
		}
		
		list = new JList(dadosProd);
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
				VisuProdVPanel panel = new VisuProdVPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
	}
}
