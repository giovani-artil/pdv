package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Vendedor;
import dao.DAOVende;

public class EditFunPanel extends JPanel {

	private JTextField tfNome, tfSenha, tfEmail, tfTel, tfCPF;
	private JButton btCad, btExc, btCancel;
	private String cpf;
	private ArrayList<Vendedor> vendedores;

	public EditFunPanel(String cpf) {
		vendedores = DAOVende.verVend();
		this.cpf = cpf;
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
		
		int cont=-1;
		for(int i=0; i<vendedores.size(); i++) {
			if(cpf.equals(vendedores.get(i).getCpf())) {
				cont=i;
			}
		}
		
		tfNome = new JTextField(vendedores.get(cont).getNome());
		tfNome.setBounds(375, 150, 265, 35);

		tfSenha = new JTextField(vendedores.get(cont).getSenha());
		tfSenha.setBounds(375, 232, 265, 35);

		tfEmail = new JTextField(vendedores.get(cont).getEmail());
		tfEmail.setBounds(375, 305, 265, 35);

		tfTel = new JTextField(vendedores.get(cont).getTele());
		tfTel.setBounds(395, 385, 250, 35);

		tfCPF = new JTextField(vendedores.get(cont).getCpf());
		tfCPF.setBounds(365, 462, 255, 35);
		tfCPF.setEditable(false);

		btCad = new JButton("Salvar");
		btCad.setBounds(895, 275, 180, 40);
		
		btExc = new JButton("Excluir");
		btExc.setBounds(895, 335, 180, 40);

		btCancel = new JButton("Cancelar");
		btCancel.setBounds(895, 395, 180, 40);

		add(tfNome);
		add(tfSenha);
		add(tfEmail);
		add(tfTel);
		add(tfCPF);
		add(btCad);
		add(btExc);
		add(btCancel);
		add(fundo);
	}

	private void event() {
		btCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<vendedores.size(); i++) {
					if(cpf.equals(vendedores.get(i).getCpf())) {
						cont=i;
					}
				}
				
				if(cont!=-1) {
					Vendedor vend = new Vendedor(tfNome.getText(), tfSenha.getText(), tfEmail.getText(), tfTel.getText(), tfCPF.getText());
					vendedores.set(cont, vend);
					DAOVende.editVende(vendedores);
				}
			}
		});
		
		btExc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<vendedores.size(); i++) {
					if(cpf.equals(vendedores.get(i).getCpf())) {
						cont=i;
					}
				}
				
				if(cont!=-1) {
					Vendedor vend = new Vendedor(tfNome.getText(), tfSenha.getText(), tfEmail.getText(), tfTel.getText(), tfCPF.getText());
					vendedores.remove(cont);
					DAOVende.editVende(vendedores);
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
