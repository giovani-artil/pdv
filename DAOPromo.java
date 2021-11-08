package dao;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.swing.JOptionPane;

import pdv.Produto;
import pdv.Promocao;

public abstract class DAOPromo {

	public static void cadProd(Promocao promo) {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "promocoes.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(promo.getNome()+"@"+promo.getDesc()+"%"+"@");
			bw.newLine();
			
			bw.close();
			fw.close();
			
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ArrayList<Promocao> verPromo(){
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "promocoes.txt");
		
		ArrayList<Promocao> promos = new ArrayList<Promocao>();
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("@");
				Promocao promo = new Promocao(dados[0], dados[1]);
				promos.add(promo);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return promos;
	}
}
