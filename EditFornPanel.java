package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import pdv.Fornecedor;
import dao.DAOForn;

public class EditFornPanel extends JPanel{
	
	private JTextField tfNome, tfEnd, tfProd, tfTel, tfCNPJ;
	private JButton btCad, btExc, btCancel;
	private String cnpj;
	private ArrayList<Fornecedor> fornecedores;
	
	public EditFornPanel(String cnpj) {
		fornecedores = DAOForn.verForn();
		this.cnpj = cnpj;
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
		
		int cont=-1;
		for(int i=0; i<fornecedores.size(); i++) {
			if(cnpj.equals(fornecedores.get(i).getCnpj())) {
				cont=i;
			}
		}
		
		btCad = new JButton("Salvar");
		btCad.setBounds(880, 275, 180, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(880, 395, 180, 40);
		
		btExc = new JButton("Excluir");
		btExc.setBounds(880, 335, 180, 40);
		
		tfNome = new JTextField(fornecedores.get(cont).getNome());
		tfNome.setBounds(425, 188, 245, 30);
		
		tfEnd = new JTextField(fornecedores.get(cont).getEnd());
		tfEnd.setBounds(360, 262, 310, 30);
		
		tfProd = new JTextField(fornecedores.get(cont).getProd());
		tfProd.setBounds(425, 328, 245, 30);
		
		tfTel = new JTextField(fornecedores.get(cont).getTele());
		tfTel.setBounds(360, 400, 310, 30);
		
		tfCNPJ = new JTextField(fornecedores.get(cont).getCnpj());
		tfCNPJ.setBounds(340, 470, 330, 30);
		tfCNPJ.setEditable(false);
		
		add(tfNome);
		add(tfEnd);
		add(tfProd);
		add(tfTel);
		add(tfCNPJ);
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
				for(int i=0; i<fornecedores.size(); i++) {
					if(cnpj.equals(fornecedores.get(i).getCnpj())) {
						cont=i;
					}
				}
				
				if(cont!=-1) {
					Fornecedor forn = new Fornecedor(tfNome.getText(), tfEnd.getText(), tfProd.getText(), tfTel.getText(), tfCNPJ.getText());
					fornecedores.set(cont, forn);
					DAOForn.editForn(fornecedores);
				}
			}
		});
		
		btExc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<fornecedores.size(); i++) {
					if(cnpj.equals(fornecedores.get(i).getCnpj())) {
						cont=i;
					}
				}
				
				if(cont!=-1) {
					Fornecedor forn = new Fornecedor(tfNome.getText(), tfEnd.getText(), tfProd.getText(), tfTel.getText(), tfCNPJ.getText());
					fornecedores.remove(cont);
					DAOForn.editForn(fornecedores);
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
