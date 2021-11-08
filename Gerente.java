package pdv;

public class Gerente extends Funcionario{
	
	private static float lucro;
	
	public Gerente(String nome, String senha, String email, String tele, String cpf) {
		super(nome, senha, email, tele, cpf);
	}

	public static float getLucro() {
		return lucro;
	}

	public static void setLucro(float lucro) {
		Gerente.lucro = lucro;
	}
	
}
