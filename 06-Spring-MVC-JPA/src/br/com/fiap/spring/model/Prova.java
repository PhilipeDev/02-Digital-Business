package br.com.fiap.spring.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="prova", allocationSize=1)
public class Prova {

	@Id
	@GeneratedValue(generator="prova", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Future
	private Calendar data;
	
	@DecimalMax("20")
	@DecimalMin("0")
	private float notaMaxima;
	
	@NotBlank
	private String assunto;
	
	private boolean realizado;
	
	private Tipo tipo;
	
	@ManyToOne
	private Disciplina disciplina;

	
	
	//getters and setter's
	
	public int getCodigo() {
		return codigo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public float getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(float notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
