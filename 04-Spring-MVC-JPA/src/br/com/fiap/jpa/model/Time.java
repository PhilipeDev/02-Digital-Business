package br.com.fiap.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="time",sequenceName="SQ_T_TIME",allocationSize=1)
public class Time {

	@Id
	@Column(name="cd_time")
	@GeneratedValue(generator="time",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_time",length=100,nullable=false)
	private String nome;
	
	@Column(name="st_classificado")
	private boolean classificado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}
	
}
