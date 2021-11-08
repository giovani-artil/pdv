package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import pdv.Produto;
import dao.DAOProd;

public class VendaNProdPanel extends JPanel{

	private JTextField tfNome;
	private JButton btOk, btCancel;
	private ArrayList<Produto> prods;
	private Produto prod;
	
	public VendaNProdPanel() {
		prods = DAOProd.verProd();
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("vendanp.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(775, 315, 230, 40);
		
		btOk = new JButton("Ok");
		btOk.setBounds(485, 500, 180, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(685, 500, 180, 40);
		
		add(tfNome);
		add(btOk);
		add(btCancel);
		add(fundo);
	}
	
	private void event() {
		btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=-1;
				for(int i=0; i<prods.size(); i++) {
					if(tfNome.getText().equals(prods.get(i).getNome())) {
						cont=i;
					}
				}
				if(cont!=-1) {
					prod = new Produto(prods.get(cont).getNome(), prods.get(cont).getCod(), prods.get(cont).getQntd(), prods.get(cont).getValorV(),
							prods.get(cont).getValorR(), prods.get(cont).getDatFab(), prods.get(cont).getDatVal());
					VendaQntProdPanel panel = new VendaQntProdPanel(prod);
					MenuVFrame.container.removeAll();
					MenuVFrame.container.add(panel);
					MenuVFrame.container.validate();
					
				}else {
					JOptionPane.showMessageDialog(null, "Produto não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
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
