package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.*;
import dao.*;

public class CadCliePanel extends JPanel{

	private JTextField tfNome, tfCPF, tfRua, tfBairro;
	private JButton btCad, btCancel;
	private ArrayList<Cliente> clis;
	
	public CadCliePanel() {
		clis = DAOClie.verCli();
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		//setBackground(new Color(81, 224, 156));
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("cadeditclie.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
				));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(380, 185, 360, 35);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(380, 275, 360, 35);
		
		tfRua = new JTextField();
		tfRua.setBounds(380, 355, 360, 35);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(390, 445, 353, 35);
		
		btCad = new JButton("Cadastrar");
		btCad.setBounds(900, 275, 180, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(900, 335, 180, 40);
		
		add(tfNome);
		add(tfCPF);
		add(tfRua);
		add(tfBairro);
		add(btCad);
		add(btCancel);
		add(fundo);
	}
	
	private void event() {
		btCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean valid=true;
					String nome = tfNome.getText();
					String cpf = tfCPF.getText();
					String rua = tfRua.getText();
					String bairro = tfBairro.getText();
					for(int i=0; i<clis.size(); i++) {
						if(cpf.equals(clis.get(i).getCpf())) {
							JOptionPane.showMessageDialog(null, "Cliente já cadastrado!", "AVISO", JOptionPane.WARNING_MESSAGE);
							valid=false;
						}
					}
					if(valid) {
						Cliente cli = new Cliente(nome, cpf, rua, bairro);
						DAOClie.cadClie(cli);
						tfNome.setText(null);
						tfCPF.setText(null);
						tfRua.setText(null);
						tfBairro.setText(null);
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuVPanel panel = new MenuVPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
	}
}
