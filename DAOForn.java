package dao;

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import pdv.Fornecedor;
import pdv.Vendedor;


public abstract class DAOForn {

	public static void cadForn(Fornecedor forn) {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "fornecedores.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(forn.getNome()+"@"+forn.getEnd()+"@"+forn.getProd()+"@"+forn.getTele()+"@"+forn.getCnpj());
			bw.newLine();
			
			bw.close();
			fw.close();
			
			JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com sucesso");
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ArrayList<Fornecedor> verForn(){
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "fornecedores.txt");
		
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("@");
				Fornecedor forn = new Fornecedor(dados[0], dados[1], dados[2], dados[3], dados[4]);
				fornecedores.add(forn);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return fornecedores;
	}
	
	public static void editForn(ArrayList<Fornecedor> fornecedores) {
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "fornecedores.txt");
		
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
            
            for(Fornecedor forn: fornecedores) {
            	bw.write(forn.getNome()+"@"+forn.getEnd()+"@"+forn.getProd()+"@"+forn.getTele()+"@"+forn.getCnpj());
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
