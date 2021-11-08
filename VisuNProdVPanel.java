package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Produto;
import dao.DAOProd;

public class VisuNProdVPanel extends JPanel {

	private JTextField tfNome;
	private JButton btBusc, btBack;
	private ArrayList<Produto> produtos;

	public VisuNProdVPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editprod.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(675, 308, 275, 40);
		
		btBusc = new JButton("Buscar");
		btBusc.setBounds(485, 500, 180, 40);
		
		btBack = new JButton("Voltar");
		btBack.setBounds(685, 500, 180, 40);

		add(tfNome);
		add(btBusc);
		add(btBack);
		add(fundo);
	}

	private void event() {
		btBusc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				produtos = DAOProd.verProd();
				int cont=-1;
				for(int i=0; i<produtos.size(); i++) {
					if(tfNome.getText().equals(produtos.get(i).getCod())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					JOptionPane.showMessageDialog(null, "Nome: "+produtos.get(cont).getNome()+"\nCódigo: "+produtos.get(cont).getCod()
							+"\nQuantidade: "+produtos.get(cont).getQntd()+"\nValor Venda: R$"+produtos.get(cont).getValorV()+"\nValor Revenda: R$"
							+produtos.get(cont).getValorR());
				}else {
					JOptionPane.showMessageDialog(null, "Produto não encontrado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
