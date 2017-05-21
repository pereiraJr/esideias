package ideias.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String senha;
	private Integer matricula;
	private boolean aluno;
	@NotEmpty
	private String email;
	@NotEmpty
	private String login;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@OneToMany(mappedBy="usuario")
	private List<Ideias> Ideias = new ArrayList<>();

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Ideias> getIdeias() {
		return Ideias;
	}
	public void setIdeias(List<Ideias> ideias) {
		Ideias = ideias;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public boolean isAluno() {
		return this.matricula != null;
	}
	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	
		/**
		 * 
		 */
}

