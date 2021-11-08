package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import dao.DAOGeren;
import pdv.Gerente;

public class EditGerenPanel extends JPanel {

	private JTextField tfNome, tfSenha, tfEmail, tfTel, tfCPF;
	private JButton btCad, btCancel;
	private Gerente geren;

	public EditGerenPanel() {
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
		
		geren = DAOGeren.getGeren();
		
		tfNome = new JTextField(geren.getNome());
		tfNome.setBounds(375, 150, 265, 35);

		tfSenha = new JTextField(geren.getSenha());
		tfSenha.setBounds(375, 232, 265, 35);

		tfEmail = new JTextField(geren.getEmail());
		tfEmail.setBounds(375, 305, 265, 35);

		tfTel = new JTextField(geren.getTele());
		tfTel.setBounds(395, 385, 250, 35);

		tfCPF = new JTextField(geren.getCpf());
		tfCPF.setBounds(365, 462, 255, 35);

		btCad = new JButton("Salvar");
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
				Gerente geren = new Gerente(tfNome.getText(), tfSenha.getText(), tfEmail.getText(), tfTel.getText(), tfCPF.getText());
				DAOGeren.editGerent(geren);
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
