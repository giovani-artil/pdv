package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Fornecedor;
import dao.DAOForn;

public class VisuNFornGPanel extends JPanel {

	private JTextField tfNome;
	private JButton btBusc, btBack;
	private ArrayList<Fornecedor> fornecedores;

	public VisuNFornGPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editforn.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(675, 315, 275, 40);
		
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
				fornecedores = DAOForn.verForn();
				int cont=-1;
				for(int i=0; i<fornecedores.size(); i++) {
					if(tfNome.getText().equals(fornecedores.get(i).getCnpj())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					JOptionPane.showMessageDialog(null, "Nome: "+fornecedores.get(cont).getNome()+"\nEndereço: "+fornecedores.get(cont).getEnd()+
							"\nProduto: "+fornecedores.get(cont).getProd()+"\nTelefone: "+fornecedores.get(cont).getTele()+
							"\nCNPJ: "+fornecedores.get(cont).getCnpj());
				}else {
					JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
