package br.com.AppEsporteAPI.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TVenda")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DataVenda", nullable = false)
	private Date datavenda;

	@Column(name = "NomeLoja", length = 100, nullable = false)
	private String nomeloja;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)//DETACH = funcionando // ALL, orphanRemoval = true)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)//DETACH = funcionando//ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<ItemVenda> itensvenda;

	public Venda() {
		//itensvenda = new ArrayList<ItemVenda>();
	}

	public Venda(Integer id, Date dataVenda, String nomeLoja) {
		this();
		setId(id);
		setDatavenda(dataVenda);
		setNomeloja(nomeLoja);
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

	public Date getDatavenda() {
		return datavenda;
	}

	public void setDatavenda(Date datavenda) {
		this.datavenda = datavenda;
	}

	public String getNomeloja() {
		return nomeloja;
	}

	public void setNomeloja(String nomeloja) {
		this.nomeloja = nomeloja;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return String.format("Id da venda: %d \n"
				+ " Data da venda: %s \n"
				+ " Loja da venda: %s \n"
				+ " Nome do cliente %s \n",
				this.getId(), 
				dateFormat.format(this.getDatavenda()),
				this.getNomeloja(),
				this.getCliente().getNome()
				);
	}
}