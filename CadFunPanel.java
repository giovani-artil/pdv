package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import dao.*;
import pdv.*;

public class CadFunPanel extends JPanel {

	private JTextField tfNome, tfSenha, tfEmail, tfTel, tfCPF;
	private JButton btCad, btCancel;
	private ArrayList<Vendedor> vends;

	public CadFunPanel() {
		vends = DAOVende.verVend();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);
		//setBackground(new Color(81, 224, 156));

		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("cadeditfun.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
			));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(375, 150, 265, 35);

		tfSenha = new JTextField();
		tfSenha.setBounds(375, 232, 265, 35);

		tfEmail = new JTextField();
		tfEmail.setBounds(375, 305, 265, 35);

		tfTel = new JTextField();
		tfTel.setBounds(395, 385, 250, 35);

		tfCPF = new JTextField();
		tfCPF.setBounds(365, 462, 255, 35);

		btCad = new JButton("Cadastrar");
		btCad.setBounds(895, 275, 180, 40);

		btCancel = new JButton("Cancelar");
		btCancel.setBounds(895, 335, 180, 40);

		add(tfNome);
		add(tfSenha);
		add(tfEmail);
		add(tfTel);
		add(tfCPF);
		add(btCad);
		add(btCancel);
		add(fundo);
	}

	private void event() {
		btCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean valid = true;
					String nome = tfNome.getText();
					String senha = tfSenha.getText();
					String email = tfEmail.getText();
					String tele = tfTel.getText();
					String cpf = tfCPF.getText();
					for(int i=0; i<vends.size(); i++) {
						if(cpf.equals(vends.get(i).getCpf())) {
							JOptionPane.showMessageDialog(null, "Vendedor já cadastrado!", "AVISO", JOptionPane.WARNING_MESSAGE);
							valid=false;
						}
					}
					if(valid) {
						Vendedor vend = new Vendedor(nome, senha, email, tele, cpf);
						DAOVende.cadVende(vend);
						tfNome.setText(null);
						tfSenha.setText(null);
						tfEmail.setText(null);
						tfTel.setText(null);
						tfCPF.setText(null);
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btCancel.addActionListener(new ActionListener() {

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
