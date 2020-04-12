package br.com.AppEsporteAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBicicleta")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Bicicleta extends Produto {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;

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
		this();
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

	public int getIdProduto() {
		return produto.getId();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %f - %d - %f \n", this.getCor(), this.getDescricao(), this.getPreco(),
				this.getTamanhoaro(), this.getTamanhoquadro());
	}
}