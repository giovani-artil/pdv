package dao;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pdv.Produto;
import pdv.Vendedor;

public abstract class DAOVende {
	
	public static void cadVende(Vendedor vend) {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "vendedores.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(vend.getNome()+"#"+vend.getSenha()+"#"+vend.getEmail()+"#"+vend.getTele()+"#"+vend.getCpf());
			bw.newLine();
			
			bw.close();
			fw.close();
			
			JOptionPane.showMessageDialog(null, "Vendedor Cadastrado com sucesso");
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ArrayList<Vendedor> verVend(){
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "vendedores.txt");
		
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("#");
				Vendedor vend = new Vendedor(dados[0], dados[1], dados[2], dados[3], dados[4]);
				vendedores.add(vend);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vendedores;
	}
	
	public static void editVende(ArrayList<Vendedor> vendedores) {
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "vendedores.txt");
		
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
            
            for(Vendedor vend: vendedores) {
            	bw.write(vend.getNome()+"#"+vend.getSenha()+"#"+vend.getEmail()+"#"+vend.getTele()+"#"+vend.getCpf());
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
