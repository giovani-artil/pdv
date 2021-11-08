package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pdv.Gerente;

public class MenuGFrame extends JFrame{
	
	public static MenuGFrame frame;
	public static Container container;
	
	private JMenuBar menubar;
	private JMenu visu, cad, edit, outros;
	private JMenuItem forn, promo, func, prod, geren, lucro, cadfun, cadforn, cadprod, editfun,
	editforn, editprod, editgeren, sair;
	
	public MenuGFrame() {
		comp();
		event();
	}
	
	private void comp() {
		setBounds(0, 0, 1366, 685);
		setResizable(false);
		
		container = getContentPane();
		
		menubar = new JMenuBar();
		
		visu = new JMenu("Visualizar");
		forn = new JMenuItem("Fornecedor");
		promo = new JMenuItem("Promoções");
		func = new JMenuItem("Funcionários");
		prod = new JMenuItem("Produtos");
		geren = new JMenuItem("Gerente");
		lucro = new JMenuItem("Lucro");
		
		cad = new JMenu("Cadastros");
		cadfun = new JMenuItem("Funcionário");
		cadforn = new JMenuItem("Fornecedor");
		cadprod = new JMenuItem("Produto");
		
		edit = new JMenu("Editar");
		editfun = new JMenuItem("Funcionários");
		editforn = new JMenuItem("Fornecedores");
		editprod = new JMenuItem("Produtos");
		editgeren = new JMenuItem("Gerente");
		
		outros = new JMenu("Outros");
		sair = new JMenuItem("Sair");
		
		visu.add(forn);
		visu.add(func);
		visu.add(geren);
		visu.add(prod);
		visu.add(promo);
		visu.add(lucro);
		
		cad.add(cadforn);
		cad.add(cadfun);
		cad.add(cadprod);
		
		edit.add(editforn);
		edit.add(editfun);
		edit.add(editprod);
		edit.add(editgeren);
		
		outros.add(sair);
		
		menubar.add(visu);
		menubar.add(cad);
		menubar.add(edit);
		menubar.add(outros);
		
		MenuGPanel panel = new MenuGPanel();
		container.removeAll();
		container.add(panel);
		container.validate();
		
		setJMenuBar(menubar);
	}
	
	private void event() {
		
		forn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuFornGPanel panel = new VisuFornGPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});
		
		func.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuFunGPanel panel = new VisuFunGPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});
		
		geren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuGerenGPanel panel = new VisuGerenGPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});

		prod.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuProdGPanel panel = new VisuProdGPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});

		promo.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				VisuPromoGPanel panel = new VisuPromoGPanel();
				container.removeAll();
				container.add(panel);
				container.validate();
			}
		});

		lucro.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "LUCRO OBTIDO: R$"+Gerente.getLucro(), "LUCRO", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		cadforn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadFornPanel panel = new CadFornPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		cadfun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadFunPanel panel = new CadFunPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		cadprod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadProdPanel panel = new CadProdPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		editforn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EdNFornPanel panel = new EdNFornPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();
			}
		});
		
		editfun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EdNFunPanel panel = new EdNFunPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		editprod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EdNProdPanel panel = new EdNProdPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		editgeren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditGerenPanel panel = new EditGerenPanel();
				MenuGFrame.container.removeAll();
				MenuGFrame.container.add(panel);
				MenuGFrame.container.validate();		
			}
		});
		
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuGFrame.frame.setVisible(false);
				LoginFrame.criarLogin();		
			}
		});
	}
	
	public static void criarMenuG() {
		SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
		frame = new MenuGFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width-frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
		}
	});
	}
}