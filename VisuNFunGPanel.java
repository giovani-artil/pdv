package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Vendedor;
import dao.DAOVende;

public class VisuNFunGPanel extends JPanel {

	private JTextField tfNome;
	private JButton btBusc, btBack;
	private ArrayList<Vendedor> vendedores;

	public VisuNFunGPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editfun.png")).getImage()
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
				vendedores = DAOVende.verVend();
				int cont=-1;
				for(int i=0; i<vendedores.size(); i++) {
					if(tfNome.getText().equals(vendedores.get(i).getCpf())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					JOptionPane.showMessageDialog(null, "Nome: "+vendedores.get(cont).getNome()+"\nSenha: "+vendedores.get(cont).getSenha()+
							"\nEmail: "+vendedores.get(cont).getEmail()+"\nTelefone: "+vendedores.get(cont).getTele()+"\nCPF: "+
							vendedores.get(cont).getCpf());
				}else {
					JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
