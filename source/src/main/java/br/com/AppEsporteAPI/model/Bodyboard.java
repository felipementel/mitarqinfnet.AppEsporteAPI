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
@Table(name = "TBodyboard")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Bodyboard extends Produto {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;

	@Column(name = "Tamanho", nullable = false)
	private double tamanho;

	@Column(name = "Preco", nullable = false)
	private float preco;

	@Column(name = "Cor", nullable = false, length = 200)
	private String cor;

	@Column(name = "Bloco", nullable = false, length = 200)
	private String bloco;

	public Bodyboard() {
		super();
	}

	public Bodyboard(double tamanho, float preco, String cor, String bloco) {
		this();
		this.setTamanho(tamanho);
		this.setPreco(preco);
		this.setCor(cor);
		this.setBloco(bloco);
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
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

		return String.format("%s - %s - %s - %f - %f \n", this.getBloco(), this.getCor(), this.getDescricao(),
				this.getPreco(), this.getTamanho());
	}
}