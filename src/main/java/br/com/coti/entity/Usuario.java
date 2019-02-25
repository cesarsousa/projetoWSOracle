package br.com.coti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tabelausuario")
@SequenceGenerator(name="tabelasequencia",sequenceName="tabelasequencia")
public class Usuario {
	
	private static final long SerialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tabelasequencia")
	@Id
	private Long id;
	
	@Column(length=15, unique = true)
	private String numero;
	
	@Column(length=50)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	

	public Usuario() {
		super();
	}

	public Usuario(Long id, String numero, String nome, Date dataCadastro) {
		super();
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
	

}
