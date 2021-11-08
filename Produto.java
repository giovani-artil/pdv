package pdv;

public class Produto {

	private String nome, cod, datFab, datVal;
	private int qntd;
	private float valorV, valorR;
	
	public Produto(String nome, String cod, int qntd, float valorV, float valorR, String datFab, String datVal) {
		this.nome = nome;
		this.cod = cod;
		this.qntd = qntd;
		this.valorV = valorV;
		this.valorR = valorR;
		this.datFab = datFab;
		this.datVal = datVal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getQntd() {
		return qntd;
	}

	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

	public float getValorV() {
		return valorV;
	}

	public void setValorV(float valorV) {
		this.valorV = valorV;
	}

	public float getValorR() {
		return valorR;
	}

	public void setValorR(float valorR) {
		this.valorR = valorR;
	}

	public String getDatFab() {
		return datFab;
	}

	public void setDatFab(String datFab) {
		this.datFab = datFab;
	}

	public String getDatVal() {
		return datVal;
	}

	public void setDatVal(String datVal) {
		this.datVal = datVal;
	}
	
}
