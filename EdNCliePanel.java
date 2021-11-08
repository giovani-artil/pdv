package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EdNCliePanel extends JPanel{

	private JTextField tfNome;
	private JButton btBusc, btCancel;
	
	public EdNCliePanel() {
		comp();
		event();
	}
	
	private void comp() {
		setLayout(null);
		
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("editclie.png")).getImage()
				.getScaledInstance(1366, 685, Image.SCALE_DEFAULT)));
		fundo.setBounds(-10, -20, 1366, 685);
		
		tfNome = new JTextField();
		tfNome.setBounds(675, 305, 275, 40);
		
		btBusc = new JButton("Buscar");
		btBusc.setBounds(683, 431, 90, 40);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(685, 500, 180, 40);
		
		add(tfNome);
		add(btBusc);
		add(btCancel);
		add(fundo);
	}
	
	private void event() {
		btBusc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditCliePanel panel = new EditCliePanel(tfNome.getText());
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
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
