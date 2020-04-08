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
	private String Nome;

	@Column(name = "DDD", nullable = false, precision = 2)
	private int DDD;

	@Column(name = "Telefone", nullable = false, precision = 11)
	private long Telefone;

	@Column(name = "Email", nullable = false, length = 300)
	private String Email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DataCadastro", nullable = false, columnDefinition = "datetime")
	private Date Cadastro;

	@Column(name = "Ativo", nullable = false, columnDefinition = "boolean default true")
	private boolean isAtivo;

	public Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int dDD) {
		DDD = dDD;
	}

	public long getTelefone() {
		return Telefone;
	}

	public void setTelefone(long telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getCadastro() {
		return Cadastro;
	}

	public void setCadastro(Date cadastro) {
		Cadastro = cadastro;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return String.format("%s - %d - %d - %s - %s - %s", this.getNome(), this.getDDD(), this.getTelefone(),
				this.getEmail(), this.isAtivo(), dateFormat.format(this.getCadastro()));
	}

}
