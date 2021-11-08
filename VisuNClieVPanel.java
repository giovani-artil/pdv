package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Cliente;
import dao.DAOClie;

public class VisuNClieVPanel extends JPanel {

	private JTextField tfNome;
	private JButton btBusc, btBack;
	private ArrayList<Cliente> clientes;

	public VisuNClieVPanel() {
		comp();
		event();
	}

	private void comp() {
		setLayout(null);

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editclie.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(675, 305, 275, 40);
		
		btBusc = new JButton("Buscar");
		btBusc.setBounds(683, 431, 90, 40);
		
		btBack = new JButton("Cancelar");
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
				clientes = DAOClie.verCli();
				int cont=-1;
				for(int i=0; i<clientes.size(); i++) {
					if(tfNome.getText().equals(clientes.get(i).getCpf())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					JOptionPane.showMessageDialog(null, "Nome: "+clientes.get(cont).getNome()+"\nCPF: "+clientes.get(cont).getCpf()+
							"\nRua: "+clientes.get(cont).getRua()+"\nBairro: "+clientes.get(cont).getBairro());
				}else {
					JOptionPane.showMessageDialog(null, "Clienet não encontrado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
