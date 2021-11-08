package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuVFrame extends JFrame{
	
	public static MenuVFrame frame;
	public static Container container;
	
	private JMenuBar menubar;
	private JMenu visu, cad, edit, vend, outros;
	private JMenuItem client, prod, promo, cadclient, editclient, vendn, vendd, sair;
	
	public MenuVFrame() {
		comp();
		event();
	}
	
	private void comp() {
		setBounds(0, 0, 1366, 685);
		setResizable(false);
		
		container = getContentPane();
		
		MenuVPanel panel = new MenuVPanel();
		container.removeAll();
		container.add(panel);
		container.validate();
		
		menubar = new JMenuBar();
		
		visu = new JMenu("Visualizar");
		client = new JMenuItem("Clientes");
		prod = new JMenuItem("Produtos");
		promo = new JMenuItem("Promoções");
		
		cad = new JMenu("Cadastro");
		cadclient = new JMenuItem("Cliente");
		
		edit = new JMenu("Editar");
		editclient = new JMenuItem("Cliente");
		
		vend = new JMenu("Venda");
		vendn = new JMenuItem("Normal");
		vendd = new JMenuItem("Delivery");
		
		outros = new JMenu("Outros");
		sair = new JMenuItem("Sair");
		
		visu.add(client);
		visu.add(prod);
		visu.add(promo);
		
		cad.add(cadclient);
		
		edit.add(editclient);
		
		vend.add(vendn);
		vend.add(vendd);
		
		outros.add(sair);
		
		menubar.add(visu);
		menubar.add(cad);
		menubar.add(edit);
		menubar.add(vend);
		menubar.add(outros);
		
		setJMenuBar(menubar);
	}
	
	private void event() {
		client.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuClieVPanel panel = new VisuClieVPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});
		
		prod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuProdVPanel panel = new VisuProdVPanel();
				container.removeAll();
				container.add(panel);
				container.validate();		
			}
		});
		
		promo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuPromoVPanel panel = new VisuPromoVPanel();
				container.removeAll();
				container.add(panel);
				container.validate();		
			}
		});
		
		cadclient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadCliePanel panel = new CadCliePanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();		
			}
		});
		
		editclient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EdNCliePanel panel = new EdNCliePanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();		
			}
		});
		
		vendn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VendaNProdPanel panel = new VendaNProdPanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
		
		vendd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VendaNCliePanel panel = new VendaNCliePanel();
				MenuVFrame.container.removeAll();
				MenuVFrame.container.add(panel);
				MenuVFrame.container.validate();
			}
		});
		
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuVFrame.frame.setVisible(false);
				LoginFrame.criarLogin();		
			}
		});
	}
	
	public static void criarMenuV() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
			frame = new MenuVFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation((tela.width-frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
			frame.setVisible(true);
			}
		});
	}
}
