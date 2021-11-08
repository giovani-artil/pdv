package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import dao.*;
import pdv.*;

public class CadProdPanel extends JPanel {

	private JTextField tfNome, tfCod, tfQnt, tfVend, tfRevnd, tfDFab, tfDVen;
	private JButton btCad, btCancel;
	private ArrayList<Produto> prods;

	public CadProdPanel() {
		prods = DAOProd.verProd();
		comp();
		event();
	}

	private void comp() {
		setLayout(null);
		// setBackground(new Color(81, 224, 156));
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("cadprod.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
			));
		fundo.setBounds(-10, -20, 1366, 685);

		tfNome = new JTextField();
		tfNome.setBounds(365, 115, 265, 30);

		tfCod = new JTextField();
		tfCod.setBounds(365, 187, 265, 30);

		tfQnt = new JTextField();
		tfQnt.setBounds(405, 255, 245, 30);

		tfVend = new JTextField();
		tfVend.setBounds(425, 325, 225, 30);

		tfRevnd = new JTextField();
		tfRevnd.setBounds(435, 395, 218, 30);

		tfDFab = new JTextField();
		tfDFab.setBounds(450, 468, 210, 30);

		tfDVen = new JTextField();
		tfDVen.setBounds(435, 540, 218, 30);

		btCad = new JButton("Cadastrar");
		btCad.setBounds(895, 275, 180, 40);

		btCancel = new JButton("Cancelar");
		btCancel.setBounds(895, 335, 180, 40);

		add(tfNome);
		add(tfCod);
		add(tfQnt);
		add(tfVend);
		add(tfRevnd);
		add(tfDFab);
		add(tfDVen);
		add(btCad);
		add(btCancel);
		add(fundo);
	}

	private void event() {
		btCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean test = true;
				do {
					try {
						boolean valid = true;
						String nome = tfNome.getText();
						String cod = tfCod.getText();
						int qntd = Integer.parseInt(tfQnt.getText());
						float valorV = Float.parseFloat(tfVend.getText());
						float valorR = Float.parseFloat(tfRevnd.getText());
						String datFab = tfDFab.getText();
						String datVal = tfDVen.getText();
						for(int i=0; i<prods.size(); i++) {
							if(cod.equals(prods.get(i).getCod())) {
								JOptionPane.showMessageDialog(null, "Produto já cadastrado!", "AVISO", JOptionPane.WARNING_MESSAGE);
								valid=false;
							}
						}
						if(valid) {
							Produto prod = new Produto(nome, cod, qntd, valorV, valorR, datFab, datVal);
							DAOProd.cadProd(prod);
							tfNome.setText(null);
							tfCod.setText(null);
							tfQnt.setText(null);
							tfVend.setText(null);
							tfRevnd.setText(null);
							tfDFab.setText(null);
							tfDVen.setText(null);
						}
						test = false;
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}
				}while(test);
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
