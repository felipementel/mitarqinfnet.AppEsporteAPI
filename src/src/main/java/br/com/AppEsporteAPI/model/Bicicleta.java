package br.com.AppEsporteAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TBicicleta")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Bicicleta extends Produto {
	
	@Column(name = "Cor", nullable = false, length = 200)
	private String cor;

	@Column(name = "TamanhoAro", nullable = false)
	private int tamanhoaro;

	@Column(name = "TamanhoQuadro", nullable = false)
	private double tamanhoquadro;

	@Column(name = "Preco", nullable = false)
	private float preco;

	public Bicicleta() {
		super();
	}

	public Bicicleta(String cor, int tamanhoAro, double tamanhoQuadro, float preco) {
		super();
		this.setCor(cor);
		this.setTamanhoaro(tamanhoAro);
		this.setTamanhoquadro(tamanhoQuadro);
		this.setPreco(preco);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getTamanhoaro() {
		return tamanhoaro;
	}

	public void setTamanhoaro(int tamanhoaro) {
		this.tamanhoaro = tamanhoaro;
	}

	public double getTamanhoquadro() {
		return tamanhoquadro;
	}

	public void setTamanhoquadro(double tamanhoquadro) {
		this.tamanhoquadro = tamanhoquadro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %f - %d - %f \n", this.getCor(), this.getDescricao(), this.getPreco(),
				this.getTamanhoaro(), this.getTamanhoquadro());
	}
}