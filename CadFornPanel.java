package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import dao.*;
import pdv.*;

public class CadFornPanel extends JPanel{
	
	private JTextField tfNome, tfEnd, tfProd, tfTel, tfCNPJ;
	private JButton btCad, btCancel;
	private ArrayList<Fornecedor> forns;
	
	public CadFornPanel() {
		forns = DAOForn.verForn();
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		//setBackground(new Color(81, 224, 156));
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("cadeditforn.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
			));
		fundo.setBounds(-10, -20, 1366, 685);
		
		btCad = new JButton("Cadastrar");
		btCad.setBounds(880, 275, 180, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(880, 335, 180, 40);
		
		tfNome = new JTextField();
		tfNome.setBounds(425, 188, 245, 30);
		
		tfEnd = new JTextField();
		tfEnd.setBounds(360, 262, 310, 30);
		
		tfProd = new JTextField();
		tfProd.setBounds(425, 328, 245, 30);
		
		tfTel = new JTextField();
		tfTel.setBounds(360, 400, 310, 30);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setBounds(340, 470, 330, 30);
		
		add(tfNome);
		add(tfEnd);
		add(tfProd);
		add(tfTel);
		add(tfCNPJ);
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
					String end = tfEnd.getText();
					String prod = tfProd.getText();
					String tele = tfTel.getText();
					String cnpj = tfCNPJ.getText();
					for(int i=0; i<forns.size(); i++) {
						if(cnpj.equals(forns.get(i).getCnpj())) {
							JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!", "AVISO", JOptionPane.WARNING_MESSAGE);
							valid=false;
						}
					}
					if(valid) {
						Fornecedor forn = new Fornecedor(nome, end, prod, tele, cnpj);
						DAOForn.cadForn(forn);
						tfNome.setText(null);
						tfEnd.setText(null);
						tfProd.setText(null);
						tfTel.setText(null);
						tfCNPJ.setText(null);
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
