package br.com.fiap.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="disciplina", allocationSize=1)
public class Disciplina {

	@Id
	@GeneratedValue(generator="disciplina", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Size(min=5)
	@NotBlank(message="O nome é obrigatório")
	private String nome;

	
	
	//Getter's and Setter's
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
	
	
	
	
}
