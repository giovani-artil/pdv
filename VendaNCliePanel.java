package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import pdv.Cliente;
import dao.DAOClie;

public class VendaNCliePanel extends JPanel{

	private JTextField tfNome;
	private JButton btOk, btCancel;
	private ArrayList<Cliente> clis;
	private Cliente cli;
	
	public VendaNCliePanel() {
		clis = DAOClie.verCli();
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("vendanc.png")).getImage()
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
				for(int i=0; i<clis.size(); i++) {
					if(tfNome.getText().equals(clis.get(i).getNome())){
						cont=i;
					}
				}
				if(cont!=-1) {
					JOptionPane.showMessageDialog(null, "Endereço: "+clis.get(cont).getBairro()+", "+clis.get(cont).getRua());
					VendaNProdPanel panel = new VendaNProdPanel();
					MenuVFrame.container.removeAll();
					MenuVFrame.container.add(panel);
					MenuVFrame.container.validate();
				}else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "ERRO", JOptionPane.ERROR_MESSAGE);				}
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
