package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import pdv.*;
import dao.*;

public class VendaQntProdPanel extends JPanel{

	private JTextField tfNome;
	private JButton btOk, btCancel;
	private Produto prod;
	private ArrayList<Produto> prods;
	
	public VendaQntProdPanel(Produto prod) {
		this.prod = prod;
		prods = DAOProd.verProd();
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("vendaqp.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(710, 315, 230, 40);
		
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
				try {
					int qnt = Integer.parseInt(tfNome.getText());
					float vv = prod.getValorV();
					float vr = prod.getValorR();
					if(qnt<=prod.getQntd()) {
						prod.setQntd(prod.getQntd()-qnt);
						for(int i=0; i<prods.size(); i++) {
							if(prod.getCod().equals(prods.get(i).getCod())) {
								prods.set(i, prod);
								DAOProd.editProd(prods);
							}
						}
						Gerente.setLucro(qnt*(vr-vv));
						JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
						MenuVPanel panel = new MenuVPanel();
						MenuVFrame.container.removeAll();
						MenuVFrame.container.add(panel);
						MenuVFrame.container.validate();
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade insuficiente!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Utilize apenas números!", "AVISO", JOptionPane.WARNING_MESSAGE);
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
