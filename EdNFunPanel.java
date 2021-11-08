package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EdNFunPanel extends JPanel{

	private JTextField tfNome;
	private JButton btBusc, btBack;
	
	public EdNFunPanel() {
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editfun.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(675, 315, 275, 40);
		
		btBusc = new JButton("Buscar");
		btBusc.setBounds(485, 500, 180, 40);
		
		btBack = new JButton("Voltar");
		btBack.setBounds(685, 500, 180, 40);
		
		add(tfNome);
		add(btBusc);
		add(btBack);
		add(fundo);
	}
	
	private void event() {
		btBusc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditFunPanel panel = new EditFunPanel(tfNome.getText());
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
		
		btBack.addActionListener(new ActionListener() {
			
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
