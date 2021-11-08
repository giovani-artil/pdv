package pdv;

public class Promocao {
	
	private String nome, desc;
	
	public Promocao(String nome, String desc) {
		this.nome = nome;
		this.desc = desc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
