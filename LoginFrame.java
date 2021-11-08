package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import pdv.*;
import dao.*;

public class LoginFrame extends JFrame{
	
	public static LoginFrame frame;
	
	private JTextField tfCPF;
	private JPasswordField tfSenha;
	private JButton btLog, btCancel;
	
	public LoginFrame() {
		comp();
		event();
	}
	
	private void comp() {
		setBounds(0, 0, 1366, 685);
		setResizable(false);
		JLabel fundo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("login.png"))
				.getImage().getScaledInstance(1366, 685, Image.SCALE_DEFAULT)
				));
		setContentPane(fundo);
		setLayout(null);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(268, 243, 360, 35);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(268, 320, 360, 35);
		
		btLog = new JButton("Login");
		btLog.setBounds(335, 530, 90, 40);
		btLog.setBackground(Color.white);
		btLog.setForeground(Color.black);
		
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(440, 530, 90, 40);
		btCancel.setBackground(Color.white);
		btCancel.setForeground(Color.black);
		
		add(tfCPF);
		add(tfSenha);
		add(btLog);
		add(btCancel);
	}
	
	private void event() {
		btLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gerente geren = DAOGeren.getGeren();
				ArrayList<Vendedor> vends = DAOVende.verVend();
				boolean testg=false;
				boolean testv=false;
				int i=0;
				if(tfCPF.getText().equals(geren.getCpf()) && String.valueOf(tfSenha.getPassword()).equals(geren.getSenha())) {
					testg=true;
				}
				for(i=0; i<vends.size(); i++) {
					if(tfCPF.getText().equals(vends.get(i).getCpf()) && String.valueOf(tfSenha.getPassword()).equals(vends.get(i).getSenha())) {
						testv=true;
					}
				}
				if(testg) {
					LoginFrame.frame.setVisible(false);
					MenuGFrame.criarMenuG();
				}else if(testv) {
					LoginFrame.frame.setVisible(false);
					MenuVFrame.criarMenuV();
				}else {
					JOptionPane.showMessageDialog(null, "CPF ou Senha Incorretos!", "AVISO", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fechando...");
				System.exit(0);
			}
		});
	}
	
	public static void criarLogin() {
		SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
		frame = new LoginFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width-frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
		}
	});
	}	
}
