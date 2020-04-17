package br.com.AppEsporteAPI.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TCliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nome", nullable = false, length = 200)
	private String nome;

	@Column(name = "DDD", nullable = false, precision = 2)
	private int ddd;

	@Column(name = "Telefone", nullable = false, precision = 11)
	private long telefone;

	@Column(name = "Email", nullable = false, length = 300)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DataCadastro", nullable = false, columnDefinition = "datetime")
	private Date datacadastro;

	@Column(name = "Ativo", nullable = false, columnDefinition = "boolean default true")
	private boolean isativo;

	public Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public boolean isIsativo() {
		return isativo;
	}

	public void setIsativo(boolean isativo) {
		this.isativo = isativo;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return String.format("%s - %d - %d - %s - %s - %s", this.getNome(), this.getDdd(), this.getTelefone(),
				this.getEmail(), this.isIsativo(), dateFormat.format(this.getDatacadastro()));
	}

}
