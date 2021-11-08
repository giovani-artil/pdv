package dao;

import java.io.*;
import java.net.URL;

import javax.swing.JOptionPane;

import pdv.Gerente;
import pdv.Vendedor;

public abstract class DAOGeren {
	
	public static void editGerent(Gerente geren) {
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "gerente.txt");
		
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
            
            
            bw.write(geren.getNome()+"#"+geren.getSenha()+"#"+geren.getEmail()+"#"+geren.getTele()+"#"+geren.getCpf());
            bw.newLine();
            
            
            bw.write("");
            
            bw.close();
            fw.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public static Gerente getGeren() {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "gerente.txt");
		
		Gerente geren = null;
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("#");
				geren = new Gerente(dados[0], dados[1], dados[2], dados[3], dados[4]);
			}
			
			br.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return geren;
	}
	
	public static void criaGeren() {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "gerente.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
				
				Gerente geren = new Gerente("gerente", "123", "gere", "4002-8922", "12345");
				
				FileWriter fw = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(geren.getNome()+"#"+geren.getSenha()+"#"+geren.getEmail()+"#"+geren.getTele()+"#"+geren.getCpf());
				bw.newLine();
				
				bw.close();
				fw.close();
			}
				
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
