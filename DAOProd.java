package dao;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pdv.Produto;

public abstract class DAOProd {

	public static void cadProd(Produto prod) {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "produtos.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(prod.getNome()+"@"+prod.getCod()+"@"+prod.getQntd()+"@"+prod.getValorV()+"@"+prod.getValorR()+"@"+prod.getDatFab()+"@"+prod.getDatVal());
			bw.newLine();
			
			bw.close();
			fw.close();
			
			JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso");
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ArrayList<Produto> verProd(){
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "produtos.txt");
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("@");
				Produto prod = new Produto(dados[0], dados[1], Integer.parseInt(dados[2]), Float.parseFloat(dados[3]), Float.parseFloat(dados[4]), dados[5], dados[6]);
				produtos.add(prod);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public static void editProd(ArrayList<Produto> produtos) {
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "produtos.txt");
		
		try{
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("");

            bw.close();
            fw.close();

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,e);
        }
		
		try {
			FileWriter fw = new FileWriter(arquivo,false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Produto prod: produtos) {
            	bw.write(prod.getNome()+"@"+prod.getCod()+"@"+prod.getQntd()+"@"+prod.getValorV()+"@"+prod.getValorR()+"@"+prod.getDatFab()+"@"+prod.getDatVal());
            	bw.newLine();
            }
            
            bw.write("");
            
            bw.close();
            fw.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
