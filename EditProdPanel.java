package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import dao.DAOProd;
import dao.DAOPromo;
import pdv.Produto;
import pdv.Promocao;

public class EditProdPanel extends JPanel {

	private JTextField tfNome, tfCod, tfQnt, tfVend, tfRevnd, tfDFab, tfDVen;
	private JButton btCad, btExc, btProm, btCancel;
	private String cod;
	private ArrayList<Produto> produtos;

	public EditProdPanel(String cod) {
		produtos = DAOProd.verProd();
		this.cod = cod;
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
		
		int cont=-1;
		for(int i=0; i<produtos.size(); i++) {
			if(cod.equals(produtos.get(i).getCod())) {
				cont=i;
			}
		}

		tfNome = new JTextField(produtos.get(cont).getNome());
		tfNome.setBounds(365, 115, 265, 30);

		tfCod = new JTextField(produtos.get(cont).getCod());
		tfCod.setBounds(365, 187, 265, 30);
		tfCod.setEditable(false);

		tfQnt = new JTextField(String.valueOf(produtos.get(cont).getQntd()));
		tfQnt.setBounds(405, 255, 245, 30);

		tfVend = new JTextField(String.valueOf(produtos.get(cont).getValorV()));
		tfVend.setBounds(425, 325, 225, 30);

		tfRevnd = new JTextField(String.valueOf(produtos.get(cont).getValorR()));
		tfRevnd.setBounds(435, 395, 218, 30);

		tfDFab = new JTextField(produtos.get(cont).getDatFab());
		tfDFab.setBounds(450, 468, 210, 30);

		tfDVen = new JTextField(produtos.get(cont).getDatVal());
		tfDVen.setBounds(435, 540, 218, 30);

		btCad = new JButton("Salvar");
		btCad.setBounds(895, 275, 180, 40);
		
		btProm = new JButton("Aplicar promoção");
		btProm.setBounds(895, 335, 180, 40);
		
		btExc = new JButton("Excluir");
		btExc.setBounds(895, 395, 180, 40);

		btCancel = new JButton("Cancelar");
		btCancel.setBounds(895, 455, 180, 40);

		add(tfNome);
		add(tfCod);
		add(tfQnt);
		add(tfVend);
		add(tfRevnd);
		add(tfDFab);
		add(tfDVen);
		add(btCad);
		add(btProm);
		add(btExc);
		add(btCancel);
		add(fundo);
	}

	private void event() {
		btCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<produtos.size(); i++) {
					if(cod.equals(produtos.get(i).getCod())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					Produto prod = new Produto(tfNome.getText(), cod, Integer.parseInt(tfQnt.getText()), Float.parseFloat(tfVend.getText()), Float.parseFloat(tfRevnd.getText()), tfDFab.getText(), tfDVen.getText());
					produtos.set(cont, prod);
					DAOProd.editProd(produtos);
				}
			}
		});
		
		btProm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<produtos.size(); i++) {
					if(cod.equals(produtos.get(i).getCod())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					float vp = Float.parseFloat(JOptionPane.showInputDialog("Qual será o desconto?"));
					float aux = produtos.get(cont).getValorR();
					produtos.get(cont).setValorR(aux-(aux*(vp/100)));
					tfRevnd.setText(String.valueOf(produtos.get(cont).getValorR()));
					try {
						Promocao promo = new Promocao(produtos.get(cont).getNome(), String.valueOf(vp));
						DAOPromo.cadProd(promo);
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			}
		});
		
		btExc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<produtos.size(); i++) {
					if(cod.equals(produtos.get(i).getCod())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					Produto prod = new Produto(tfNome.getText(), cod, Integer.parseInt(tfQnt.getText()), Float.parseFloat(tfVend.getText()), Float.parseFloat(tfRevnd.getText()), tfDFab.getText(), tfDVen.getText());
					produtos.remove(cont);
					DAOProd.editProd(produtos);
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
