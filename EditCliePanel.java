package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Cliente;
import dao.DAOClie;

public class EditCliePanel extends JPanel{

	private JTextField tfNome, tfCPF, tfRua, tfBairro;
	private JButton btCad, btExc, btCancel;
	private String cpf;
	private ArrayList<Cliente> clientes;
	
	public EditCliePanel(String cpf) {
		clientes = DAOClie.verCli();
		this.cpf = cpf;
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		//setBackground(new Color(81, 224, 156));
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("cadeditclie.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		int cont=-1;
		for(int i=0; i<clientes.size(); i++) {
			if(cpf.equals(clientes.get(i).getCpf())) {
				cont=i;
			}
		}
		
		tfNome = new JTextField(clientes.get(cont).getNome());
		tfNome.setBounds(380, 185, 360, 35);
		
		tfCPF = new JTextField(clientes.get(cont).getCpf());
		tfCPF.setBounds(380, 275, 360, 35);
		tfCPF.setEditable(false);
		
		tfRua = new JTextField(clientes.get(cont).getRua());
		tfRua.setBounds(380, 355, 360, 35);
		
		tfBairro = new JTextField(clientes.get(cont).getBairro());
		tfBairro.setBounds(390, 445, 353, 35);
		
		btCad = new JButton("Salvar");
		btCad.setBounds(900, 275, 180, 40);
		
		btExc = new JButton("Excluir");
		btExc.setBounds(900, 335, 180, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(900, 400, 180, 40);
		
		add(tfNome);
		add(tfCPF);
		add(tfRua);
		add(tfBairro);
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
				for(int i=0; i<clientes.size(); i++) {
					if(cpf.equals(clientes.get(i).getCpf())) {
						cont=i;
					}
				}
				
				if(cont!=-1) {
					Cliente cli = new Cliente(tfNome.getText(), tfCPF.getText(), tfRua.getText(), tfBairro.getText());
					clientes.set(cont, cli);
					DAOClie.editCli(clientes);
				}
			}
		});
		
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuGPanel panel = new MenuGPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
	}
}
