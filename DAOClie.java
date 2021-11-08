package dao;

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import pdv.Cliente;
import pdv.Vendedor;

public abstract class DAOClie {

	public static void cadClie(Cliente cli) {
		File dir = new File("C:\\BancoDeDados");
		dir.mkdir();
		File arquivo = new File(dir, "clientes.txt");
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(cli.getNome()+"@"+cli.getCpf()+"@"+cli.getRua()+"@"+cli.getBairro());
			bw.newLine();
			
			bw.close();
			fw.close();
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso");
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static ArrayList<Cliente> verCli(){
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "clientes.txt");
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String linha = br.readLine();
				String [] dados = linha.split("@");
				Cliente cli = new Cliente(dados[0], dados[1], dados[2], dados[3]);
				clientes.add(cli);
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public static void editCli(ArrayList<Cliente> clientes) {
		File dir = new File("C:\\BancoDeDados");
		File arquivo = new File(dir, "clientes.txt");
		
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
            
            for(Cliente cli: clientes) {
            	bw.write(cli.getNome()+"@"+cli.getCpf()+"@"+cli.getRua()+"@"+cli.getBairro());
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
