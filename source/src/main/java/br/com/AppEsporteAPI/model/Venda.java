package br.com.AppEsporteAPI.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TVenda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DataVenda", nullable = false)
	private Date dataVenda;
	
	@Column(name = "NomeLoja", length = 100)
	private String nomeLoja;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List<ItemVenda> itensvenda;

	public Venda() {
	}

	public Venda(Integer id, Date dataVenda, Cliente cliente) {
		this();
		setId(id);
		setDataVenda(dataVenda);
		setCliente(cliente);
	}
	
	public Venda(Date dataVenda, Cliente cliente) {
		this();
		setDataVenda(dataVenda);
		setCliente(cliente);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getItensvenda() {
		return itensvenda;
	}

	public void setItensvenda(List<ItemVenda> itensvenda) {
		this.itensvenda = itensvenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date _dataVenda) {
		dataVenda = _dataVenda;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return String.format("Data da venda: %s", dateFormat.format(this.getDataVenda()));
	}
}